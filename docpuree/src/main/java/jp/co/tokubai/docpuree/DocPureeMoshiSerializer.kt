package jp.co.tokubai.docpuree

import com.cookpad.puree.PureeSerializer
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class DocPureeMoshiSerializer : PureeSerializer {

    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    override fun serialize(value: Any): String {
        val adapter = moshi.adapter(value.javaClass)
        val json = adapter.toJson(value)
        LogHistorySource.serializedClassHistory.add(value.javaClass.simpleName to json)

        return json
    }
}
