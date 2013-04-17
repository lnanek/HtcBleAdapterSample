package com.htc.sample.bleexample;

import android.os.Bundle;

import com.htc.android.bluetooth.le.gatt.BleConstants;

public class DeviceSettings {
	
	public static final byte DEFAULT_ENCRYPTION = BleConstants.GATT_ENCRYPT;

	public static final int DEFAULT_CONNECTION_ATTEMPTS = 1;

	public static final int DEFAULT_RETRY_RATE = 5000;

	public String name;

	public String address;
	
	public Integer retryRateMs;
	
	public Integer connectionRetryAttmpempts;
	
	public Byte encryptionLevel;
	
	public DeviceSettings() {
	}
	
	public String getDisplayName() {
		if ( null == address ) {
			return "No device selected";
		}
		
		if ( null == name ) {
			return address;
		}
		
		return name + "(" + address + ")";
	}
	
	public Bundle toBundle() {
		final Bundle bundle = new Bundle();
		bundle.putString("name", name);
		bundle.putString("address", address);
		if ( null != retryRateMs ) {
			bundle.putInt("retryRateMs", retryRateMs);
		}
		if ( null != connectionRetryAttmpempts ) {
			bundle.putInt("connectionRetryAttmpempts", connectionRetryAttmpempts);
		}
		if ( null != encryptionLevel ) {
			bundle.putByte("encryptionLevel", encryptionLevel);
		}		
		return bundle;
	}
	
	public void fromBundle(final Bundle aBundle) {
		name = aBundle.getString("name");
		address = aBundle.getString("address");
		retryRateMs = aBundle.getInt("retryRateMs", DEFAULT_RETRY_RATE);
		connectionRetryAttmpempts = aBundle.getInt("connectionRetryAttmpempts", DEFAULT_CONNECTION_ATTEMPTS);
		final Object bundleEncryption = aBundle.get("encryptionLevel");
		if ( null == bundleEncryption ) {
			encryptionLevel = DEFAULT_ENCRYPTION;
		} else {
			final int bundleEncryptionInteger = (Integer) bundleEncryption;
			encryptionLevel = (byte) bundleEncryptionInteger;
		}
	}
}