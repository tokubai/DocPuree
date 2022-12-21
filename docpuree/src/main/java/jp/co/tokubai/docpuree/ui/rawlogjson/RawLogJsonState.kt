package jp.co.tokubai.docpuree.ui.rawlogjson

sealed interface RawLogJsonState {

    object Filtering : RawLogJsonState
    data class Success(val data: List<Pair<Class<*>, String>>) : RawLogJsonState
}
