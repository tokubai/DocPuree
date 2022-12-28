package jp.co.tokubai.docpuree.serializer

import com.cookpad.puree.PureeFilter
import com.cookpad.puree.PureeSerializer
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import jp.co.tokubai.docpuree.model.SerializedClassInfo
import jp.co.tokubai.docpuree.source.LogHistorySource

class DocPureeMoshiSerializer(private val filters: List<PureeFilter>) : PureeSerializer {

    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    override fun serialize(value: Any): String {
        val adapter = moshi.adapter(value.javaClass)
        val json = adapter.toJson(value)

        var filteredJson = json
        filters.forEach { filter ->
            filteredJson = filter.apply(filteredJson)
        }

        LogHistorySource.serializedClassHistory.add(SerializedClassInfo(value.javaClass, filteredJson))

        return json
    }
}
