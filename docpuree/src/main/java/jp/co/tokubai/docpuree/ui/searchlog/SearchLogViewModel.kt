package jp.co.tokubai.docpuree.ui.searchlog

import androidx.lifecycle.ViewModel
import jp.co.tokubai.docpuree.source.CheckListSource

class SearchLogViewModel : ViewModel() {

    fun addLogToCheckList(clazz: Class<*>) {
        CheckListSource.checkList.add(clazz)
    }
}
