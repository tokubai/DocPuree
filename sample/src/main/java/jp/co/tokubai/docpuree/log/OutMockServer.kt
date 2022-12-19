package jp.co.tokubai.docpuree.log

import com.cookpad.puree.outputs.OutputConfiguration
import com.cookpad.puree.outputs.PureeOutput
import jp.co.tokubai.docpuree.DocPureeRequestBodyCollectInterceptor
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class OutMockServer : PureeOutput() {

    override fun type(): String {
        return TYPE
    }

    override fun configure(conf: OutputConfiguration): OutputConfiguration {
        return conf
    }

    override fun emit(jsonLog: String) {
        GlobalScope.launch {
            val request =
                Request.Builder().url("https://dummy.com").post(jsonLog.toRequestBody()).build()
            okHttpClient.newCall(request).execute()
        }
    }

    companion object {
        private const val TYPE = "out_logcat"

        val okHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(DocPureeRequestBodyCollectInterceptor())
                .addInterceptor(MockResponseInterceptor()).build()
    }
}
