package com.assuredlabor.cordova.hockeyapp;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static net.hockeyapp.android.ExceptionHandler.saveException;
import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.FeedbackManager;
import net.hockeyapp.android.UpdateManager;
import net.hockeyapp.android.CrashManagerListener;

import java.lang.RuntimeException;


public class HockeyApp extends CordovaPlugin {

	String appId;


	/**
	 * Actions the HockeyAppPlugin can parse.
	 */
	public enum DefinedAction {
		register, // registers HockeyApp with tocken
		reportCrash // crash report
	};


	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

		try {

			DefinedAction definedAction = DefinedAction.valueOf(action);

			switch (definedAction) {

				case register:
					PluginResult result = null;
					result = register(args);
					result.setKeepCallback(false);
					callbackContext.sendPluginResult(result);
					break;

				case reportCrash:
					final String message = args.getString(0);
					cordova.getActivity().runOnUiThread(new Runnable() {
						@Override
						public void run() {
							Exception e = new Exception(message);
							saveException(e, new CrashManagerListener() {
								public String getDescription() {
									return message;
								}
							});
						}
					});
					callbackContext.success();
					break;
			}

			return true;

		} catch (RuntimeException e) {
			callbackContext.success("Reported error: " + e.toString());
			throw e;

		} catch (JSONException e) {
			callbackContext.error(e.getMessage());
			return false;
		}

	}

	@Override
	public void onResume(boolean multitasking) {
		super.onResume(multitasking);
		checkForCrashes();
	}

	private void checkForCrashes() {
		CrashManager.register(cordova.getActivity(), appId);
	}

	private void checkForUpdates() {
		UpdateManager.register(cordova.getActivity(), appId);
	}


	private PluginResult register(JSONArray args) throws JSONException {
		appId = args.getString(0);
		checkForUpdates();
		checkForCrashes();
		return new PluginResult(PluginResult.Status.OK);
	}

//	private PluginResult reportCrash(JSONArray args) throws JSONException {
////		String message = args.getString(0);
////		throw new RuntimeException(message);
//
//
//
//	}

}
