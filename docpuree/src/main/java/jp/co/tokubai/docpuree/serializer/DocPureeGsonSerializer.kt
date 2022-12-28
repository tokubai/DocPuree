package jp.co.tokubai.docpuree.serializer

import com.cookpad.puree.PureeFilter
import com.cookpad.puree.PureeSerializer
import com.google.gson.Gson
import jp.co.tokubai.docpuree.model.SerializedClassInfo
import jp.co.tokubai.docpuree.source.LogHistorySource

class DocPureeGsonSerializer(
    private val gson: Gson,
    private val filters: List<PureeFilter>,
) : PureeSerializer {

    override fun serialize(log: Any): String {
        val json = gson.toJson(log)
        LogHistorySource.serializedClassHistory.add(SerializedClassInfo(log.javaClass, json))

        var filteredJson = json
        filters.forEach { filter ->
            filteredJson = filter.apply(filteredJson)
        }
        LogHistorySource.serializedClassHistory.add(SerializedClassInfo(log.javaClass, filteredJson))

        return json
    }
}
