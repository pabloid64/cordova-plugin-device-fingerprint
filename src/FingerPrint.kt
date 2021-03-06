package fingerprint

import com.fingerprintjs.android.fingerprint.FingerprinterFactory
import com.fingerprintjs.android.fingerprint.Configuration
import org.apache.cordova.CallbackContext
import org.apache.cordova.CordovaPlugin
import org.json.JSONArray
import org.json.JSONException

class Fingerprint: CordovaPlugin() {

    val fingerprinter = FingerprinterFactory.getInstance(
        cordova.getActivity().applicationContext,
        Configuration(version = 3)
    )

    @Throws(JSONException::class)
    override fun execute(action: String, args: JSONArray, callbackContext: CallbackContext): Boolean {
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
            callbackContext.success(fingerprintResult.fingerprint)
        }
    }

    private fun getDeviceId(callbackContext: CallbackContext) {
        fingerprinter.getDeviceId { result ->
            callbackContext.success(result.deviceId)
        }
    }
}