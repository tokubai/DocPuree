package jp.co.tokubai.docpuree.ui.rawlogjson.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.co.tokubai.docpuree.ui.components.JsonRecyclerView

@Composable
internal fun RowLogJsonItem(
    classToJson: Pair<Class<*>, String>,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(text = classToJson.first.simpleName)
            JsonRecyclerView(json = classToJson.second)
        }
    }
}
