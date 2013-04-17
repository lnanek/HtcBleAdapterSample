package com.htc.sample.bleexample;

import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Persists preferences for the app.
 * 
 */
public class Prefs {

	private final SharedPreferences mPrefs;

	public Prefs(final Context context) {
		mPrefs = PreferenceManager.getDefaultSharedPreferences(context
				.getApplicationContext());
	}

	public DeviceSettings getLastDeviceSettings() {
		final DeviceSettings lastSettings = new DeviceSettings();
		final Bundle bundle = new Bundle();
		for (Map.Entry<String, ?> pref : mPrefs.getAll().entrySet()) {
			final String key = pref.getKey();
			final Object value = pref.getValue();
			if (value instanceof String) {
				bundle.putString(key, (String) value);
			} else if (value instanceof Integer) {
				bundle.putInt(key, (Integer) value);
			} else if (value instanceof Byte) {
				bundle.putByte(key, (Byte) value);
			}
			// XXX Handle just enough cases to restore DeviceSettings for now.
		}
		lastSettings.fromBundle(bundle);
		return lastSettings;
	}

	public DeviceSettings setLastDeviceSettings(
			final DeviceSettings aLastSelection) {
		final Editor edit = mPrefs.edit();
		if (null == aLastSelection) {
			edit.clear();
		} else {
			final Bundle bundle = aLastSelection.toBundle();
			for ( final String key : bundle.keySet() ) {
				final Object value = bundle.get(key);
				if ( value instanceof String ) {
					edit.putString(key, (String) value);
				} else if ( value instanceof Integer ) {
					edit.putInt(key, (Integer) value);
				} else if ( value instanceof Byte ) {
					edit.putInt(key, (Byte) value);
				}
				// XXX Handle just enough cases to save DeviceSettings for now.
			}
		}
		edit.commit();
		return aLastSelection;
	}

}
