package com.assuredlabor.cordova.hockeyapp;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.FeedbackManager;
import net.hockeyapp.android.UpdateManager;

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
			PluginResult result = null;

			switch (definedAction) {
				case register:
					result = register(args);
					break;
				case reportCrash:
					result = reportCrash(args);
					break;
			}


			result.setKeepCallback(false);
			callbackContext.sendPluginResult(result);
			return true;

		} catch (RuntimeException e) {
			callbackContext.success();
			throw e;
		} catch (JSONException e) {
			callbackContext.error(e.getMessage());
			return false;
		}

	}


	private PluginResult register(JSONArray args) throws JSONException {
		appId = args.getString(0);
		CrashManager.register(cordova.getActivity(), appId);
		UpdateManager.register(cordova.getActivity(), appId);
		return new PluginResult(PluginResult.Status.OK);
	}

	private PluginResult reportCrash(JSONArray args) throws JSONException {
		String message = args.getString(0);
		throw new RuntimeException(message);
	}

}
