module.exports = {
    fingerprint : function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "FingerPrint", "fingerprint");
    },
    deviceId : function (successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "FingerPrint", "deviceId");
    },
};