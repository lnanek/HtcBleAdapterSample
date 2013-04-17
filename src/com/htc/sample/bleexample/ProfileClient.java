/************************************************************************************
 *
 *  Copyright (C) 2013 HTC (modified)
 *  Copyright (C) 2009-2011 Broadcom Corporation
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 ************************************************************************************/
package com.htc.sample.bleexample;

import java.util.ArrayList;
import java.util.UUID;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.htc.android.bluetooth.le.gatt.BleCharacteristic;
import com.htc.android.bluetooth.le.gatt.BleClientProfile;
import com.htc.android.bluetooth.le.gatt.BleClientService;
import com.htc.android.bluetooth.le.gatt.BleConstants;
import com.htc.android.bluetooth.le.gatt.BleDescriptor;
import com.htc.android.bluetooth.le.gatt.BleGattID;

public class ProfileClient extends BleClientProfile {
	
	private static String TAG = ProfileClient.class.getSimpleName();
	
	private byte mEncryptionLevel = BleConstants.GATT_ENCRYPT_NONE;

	private ServiceClient mService;
	
	private Context mContext;

	public ProfileClient(final Context aContext) {
		super(aContext, new BleGattID(UUID.randomUUID()));
		Log.d(TAG, "Contructor...");
		
		mContext = aContext;
		mService = new ServiceClient(aContext);
				
		ArrayList<BleClientService> services = new ArrayList<BleClientService>();
		services.add(mService);

		init(services, null);
	}

	@Override
	public void onInitialized(boolean success) {
		Log.d(TAG, "onInitialized, success: " + success);
		
		// Note that the super class will call registerProfile.
		super.onInitialized(success);
		
		if (success) {
			broadcast(BleActions.ACTION_INITIALIZED, null);
		} else {
			broadcast(BleActions.ACTION_INITIALIZE_FAILED, null);
		}
	}

	@Override
	public void onDeviceConnected(BluetoothDevice device) {
		Log.d(TAG, "onDeviceConnected");		
		broadcast(BleActions.ACTION_CONNECTED, device);
		
		Log.d(TAG, "setEncryption = " + mEncryptionLevel);
		setEncryption(device, mEncryptionLevel);

		if ( Profile.HEART_RATE == ConnectActivity.PROFILE ) {
			Log.d(TAG, "Registering for heart rate measurement for notifications...");
			mService.registerForNotification(device, 0, BleCharacteristics.HEART_RATE_MEASUREMENT);
		}
		
		// Note that the super class will call refresh.
		super.onDeviceConnected(device);
	}

	@Override
	public void onDeviceDisconnected(BluetoothDevice device) {
		Log.d(TAG, "onDeviceDisconnected");
		super.onDeviceDisconnected(device);

		broadcast(BleActions.ACTION_DISCONNECTED, device);

		// connectBackground(device);
	}

	@Override
	public void onRefreshed(final BluetoothDevice aDevice) {
		Log.d(TAG, "onRefreshed");
		super.onRefreshed(aDevice);
		broadcast(BleActions.ACTION_REFRESHED, aDevice);
		
		if ( Profile.HEART_RATE == ConnectActivity.PROFILE ) {
			Log.d(TAG, "Configuring heart rate measurement for notifications...");
			final BleCharacteristic characteristic = mService.getCharacteristic(aDevice, 
					BleCharacteristics.HEART_RATE_MEASUREMENT);
	        final byte[] value = BleCharacteristics.getNotificationsConfig();
	        final BleDescriptor clientConfig = characteristic.getDescriptor(
	        		new BleGattID(BleConstants.GATT_UUID_CHAR_CLIENT_CONFIG16));
	        clientConfig.setValue(value);
	        clientConfig.setWriteType(BleConstants.GATTC_TYPE_WRITE);
	        mService.writeCharacteristic(aDevice, 0, characteristic);		
		}
	}

	@Override
	public void onProfileRegistered() {
		Log.d(TAG, "onProfileRegistered");
		super.onProfileRegistered();
		broadcast(BleActions.ACTION_REGISTERED, null);
	}

	@Override
	public void onProfileDeregistered() {
		Log.d(TAG, "onProfileDeregistered");
		super.onProfileDeregistered();
		notifyAll();
	}
	
	private void broadcast(final String aAction, final BluetoothDevice aDevice) {
		Intent intent = new Intent();
		intent.setAction(aAction);
		if ( null != aDevice ) {
			intent.putExtra(BluetoothDevice.EXTRA_DEVICE, aDevice.getAddress());
		}
		mContext.sendBroadcast(intent);		
	}
	
	public void setEncryptionLevel(final byte aEncryptionLevel) {
		Log.d(TAG, "setEncryptionLevel");
		mEncryptionLevel = aEncryptionLevel;
	}

	public void alert(final BluetoothDevice device) {
		Log.d(TAG, "alert");
		
		final BleCharacteristic alertLevelCharacteristic = mService
				.getCharacteristic(device, BleCharacteristics.ALERT_LEVEL);
		if ( null == alertLevelCharacteristic ) {
			Log.d(TAG, "alert failed - could not find alert level characteristic in service");			
			return;
		}
		
		byte[] value = { BleCharacteristics.ALERT_LEVEL_HIGH };
		alertLevelCharacteristic.setValue(value);
		alertLevelCharacteristic
				.setWriteType(BleConstants.GATTC_TYPE_WRITE_NO_RSP);
		mService.writeCharacteristic(device, 0,
				alertLevelCharacteristic);
	}

	public synchronized void deregister() throws InterruptedException {
		Log.d(TAG, "deregister");
		deregisterProfile();
		wait(5000);
	}
	
}
