package jp.co.tokubai.docpuree.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.yuyh.jsonviewer.library.JsonRecyclerView

@Composable
fun JsonRecyclerView(
    modifier: Modifier = Modifier,
    json: String = "{\"table_name\":\"\",\"logs\":[{\"action\":\"click_watch_list_product\",\"category_id\":1,\"event\":\"watch_list\",\"product_id\":\"office_featured_product_24448177_21903\",\"shop_id\":21903,\"table_name\":\"tokubai_android_raw\",\"time\":1671495534,\"device_token\":\"7c3d6da8-af64-45fe-a6a6-b0ecd89fdbcd\",\"cdid\":\"android:55e31485-f544-4cd0-9aad-97a18d881a1d\",\"device_guest_id\":600005647,\"application_id\":115,\"version_code\":620001,\"session_id\":\"bfc23a97-b718-49b3-acdc-d4fdf19b1741\"}],\"sending_time\":1671495534}"
) {
    AndroidView(
        modifier = modifier,
        factory = {
            JsonRecyclerView(it).apply {
                bindJson(json)
                setScaleEnable(true)
                // TODO expandAll (which is future api of json viewer added at Oct 3 still not released)
            }
        },
    )
}
