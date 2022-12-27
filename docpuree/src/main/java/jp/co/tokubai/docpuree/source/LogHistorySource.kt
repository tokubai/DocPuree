package jp.co.tokubai.docpuree.source

import jp.co.tokubai.docpuree.model.SerializedClassInfo
import kotlinx.coroutines.flow.MutableStateFlow

internal object LogHistorySource {
    // Map of serialized Class to Json
    val serializedClassHistory = mutableListOf<SerializedClassInfo>()

    // List of json successfully logged
    val successfullyLoggedJsonHistory = mutableListOf<String>()
    val successfullyLoggedJson = MutableStateFlow("")

    internal fun getClassesFromLoggedJson(loggedJson: String) : List<Class<*>> {
        return serializedClassHistory.filter { loggedJson.contains(it.json) }.map { it.clazz }
    }
}
