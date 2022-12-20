package jp.co.tokubai.docpuree.ui.rawlogjson

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class RawLogJsonViewModel : ViewModel() {

    private val _searchTextState: MutableState<String> =
         mutableStateOf("")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }
}
