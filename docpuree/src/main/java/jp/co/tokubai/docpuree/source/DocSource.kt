package jp.co.tokubai.docpuree.source

import jp.co.tokubai.docpuree.model.DocItem
import jp.co.tokubai.docpuree.model.LogInfo

internal object DocSource {
    // TODO delete old
    val docSet: MutableSet<DocItem> = mutableSetOf()

    val logDocSet: MutableSet<LogInfo> = mutableSetOf()
}
