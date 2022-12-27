package jp.co.tokubai.docpuree.ui.rawlogjson

internal sealed interface RawLogJsonState {

    object Filtering : RawLogJsonState
    data class Success(val successfullyLoggedJsonHistory: List<String>) : RawLogJsonState
}
