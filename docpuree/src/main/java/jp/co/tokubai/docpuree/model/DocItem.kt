package jp.co.tokubai.docpuree.model

internal data class DocItem(
    val clazz: Class<*>,
    val rawMarkdown: String,
) {
    override fun equals(other: Any?): Boolean {
        return (other as? DocItem)?.clazz?.simpleName == clazz.simpleName
    }

    override fun hashCode(): Int {
        var result = clazz.hashCode()
        result = 31 * result + rawMarkdown.hashCode()
        return result
    }
}
