var exec = require('cordova/exec');


var StartActivity = 
{
	openIntent : function(appName, success, error) {

    		exec(success, error, "StartActivity", "openIntent", [appName]);

	};
module.eports = StartActivity;
