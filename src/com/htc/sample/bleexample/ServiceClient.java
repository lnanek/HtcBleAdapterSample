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

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.htc.android.bluetooth.le.gatt.BleCharacteristic;
import com.htc.android.bluetooth.le.gatt.BleClientService;
import com.htc.android.bluetooth.le.gatt.BleGattID;

public class ServiceClient extends BleClientService {
	
    public static String TAG = ServiceClient.class.getSimpleName();
	
	private Context mContext;
    
    public ServiceClient(final Context aContext) {
        super(getProfileId());
        Log.d(TAG, "Constructor...");
        
        mContext = aContext;
    }
    
    private static BleGattID getProfileId() {
    	switch ( ConnectActivity.PROFILE ) {
    	case FIND_ME:
    		return BleServices.IMMEDIATE_ALERT;
    	case HEART_RATE:
    		return BleServices.HEART_RATE;
    	}
    	
    	throw new RuntimeException("Profile not supported by this demo.");
    }

    @Override
    public void onWriteCharacteristicComplete(int status, BluetoothDevice d,
            BleCharacteristic characteristic) {
        Log.d(TAG, "onWriteCharacteristicComplete");
    	super.onWriteCharacteristicComplete(status, d, characteristic);
    }

    @Override
    public void onRefreshComplete(BluetoothDevice d) {
        Log.d(TAG, "onRefreshComplete");
    	super.onRefreshComplete(d);
    }

    @Override
    public void onSetCharacteristicAuthRequirement(BluetoothDevice d,
            BleCharacteristic characteristic, int instanceID) {
        Log.d(TAG, "onSetCharacteristicAuthRequirement");
    	super.onSetCharacteristicAuthRequirement(d, characteristic, instanceID);
    }

    @Override
    public void onReadCharacteristicComplete(BluetoothDevice d, BleCharacteristic characteristic) {
        Log.d(TAG, "onReadCharacteristicComplete");
    	super.onReadCharacteristicComplete(d, characteristic);
    }

    @Override
    public void onCharacteristicChanged(BluetoothDevice d, BleCharacteristic characteristic) {
        Log.d(TAG, "onCharacteristicChanged");
    	super.onCharacteristicChanged(d, characteristic);
    	
    	broadcast(BleActions.ACTION_NOTIFICATION, d);
    }

	@Override
	public ArrayList<BleCharacteristic> getAllCharacteristics(
			BluetoothDevice d) {
        Log.d(TAG, "getAllCharacteristics");
		return super.getAllCharacteristics(d);
	}

	@Override
	public int[] getAllServiceInstanceIds(BluetoothDevice d) {
        Log.d(TAG, "getAllServiceInstanceIds");
		return super.getAllServiceInstanceIds(d);
	}

	@Override
	public BleCharacteristic getCharacteristic(BluetoothDevice d,
			BleGattID arg1) {
        Log.d(TAG, "getCharacteristic");
		return super.getCharacteristic(d, arg1);
	}

	@Override
	public BleGattID getServiceId() {
        Log.d(TAG, "getServiceId");
		return super.getServiceId();
	}

	@Override
	public void onReadCharacteristicComplete(int status, BluetoothDevice d,
			BleCharacteristic characteristic) {
        Log.d(TAG, "onReadCharacteristicComplete");
		super.onReadCharacteristicComplete(status, d, characteristic);
	}

	@Override
	public int readCharacteristic(BluetoothDevice d, BleCharacteristic characteristic) {
        Log.d(TAG, "readCharacteristic");
		return super.readCharacteristic(d, characteristic);
	}

	@Override
	public void refresh(BluetoothDevice d) {
        Log.d(TAG, "refresh");
		super.refresh(d);
	}

	@Override
	public int registerForNotification(BluetoothDevice d, int instanceId,
			BleGattID characteristic) {
        Log.d(TAG, "registerForNotification");
		return super.registerForNotification(d, instanceId, characteristic);
	}

	@Override
	public int unregisterNotification(BluetoothDevice d, int instanceId,
			BleGattID characteristic) {
        Log.d(TAG, "unregisterNotification");
		return super.unregisterNotification(d, instanceId, characteristic);
	}

	@Override
	public int writeCharacteristic(BluetoothDevice d, int instanceId,
			BleCharacteristic characterisitic) {
        Log.d(TAG, "writeCharacteristic");
		return super.writeCharacteristic(d, instanceId, characterisitic);
	}
	
	private void broadcast(final String aAction, final BluetoothDevice aDevice) {
		Intent intent = new Intent();
		intent.setAction(aAction);
		if ( null != aDevice ) {
			intent.putExtra(BluetoothDevice.EXTRA_DEVICE, aDevice.getAddress());
		}
		mContext.sendBroadcast(intent);		
	}
    
}
