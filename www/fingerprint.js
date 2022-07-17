module.exports.FingerPrint = {
  getFingerprint: function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "FingerPrint", "fingerprint");
  },
  getDeviceId: function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "FingerPrint", "deviceId");
  },
};
