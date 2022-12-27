package jp.co.tokubai.docpuree.ui.rawlogjson

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.co.tokubai.docpuree.source.LogHistorySource
import kotlinx.coroutines.launch

internal class RawLogJsonViewModel : ViewModel() {

    private val _state: MutableState<RawLogJsonState> =
        mutableStateOf(RawLogJsonState.Success(LogHistorySource.successfullyLoggedClassHistory))
    val state: State<RawLogJsonState> = _state

    private val _searchTextState: MutableState<String> =
        mutableStateOf("")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }

    fun filterLoggedJson() {
        viewModelScope.launch {
            _state.value = RawLogJsonState.Filtering
            val filteredResult = LogHistorySource.successfullyLoggedClassHistory.filter {
                return@filter (it.first.simpleName + it.second).contains(_searchTextState.value)
            }
            _state.value = RawLogJsonState.Success(filteredResult)
        }
    }
}
