package jp.co.tokubai.docpuree.ui.searchlog

import androidx.lifecycle.ViewModel
import jp.co.tokubai.docpuree.model.CheckListItem
import jp.co.tokubai.docpuree.source.CheckListSource
import jp.co.tokubai.docpuree.source.LogHistorySource

class SearchLogViewModel : ViewModel() {

    fun addLogToCheckList(clazz: Class<*>) {
        // set empty string to successfullyLoggedJson to prevent state flow on change
        LogHistorySource.successfullyLoggedJson.value = ""

        CheckListSource.checkList.add(CheckListItem(clazz))
    }
}
