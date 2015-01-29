# Cordova HockeyApp plugin

Integrates HockeyApp SDK

## Installation

### With cordova-cli

If you are using [cordova-cli](https://github.com/apache/cordova-cli), install
with:

    cordova plugin add https://github.com/kolach/cordova-plugin-hockeyapp.git

## Use from Javascript

    cordova.hockeyapp.register(token);

    cordova.hockeyapp.reportCrash(message, data);

    cordova.hockeyapp.feedback();


## Credits

Written by [Nick Chistyakov](https://github.com/kolach) at
[AssuredLabor](http://assuredlabor.com/)

Code based on the following posts:

* [com.zengularity.cordova.hockeyapp ](https://github.com/peutetre/cordova-plugin-hockeyapp)
