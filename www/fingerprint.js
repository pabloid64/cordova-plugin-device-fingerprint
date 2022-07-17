module.exports = {
  getFingerprint: function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "Fingerprint", "fingerprint");
  },
  getDeviceId: function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, "Fingerprint", "deviceId");
  },
};
