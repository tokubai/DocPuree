package jp.co.tokubai.docpuree.extensions

import android.util.Log
import com.cookpad.puree.PureeConfiguration
import com.cookpad.puree.outputs.PureeOutput
import jp.co.tokubai.docpuree.BuildConfig
import jp.co.tokubai.docpuree.model.LogDocItem
import jp.co.tokubai.docpuree.source.DocSource

fun PureeConfiguration.Builder.register(
    logClass: Class<*>,
    output: PureeOutput,
    logDocItem: LogDocItem,
): PureeConfiguration.Builder {
    if (BuildConfig.DEBUG) {
        Log.d("DocItem", logDocItem.toString())
        DocSource.logDocSet.add(logDocItem)
    }
    return register(logClass, output)
}
