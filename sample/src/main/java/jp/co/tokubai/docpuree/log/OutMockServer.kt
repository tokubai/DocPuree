package jp.co.tokubai.docpuree.log

import com.cookpad.puree.outputs.OutputConfiguration
import com.cookpad.puree.outputs.PureeOutput
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

class OutMockServer : PureeOutput() {

    override fun type(): String {
        return TYPE
    }

    override fun configure(conf: OutputConfiguration): OutputConfiguration {
        return conf
    }

    override fun emit(jsonLog: String) {
        val request = Request.Builder().url(server.url("/")).post(jsonLog.toRequestBody()).build()
        okHttpClient.newCall(request).execute()
    }

    companion object {
        private const val TYPE = "out_logcat"

        val server = MockWebServer().apply {
            enqueue(MockResponse().setBody("OK"))
            start()
        }

        val okHttpClient = OkHttpClient.Builder().build()
    }
}
