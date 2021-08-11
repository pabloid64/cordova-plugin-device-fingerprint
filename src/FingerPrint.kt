package org.apache.cordova.plugin

import com.fingerprintjs.android.fingerprint.FingerprinterFactory
import com.fingerprintjs.android.fingerprint.Configuration
import org.apache.cordova.CallbackContext
import org.apache.cordova.CordovaPlugin
import org.json.JSONArray
import org.json.JSONException

class FingerprintAndroidCordovaPlugin : CordovaPlugin() {

    val fingerprinter = FingerprinterFactory.getInstance(
        cordova.getActivity().applicationContext,
        Configuration(version = 3)
    )

    @Throws(JSONException::class)
    fun execute(action: String, args: JSONArray, callbackContext: CallbackContext): Boolean {
        if (action == "fingerprint") {
            getFingerprint(callbackContext)
            return true
        }
        if (action == "deviceId") {
            getDeviceId(callbackContext)
            return true
        }

        return false
    }

    private fun getFingerprint(callbackContext: CallbackContext) {
        fingerprinter.getFingerprint { fingerprintResult ->
            callbackContext.success("deviceId")
        }
    }

    private fun getDeviceId(callbackContext: CallbackContext) {
        callbackContext.success("deviceId")
    }

}