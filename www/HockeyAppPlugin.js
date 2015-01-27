var exec = require("cordova/exec");

module.exports = {

  register: register,
  reportCrash: reportCrash

};


function getDeferred() {
  var injector = angular.injector(["ng"]);
  var $q = injector.get("$q");
  return $q.defer();
}

function register(token) {
  var deferred = getDeferred();
  exec(deferred.resolve, deferred.reject, "HockeyApp", "register", [token]);
  return deferred.promise;
}

function reportCrash(error) {
  var deferred = getDeferred();
  exec(deferred.resolve, deferred.reject, "HockeyApp", "reportCrash", [error]);
  return deferred.promise;
}