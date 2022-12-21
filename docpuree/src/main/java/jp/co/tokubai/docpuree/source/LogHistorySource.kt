package jp.co.tokubai.docpuree.source

import kotlinx.coroutines.flow.MutableStateFlow

object LogHistorySource {
    // Map of serialized Class to Json
    val serializedClassHistory = mutableListOf<Pair<String, String>>()

    // List of json successfully logged
    val successfullyLoggedJsonHistory = mutableListOf<String>()
    val successfullyLoggedJson = MutableStateFlow("")

    // Successfully Logged classes
    val successfullyLoggedClassHistory: List<Pair<String, String>>
        get() {
            return successfullyLoggedJsonHistory.mapNotNull { successfullyLoggedJson ->
                val classToSingleJson =
                    serializedClassHistory.firstOrNull { successfullyLoggedJson.contains(it.second) }
                classToSingleJson?.let {
                    it.first to successfullyLoggedJson
                }
            }
        }

    fun getClassFromLoggedJson(loggedJson: String) : String? {
        return serializedClassHistory.firstOrNull { loggedJson.contains(it.second) }?.first
    }
}
