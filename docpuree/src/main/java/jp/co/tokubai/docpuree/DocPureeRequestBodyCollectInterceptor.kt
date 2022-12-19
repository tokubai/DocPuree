package jp.co.tokubai.docpuree

import android.util.Log
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
            Log.d("RequestBody", buffer.readUtf8())
            LogHistorySource.successfullyLoggedJsonHistory.add(buffer.readUtf8())
        }

        return response
    }
}
