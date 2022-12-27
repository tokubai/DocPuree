package jp.co.tokubai.docpuree.ui.checklist

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.co.tokubai.docpuree.source.CheckListSource
import jp.co.tokubai.docpuree.source.LogHistorySource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

internal class CheckListViewModel : ViewModel() {
    init {
        observeLoggedClass()
    }

    val checkList = CheckListSource.checkList
    var isRefreshing by mutableStateOf(false)

    fun clearCheckList() {
        isRefreshing = true
        CheckListSource.checkList.clear()
        isRefreshing = false
    }

    private fun observeLoggedClass() {
        LogHistorySource.successfullyLoggedJson.onEach { successfullyLoggedJson ->
            // Do nothing when successfullyLoggedJson is equal to last checked item
            if (successfullyLoggedJson == CheckListSource.checkList.lastOrNull { it.isLogged }?.successfullyLoggedJson) return@onEach

            // new
            LogHistorySource.getClassesFromLoggedJson(successfullyLoggedJson).forEach { clazz ->
                val nextCheckItem = CheckListSource.checkList.firstOrNull{ !it.isLogged }
                nextCheckItem?.let { checkListItem ->
                    val isCheckItemLogged = checkListItem.clazz.simpleName == clazz.simpleName
                    if (isCheckItemLogged) {
                        checkListItem.successfullyLoggedJson = successfullyLoggedJson
                        Log.d("CheckList", CheckListSource.checkList.toString())
                    }
                }
            }
        }.launchIn(viewModelScope)
    }
}
