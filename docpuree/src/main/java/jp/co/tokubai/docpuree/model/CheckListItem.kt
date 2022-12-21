package jp.co.tokubai.docpuree.model

data class CheckListItem(
    val clazz: Class<*>,
    var successfullyLoggedJson: String? = null,
) {
    val isLogged: Boolean
        get() = successfullyLoggedJson != null
}
