var exec = require("cordova/exec");

module.exports = {
  register: register,
  reportCrash: reportCrash,
  feedback: feedback
};


function getDeferred() {
  var injector = angular.injector(["ng"]);
  var $q = injector.get("$q");
  return $q.defer();
}

function execute(command, args) {
  var deferred = getDeferred();
  exec(deferred.resolve, deferred.reject, "HockeyApp", command, args);
  return deferred.promise;
}

function register(token) {
  return execute("register", [token]);
}

function reportCrash(error, data) {
  return execute("reportCrash", [error]);
}

function feedback() {
  return execute("feedback", []);
}