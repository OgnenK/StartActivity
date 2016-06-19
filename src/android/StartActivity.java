package cordova-plugin-startActivity;


import org.apache.cordova.CordovaPlugin;

import org.apache.cordova.CallbackContext;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * This class echoes a string called from JavaScript.
 */


public class StartActivity extends CordovaPlugin {


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equals("openIntent")) {

            String appName = args.getString(0);

            this.openIntent(appName, callbackContext);

            return true;

        }

        return false;

    }


    private void openIntent(String appName, CallbackContext callbackContext) {

        if (appName != null && appName.length() > 0) {

		Intent i = new Intent()(INTENT.ACTION_VIEW);
		i.setAction("iac.polimi.ob1.ACTION_VIEW");
		i.putExtra("appName" + appName);
		i.setType("text/plain");
		this.cordova.getActivity().startActivity(Intent.createChooser(i, "Open With"));
            callbackContext.success(appName);

        } else {

            callbackContext.error("Expected one non-empty string argument.");

        }
    }
}
