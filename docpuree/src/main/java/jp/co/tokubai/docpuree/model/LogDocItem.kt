package jp.co.tokubai.docpuree.model

import android.util.Log

data class LogDocItem(
    val clazz: Class<*>,
    val description: String,
    val category: String?,
    val params: List<ParamInfo>,
) {
    data class ParamInfo(
        val title: String,
        val description: String,
    )

    override fun equals(other: Any?): Boolean {
        val isEqual =  (other as? LogDocItem)?.clazz?.simpleName == clazz.simpleName
        Log.d("IsEqual", isEqual.toString())
        Log.d("Other", (other as LogDocItem)?.clazz?.simpleName.toString())
        Log.d("This", clazz.simpleName)
        return isEqual
    }

    override fun hashCode(): Int {
        var result = clazz.hashCode()
        result = 31 * result + clazz.simpleName.hashCode()
        return result
    }
}
