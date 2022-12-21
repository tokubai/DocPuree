package jp.co.tokubai.docpuree.ui.checklist

import android.util.Log
import androidx.lifecycle.ViewModel
import jp.co.tokubai.docpuree.source.CheckListSource
import jp.co.tokubai.docpuree.source.LogHistorySource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CheckListViewModel : ViewModel() {
    init {
        observeLoggedClass()
    }

    val checkList = CheckListSource.checkList
    val latestLog = LogHistorySource.successfullyLoggedJson

    private fun observeLoggedClass() {
        LogHistorySource.successfullyLoggedJson.onEach { successfullyLoggedJson ->
            val nextCheckListItem = CheckListSource.checkList.firstOrNull { !it.isLogged }
            nextCheckListItem?.let { checkItem ->
                val isCheckItemIsLogged =
                    checkItem.clazz.simpleName == LogHistorySource.getClassFromLoggedJson(
                        successfullyLoggedJson
                    )
                if (isCheckItemIsLogged) {
                    nextCheckListItem.isLogged = true
                    Log.d("CheckList", CheckListSource.checkList.toString())
                }
            }
        }.launchIn(GlobalScope)
    }
}
