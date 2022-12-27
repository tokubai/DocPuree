package jp.co.tokubai.docpuree.ui.rawlogjson.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.co.tokubai.docpuree.ui.components.JsonRecyclerView

@Composable
internal fun RowLogJsonItem(
    json: String,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier.fillMaxWidth()) {
        JsonRecyclerView(json = json, modifier = Modifier.padding(5.dp))
    }
}
