package jp.co.tokubai.docpuree.ui.checklist

import androidx.lifecycle.ViewModel
import jp.co.tokubai.docpuree.source.CheckListSource

class CheckListViewModel : ViewModel() {

    val checkList = CheckListSource.checkList
}
