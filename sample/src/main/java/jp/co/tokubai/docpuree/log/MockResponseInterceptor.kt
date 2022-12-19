package jp.co.tokubai.docpuree.log

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class MockResponseInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val path = chain.request().url.toUri().path
        val mockedResponse = createMockedResponse(path)

        if (mockedResponse.isEmpty()) {
            return chain.proceed(chain.request()).newBuilder().build()
        }

        return Response.Builder()
            .code(200)
            .protocol(Protocol.HTTP_2)
            .message(mockedResponse)
            .body(
                mockedResponse
                    .toByteArray()
                    .toResponseBody(
                        "application/json"
                            .toMediaTypeOrNull()
                    )
            )
            .addHeader("content-type", "application/json")
            .request(chain.request())
            .build()
    }

    private fun createMockedResponse(path: String): String {
        // mock response作成
        return "<mocked response>"
    }
}
