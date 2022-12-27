package jp.co.tokubai.docpuree.model

internal data class SerializedClassInfo(
    val clazz: Class<*>,
    val json: String,
)
