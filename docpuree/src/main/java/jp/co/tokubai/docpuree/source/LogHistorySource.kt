package jp.co.tokubai.docpuree.source

object LogHistorySource {
    // Map of serialized Class to Json
    val serializedClassHistory = mutableListOf<Pair<String, String>>()

    // List of json successfully logged
    val successfullyLoggedJsonHistory = mutableListOf<String>()

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
}
