package jp.co.tokubai.docpuree.serializer

import com.cookpad.puree.PureeSerializer
import com.google.gson.Gson
import jp.co.tokubai.docpuree.model.SerializedClassInfo
import jp.co.tokubai.docpuree.source.LogHistorySource

class DocPureeGsonSerializer(private val gson: Gson) : PureeSerializer {

    override fun serialize(log: Any): String {
        val json = gson.toJson(log)
        LogHistorySource.serializedClassHistory.add(SerializedClassInfo(log.javaClass, json))

        return json
    }
}
