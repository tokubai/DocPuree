package jp.co.tokubai.docpuree

object LogHistorySource {
    // Map of serialized Class to Json
    val serializedClassHistory = mutableListOf<Pair<String, String>>()

    // List of json successfully logged
    val successfullyLoggedJsonHistory = mutableListOf<String>()

    // Successfully Logged classes
    val successfullyLoggedClassHistory: List<Pair<String, String>>
        get() {
            return successfullyLoggedJsonHistory.mapNotNull { successfullyLoggedJson ->
                serializedClassHistory.firstOrNull { it.second == successfullyLoggedJson }
            }
        }
}
