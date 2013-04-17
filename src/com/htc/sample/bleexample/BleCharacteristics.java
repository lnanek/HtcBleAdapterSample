package com.htc.sample.bleexample;

import com.htc.android.bluetooth.le.gatt.BleConstants;
import com.htc.android.bluetooth.le.gatt.BleGattID;

/**
 * UUIDs and values for working with GATT characteristics.
 *
 */
public class BleCharacteristics {
	
	public static final BleGattID ALERT_CATEGORY_ID = new BleGattID("00002a43-0000-1000-8000-00805f9b34fb");
	public static final BleGattID ALERT_CATEGORY_ID_BIT_MASK = new BleGattID("00002a42-0000-1000-8000-00805f9b34fb");
	public static final BleGattID ALERT_LEVEL = new BleGattID("00002a06-0000-1000-8000-00805f9b34fb");
	public static final BleGattID ALERT_NOTIFICATION_CONTROL_POINT = new BleGattID("00002a44-0000-1000-8000-00805f9b34fb");
	public static final BleGattID ALERT_STATUS = new BleGattID("00002a3f-0000-1000-8000-00805f9b34fb");
	public static final BleGattID APPEARANCE = new BleGattID("00002a01-0000-1000-8000-00805f9b34fb");
	public static final BleGattID BLOOD_PRESSURE_FEATURE = new BleGattID("00002a49-0000-1000-8000-00805f9b34fb");
	public static final BleGattID BLOOD_PRESSURE_MEASUREMENT = new BleGattID("00002a35-0000-1000-8000-00805f9b34fb");
	public static final BleGattID BODY_SENSOR_LOCATION = new BleGattID("00002a38-0000-1000-8000-00805f9b34fb");
	public static final BleGattID CURRENT_TIME = new BleGattID("00002a2b-0000-1000-8000-00805f9b34fb");
	public static final BleGattID DATE_TIME = new BleGattID("00002a08-0000-1000-8000-00805f9b34fb");
	public static final BleGattID DAY_DATE_TIME = new BleGattID("00002a0a-0000-1000-8000-00805f9b34fb");
	public static final BleGattID DAY_OF_WEEK = new BleGattID("00002a09-0000-1000-8000-00805f9b34fb");
	public static final BleGattID DEVICE_NAME = new BleGattID("00002a00-0000-1000-8000-00805f9b34fb");
	public static final BleGattID DST_OFFSET = new BleGattID("00002a0d-0000-1000-8000-00805f9b34fb");
	public static final BleGattID EXACT_TIME_256 = new BleGattID("00002a0c-0000-1000-8000-00805f9b34fb");
	public static final BleGattID FIRMWARE_REVISION_STRING = new BleGattID("00002a26-0000-1000-8000-00805f9b34fb");
	public static final BleGattID HARDWARE_REVISION_STRING = new BleGattID("00002a27-0000-1000-8000-00805f9b34fb");
	public static final BleGattID HEART_RATE_CONTROL_POINT = new BleGattID("00002a39-0000-1000-8000-00805f9b34fb");
	public static final BleGattID HEART_RATE_MEASUREMENT = new BleGattID("00002a37-0000-1000-8000-00805f9b34fb");
	public static final BleGattID IEEE_11073_20601_REGULATORY = new BleGattID("00002a2a-0000-1000-8000-00805f9b34fb");
	public static final BleGattID INTERMEDIATE_CUFF_PRESSURE = new BleGattID("00002a36-0000-1000-8000-00805f9b34fb");
	public static final BleGattID INTERMEDIATE_TEMPERATURE = new BleGattID("00002a1e-0000-1000-8000-00805f9b34fb");
	public static final BleGattID LOCAL_TIME_INFORMATION = new BleGattID("00002a0f-0000-1000-8000-00805f9b34fb");
	public static final BleGattID MANUFACTURER_NAME_STRING = new BleGattID("00002a29-0000-1000-8000-00805f9b34fb");
	public static final BleGattID MEASUREMENT_INTERVAL = new BleGattID("00002a21-0000-1000-8000-00805f9b34fb");
	public static final BleGattID MODEL_NUMBER_STRING = new BleGattID("00002a24-0000-1000-8000-00805f9b34fb");
	public static final BleGattID NEW_ALERT = new BleGattID("00002a46-0000-1000-8000-00805f9b34fb");
	public static final BleGattID PERIPHERAL_PREFERRED_CONNECTION_PARAMETERS = new BleGattID("00002a04-0000-1000-8000-00805f9b34fb");
	public static final BleGattID PERIPHERAL_PRIVACY_FLAG = new BleGattID("00002a02-0000-1000-8000-00805f9b34fb");
	public static final BleGattID RECONNECTION_ADDRESS = new BleGattID("00002a03-0000-1000-8000-00805f9b34fb");
	public static final BleGattID REFERENCE_TIME_INFORMATION = new BleGattID("00002a14-0000-1000-8000-00805f9b34fb");
	public static final BleGattID RINGER_CONTROL_POINT = new BleGattID("00002a40-0000-1000-8000-00805f9b34fb");
	public static final BleGattID RINGER_SETTING = new BleGattID("00002a41-0000-1000-8000-00805f9b34fb");
	public static final BleGattID SERIAL_NUMBER_STRING = new BleGattID("00002a25-0000-1000-8000-00805f9b34fb");
	public static final BleGattID SERVICE_CHANGED = new BleGattID("00002a05-0000-1000-8000-00805f9b34fb");
	public static final BleGattID SOFTWARE_REVISION_STRING = new BleGattID("00002a28-0000-1000-8000-00805f9b34fb");
	public static final BleGattID SUPPORTED_NEW_ALERT_CATEGORY = new BleGattID("00002a47-0000-1000-8000-00805f9b34fb");
	public static final BleGattID SUPPORTED_UNREAD_ALERT_CATEGORY = new BleGattID("00002a48-0000-1000-8000-00805f9b34fb");
	public static final BleGattID SYSTEM_ID = new BleGattID("00002a23-0000-1000-8000-00805f9b34fb");
	public static final BleGattID TEMPERATURE_MEASUREMENT = new BleGattID("00002a1c-0000-1000-8000-00805f9b34fb");
	public static final BleGattID TEMPERATURE_TYPE = new BleGattID("00002a1d-0000-1000-8000-00805f9b34fb");
	public static final BleGattID TIME_ACCURACY = new BleGattID("00002a12-0000-1000-8000-00805f9b34fb");
	public static final BleGattID TIME_SOURCE = new BleGattID("00002a13-0000-1000-8000-00805f9b34fb");
	public static final BleGattID TIME_UPDATE_CONTROL_POINT = new BleGattID("00002a16-0000-1000-8000-00805f9b34fb");
	public static final BleGattID TIME_UPDATE_STATE = new BleGattID("00002a17-0000-1000-8000-00805f9b34fb");
	public static final BleGattID TIME_WITH_DST = new BleGattID("00002a11-0000-1000-8000-00805f9b34fb");
	public static final BleGattID TIME_ZONE = new BleGattID("00002a0e-0000-1000-8000-00805f9b34fb");
	public static final BleGattID TX_POWER_LEVEL = new BleGattID("00002a07-0000-1000-8000-00805f9b34fb");
	public static final BleGattID UNREAD_ALERT_STATUS = new BleGattID("00002a45-0000-1000-8000-00805f9b34fb");
	
	public static final int ALERT_LEVEL_NONE = 0;
	public static final int ALERT_LEVEL_LOW = 1;
	public static final int ALERT_LEVEL_HIGH = 2;

    public static final byte CLIENT_CHAR_CONFIG_FLAG_NOTIFICATIONS_ENABLED = 1;
    public static final byte CLIENT_CHAR_CONFIG_FLAG_INDICATIONS_ENABLED = 1 << 1;
    public static final byte CLIENT_CHAR_CONFIG_RESERVED_BYTE = 0;

    public static int unsignedByteToInt(byte b) {
        return (int) b & 0xFF;
	}
    
    public static final byte[] getNotificationsConfig() {
    	return new byte[] {
    			BleConstants.GATT_CLIENT_CONFIG_NOTIFICATION_BIT,
    			CLIENT_CHAR_CONFIG_RESERVED_BYTE
    	};
    }
    
    public static final byte[] getIndicationsNotificationsConfig() {
    	return new byte[] {
    			BleConstants.GATT_CLIENT_CONFIG_INDICATION_BIT | BleConstants.GATT_CLIENT_CONFIG_NOTIFICATION_BIT,
    			CLIENT_CHAR_CONFIG_RESERVED_BYTE
    	};
    }
}

