package jp.co.tokubai.docpuree.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.yuyh.jsonviewer.library.JsonRecyclerView

@Composable
fun JsonRecyclerView(
    modifier: Modifier = Modifier,
    json: String,
) {
    AndroidView(
        modifier = modifier,
        factory = {
            JsonRecyclerView(it).apply {
                bindJson(json)
                setTextSize(14f)
                setScaleEnable(true)
                // TODO expandAll (which is future api of json viewer added at Oct 3 still not released)
            }
        },
    )
}
