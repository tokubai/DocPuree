package jp.co.tokubai.docpuree.log

import com.cookpad.puree.async.AsyncResult
import com.cookpad.puree.outputs.OutputConfiguration
import com.cookpad.puree.outputs.PureeBufferedOutput
import jp.co.tokubai.docpuree.DocPureeRequestBodyCollectInterceptor
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

class BufferOutMockServer : PureeBufferedOutput() {
    companion object {
        private const val TYPE = "out_fake_api"

        val okHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(DocPureeRequestBodyCollectInterceptor())
                .addInterceptor(MockResponseInterceptor()).build()
    }

    override fun type(): String {
        return TYPE
    }

    override fun configure(conf: OutputConfiguration): OutputConfiguration {
        conf.flushIntervalMillis = 1000 * 3
        conf.maxRetryCount = 3
        return conf
    }

    override fun emit(jsonLogs: MutableList<String>, result: AsyncResult) {
        GlobalScope.launch {
            val request = Request.Builder().url("https://dummy.com").post(jsonLogs.toString().toRequestBody()).build()
            okHttpClient.newCall(request).execute()
            result.success()
        }
    }
}
