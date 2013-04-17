package com.htc.sample.bleexample;

import com.htc.android.bluetooth.le.gatt.BleGattID;

/**
 * UUIDs of GATT services as per the GATT specification:
 * http://developer.bluetooth.org/gatt/services/Pages/ServicesHome.aspx
 */
public class BleServices {
	public static final BleGattID ALERT_NOTIFICATION = new BleGattID(
			"00001811-0000-1000-8000-00805f9b34fb");
	public static final BleGattID BATTERY_SERVICE = new BleGattID(
			"0000180F-0000-1000-8000-00805f9b34fb");
	public static final BleGattID BLOOD_PRESSURE = new BleGattID(
			"00001810-0000-1000-8000-00805f9b34fb");
	public static final BleGattID CURRENT_TIME = new BleGattID(
			"00001805-0000-1000-8000-00805f9b34fb");
	public static final BleGattID CYCLING_SPEED_AND_CADENCE = new BleGattID(
			"00001816-0000-1000-8000-00805f9b34fb");
	public static final BleGattID DEVICE_INFORMATION = new BleGattID(
			"0000180A-0000-1000-8000-00805f9b34fb");
	public static final BleGattID GENERIC_ACCESS = new BleGattID(
			"00001800-0000-1000-8000-00805f9b34fb");
	public static final BleGattID GENERIC_ATTRIBUTE = new BleGattID(
			"00001801-0000-1000-8000-00805f9b34fb");
	public static final BleGattID GLUCOSE = new BleGattID(
			"00001808-0000-1000-8000-00805f9b34fb");
	public static final BleGattID HEALTH_THERMOMETER = new BleGattID(
			"00001809-0000-1000-8000-00805f9b34fb");
	public static final BleGattID HEART_RATE = new BleGattID(
			"0000180D-0000-1000-8000-00805f9b34fb");
	public static final BleGattID HUMAN_INTERFACE_DEVICE = new BleGattID(
			"00001812-0000-1000-8000-00805f9b34fb");
	public static final BleGattID IMMEDIATE_ALERT = new BleGattID(
			"00001802-0000-1000-8000-00805f9b34fb");
	public static final BleGattID LINK_LOSS = new BleGattID(
			"00001803-0000-1000-8000-00805f9b34fb");
	public static final BleGattID NEXT_DST_CHANGE = new BleGattID(
			"00001807-0000-1000-8000-00805f9b34fb");
	public static final BleGattID PHONE_ALERT_STATUS = new BleGattID(
			"0000180E-0000-1000-8000-00805f9b34fb");
	public static final BleGattID REFERENCE_TIME_UPDATE = new BleGattID(
			"00001806-0000-1000-8000-00805f9b34fb");
	public static final BleGattID RUNNING_SPEED_AND_CADENCE = new BleGattID(
			"00001814-0000-1000-8000-00805f9b34fb");
	public static final BleGattID SCAN_PARAMETERS = new BleGattID(
			"00001813-0000-1000-8000-00805f9b34fb");
	public static final BleGattID TX_POWER = new BleGattID(
			"00001804-0000-1000-8000-00805f9b34fb");
}
