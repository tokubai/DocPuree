package jp.co.tokubai.docpuree.extensions

import com.cookpad.puree.PureeConfiguration
import com.cookpad.puree.outputs.PureeOutput
import jp.co.tokubai.docpuree.ui.DocSource

fun PureeConfiguration.Builder.register(
    logClass: Class<*>,
    output: PureeOutput,
    docRawMarkdown: String,
): PureeConfiguration.Builder {
    DocSource.classToRawMarkdownMap[logClass] = docRawMarkdown
    return register(logClass, output)
}
