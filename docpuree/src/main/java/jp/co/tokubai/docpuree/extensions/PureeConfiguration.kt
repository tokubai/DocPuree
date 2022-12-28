package jp.co.tokubai.docpuree.extensions

import com.cookpad.puree.PureeConfiguration
import com.cookpad.puree.outputs.PureeOutput
import jp.co.tokubai.docpuree.model.LogDocItem
import jp.co.tokubai.docpuree.source.DocSource

fun PureeConfiguration.Builder.register(
    logClass: Class<*>,
    output: PureeOutput,
    logDocItem: LogDocItem,
): PureeConfiguration.Builder {
    DocSource.logDocSet.add(logDocItem)
    return register(logClass, output)
}
