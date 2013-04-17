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

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.htc.android.bluetooth.le.gatt.BleConstants;

public class ConnectUi {

	private static final String LOG_TAG = "ConnectUi";

	Button mCancelBackgroundConnection;

	Button mConnectForeground;

	Button mConnectBackground;

	Button mSendAlert;

	Button mSelectDevice;

	TextView mStatusView;

	TextView mDeviceNameView;

	private ConnectActivity mActivity;

	public ConnectUi(final ConnectActivity aActivity) {
		Log.i(LOG_TAG, "ConnectUi");

		mActivity = aActivity;
		mActivity.setContentView(R.layout.main);

		mStatusView = (TextView) mActivity.findViewById(R.id.statusValue);
		mStatusView.setText("Configuring Bluetooth...\n");
		mDeviceNameView = (TextView) mActivity.findViewById(R.id.deviceName);

		mCancelBackgroundConnection = (Button) mActivity
				.findViewById(R.id.cancel);
		mCancelBackgroundConnection.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				aActivity.cancelBackgroundConnection();
			}
		});

		mConnectForeground = (Button) mActivity.findViewById(R.id.foreground);
		mConnectForeground.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				aActivity.startForegroundConnectionAttempts();
			}
		});

		mConnectBackground = (Button) mActivity.findViewById(R.id.background);
		mConnectBackground.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				aActivity.connectBackground();
			}
		});

		mSelectDevice = (Button) mActivity.findViewById(R.id.btn_select);
		mSelectDevice.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				aActivity.onSetupDeviceClicked();
			}
		});

		mSendAlert = (Button) mActivity.findViewById(R.id.btn_alert);
		mSendAlert.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				aActivity.writeAlertLevel();
			}
		});
		mSendAlert.setVisibility( Profile.FIND_ME == ConnectActivity.PROFILE ? View.VISIBLE : View.GONE);

		setConnectionButtonsEnabled(false);
		setProfileButtonsEnabled(false);

	}

	public void showEncryptionSettingsDialog(final DeviceSettings aSettings) {
		final String[] items = new String[] {
				"None", 
				"Encryption",
				"Encryption (No MITM)", 
				"Encryption (MITM)" 
		};

		final AlertDialog.Builder ab = new AlertDialog.Builder(mActivity);
		ab.setTitle("Encryption settings:");
		ab.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface d, int choice) {
				if (choice == 0) {
					aSettings.encryptionLevel = BleConstants.GATT_ENCRYPT_NONE;
				} else if (choice == 1) {
					aSettings.encryptionLevel = BleConstants.GATT_ENCRYPT;
				} else if (choice == 2) {
					aSettings.encryptionLevel = BleConstants.GATT_ENCRYPT_NO_MITM;
				} else if (choice == 3) {
					aSettings.encryptionLevel = BleConstants.GATT_ENCRYPT_MITM;
				}
				mActivity.configure();
			}
		});
		ab.setOnCancelListener(new OnCancelListener() {
			@Override
			public void onCancel(DialogInterface dialog) {
				aSettings.encryptionLevel = DeviceSettings.DEFAULT_ENCRYPTION;
				mActivity.configure();
			}
		});
		ab.show();
	}

	public void showRetrySettingsDialog(final DeviceSettings aSettings) {
		final LinearLayout layout = new LinearLayout(mActivity);
		layout.setOrientation(LinearLayout.VERTICAL);
		final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		
		final TextView retryDelayLabel = new TextView(mActivity);
		retryDelayLabel.setText("Connection retry delay (MS):");
		layout.addView(retryDelayLabel, params);
		
		final EditText retryDelay = new EditText(mActivity);
		retryDelay.setInputType(InputType.TYPE_CLASS_NUMBER);
		layout.addView(retryDelay, params);
		if ( null != aSettings.retryRateMs ) {
			retryDelay.setText(Integer.toString(aSettings.retryRateMs));
		} else {
			retryDelay.setText(Integer.toString(DeviceSettings.DEFAULT_RETRY_RATE));
		}

		final TextView connectionAttemptLabel = new TextView(mActivity);
		connectionAttemptLabel.setText("Connection attempts:");
		layout.addView(connectionAttemptLabel, params);

		final EditText retryAttempts = new EditText(mActivity);
		retryAttempts.setInputType(InputType.TYPE_CLASS_NUMBER);
		layout.addView(retryAttempts, params);
		if ( null != aSettings.connectionRetryAttmpempts ) {
			retryAttempts.setText(Integer.toString(aSettings.connectionRetryAttmpempts));
		} else {
			retryAttempts.setText(Integer.toString(DeviceSettings.DEFAULT_CONNECTION_ATTEMPTS));
		}
				
		final AlertDialog.Builder ab = new AlertDialog.Builder(mActivity);
		ab.setTitle("Foreground connection settings");
		ab.setView(layout);
		ab.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				aSettings.connectionRetryAttmpempts = Integer.parseInt(retryAttempts.getText().toString());
				aSettings.retryRateMs = Integer.parseInt(retryDelay.getText().toString());				
				mActivity.configure();
			}
		});
		ab.setOnCancelListener(new OnCancelListener() {
			@Override
			public void onCancel(DialogInterface dialog) {
				aSettings.retryRateMs = DeviceSettings.DEFAULT_RETRY_RATE;
				aSettings.connectionRetryAttmpempts = DeviceSettings.DEFAULT_CONNECTION_ATTEMPTS;
				mActivity.configure();
			}
		});
		ab.show();
	}
	
	void setConnectionButtonsEnabled(final boolean aEnabled) {
		mConnectForeground.setEnabled(aEnabled);
		mConnectBackground.setEnabled(aEnabled);
	}
	
	void setProfileButtonsEnabled(final boolean aEnabled) {
		mSendAlert.setEnabled(aEnabled);
	}
	
}