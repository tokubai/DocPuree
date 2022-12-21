package jp.co.tokubai.docpuree

import android.util.Log
import jp.co.tokubai.docpuree.source.LogHistorySource
import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer


class DocPureeRequestBodyCollectInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val buffer = Buffer()
        request.body?.writeTo(buffer)


        val response = chain.proceed(request)
        if (response.isSuccessful) {
            val responseBody = buffer.readUtf8()
            Log.d("RequestBody", responseBody)
            LogHistorySource.successfullyLoggedJsonHistory.add(responseBody)
            LogHistorySource.successfullyLoggedJson.value = responseBody
        }

        return response
    }
}
