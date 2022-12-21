package jp.co.tokubai.docpuree.model

data class SerializedClassInfo(
    val clazz: Class<*>,
    val json: String,
)
