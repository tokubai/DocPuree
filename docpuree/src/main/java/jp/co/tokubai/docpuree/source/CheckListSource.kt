package jp.co.tokubai.docpuree.source

object CheckListSource {
    val checkList = mutableListOf<CheckListItem>()
}

data class CheckListItem(
    val clazz: Class<*>,
    var isLogged: Boolean,
)
