package jp.co.tokubai.docpuree.source

import jp.co.tokubai.docpuree.model.SerializedClassInfo
import kotlinx.coroutines.flow.MutableStateFlow

object LogHistorySource {
    // Map of serialized Class to Json
    internal val serializedClassHistory = mutableListOf<SerializedClassInfo>()

    // List of json successfully logged
    internal val successfullyLoggedJsonHistory = mutableListOf<String>()
    internal val successfullyLoggedJson = MutableStateFlow("")

    // Successfully Logged classes
    internal val successfullyLoggedClassHistory: List<Pair<Class<*>, String>>
        get() {
            return successfullyLoggedJsonHistory.mapNotNull { successfullyLoggedJson ->
                val classToSingleJson =
                    serializedClassHistory.firstOrNull { successfullyLoggedJson.contains(it.json) }
                classToSingleJson?.let {
                    it.clazz to successfullyLoggedJson
                }
            }
        }

    internal fun getClassesFromLoggedJson(loggedJson: String) : List<Class<*>> {
        return serializedClassHistory.filter { loggedJson.contains(it.json) }.map { it.clazz }
    }
}
