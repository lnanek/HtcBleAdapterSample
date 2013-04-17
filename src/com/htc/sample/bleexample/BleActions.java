package com.htc.sample.bleexample;

/**
 * Broadcast actions sent and received by the sample code to indicate GATT actions.
 *
 */
public class BleActions {
	
	public static final String ACTION_INITIALIZED = BleActions.class.getName() + ".ACTION_INITIALIZED";
	
	public static final String ACTION_INITIALIZE_FAILED = BleActions.class.getName() + ".ACTION_INITIALIZE_FAILED";
	
	public static final String ACTION_REGISTERED = BleActions.class.getName() + ".ACTION_REGISTERED";
	
	public static final String ACTION_CONNECTED = BleActions.class.getName() + ".ACTION_CONNECTED";
	
	public static final String ACTION_REFRESHED = BleActions.class.getName() + ".ACTION_REFRESHED";
	
	public static final String ACTION_NOTIFICATION = BleActions.class.getName() + ".ACTION_NOTIFICATION";
	
	public static final String ACTION_DISCONNECTED = BleActions.class.getName() + ".ACTION_DISCONNECTED";
	
}

