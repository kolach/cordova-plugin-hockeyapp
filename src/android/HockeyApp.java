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


public class HockeyApp extends CordovaPlugin {

	String appId;


	/**
	 * Actions the HockeyAppPlugin can parse.
	 */
	public enum DefinedAction {
		register // registers HockeyApp with tocken
	};


	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

//		try {
//			if (action.equals("getAppName")) {
//				PackageManager packageManager = this.cordova.getActivity().getPackageManager();
//				ApplicationInfo ai = packageManager.getApplicationInfo(this.cordova.getActivity().getPackageName(), 0);
//				CharSequence al = packageManager.getApplicationLabel(ai);
//				callbackContext.success((String) al);
//				return true;
//			}
//			return false;
//		} catch (NameNotFoundException e) {
//			callbackContext.success("N/A");
//			return true;
//		}


		try {

			DefinedAction definedAction = DefinedAction.valueOf(action);
			PluginResult result = null;

			switch (definedAction) {
				case register:
					result = register(args);
					break;
			}


			result.setKeepCallback(false);
			callbackContext.sendPluginResult(result);
			return true;


		} catch (Exception e) {
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

}
