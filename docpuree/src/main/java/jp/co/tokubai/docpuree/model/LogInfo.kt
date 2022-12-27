package jp.co.tokubai.docpuree.model

data class LogInfo(
    private val clazz: Class<*>,
    val description: String,
    val category: String?,
    val params: List<ParamInfo>,
) {
    val className: String = clazz.simpleName

    data class ParamInfo(
        val title: String,
        val description: String,
    )

    override fun equals(other: Any?): Boolean {
        return (other as? DocItem)?.clazz?.simpleName == clazz.simpleName
    }

    override fun hashCode(): Int {
        var result = clazz.hashCode()
        result = 31 * result + clazz.simpleName.hashCode()
        return result
    }
}
