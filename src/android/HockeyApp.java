package com.assuredlabor.cordova.hockeyapp;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.pm.ApplicationInfo;

public class HockeyApp extends CordovaPlugin {

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


		if (action.equals("register")) {


			return true;
		}

		return false;

	}

}
