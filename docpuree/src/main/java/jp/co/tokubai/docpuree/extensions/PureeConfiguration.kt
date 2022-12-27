package jp.co.tokubai.docpuree.extensions

import com.cookpad.puree.PureeConfiguration
import com.cookpad.puree.outputs.PureeOutput
import jp.co.tokubai.docpuree.BuildConfig
import jp.co.tokubai.docpuree.model.DocItem
import jp.co.tokubai.docpuree.model.LogInfo
import jp.co.tokubai.docpuree.source.DocSource

fun PureeConfiguration.Builder.register(
    logClass: Class<*>,
    output: PureeOutput,
    docRawMarkdown: String,
    logInfo: LogInfo,
): PureeConfiguration.Builder {
    if (BuildConfig.DEBUG) {
        DocSource.docSet.add(DocItem(clazz = logClass, rawMarkdown = docRawMarkdown))
        DocSource.logDocSet.add(logInfo)
    }
    return register(logClass, output)
}
