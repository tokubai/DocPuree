package jp.co.tokubai.docpuree.ui.rawlogjson

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.co.tokubai.docpuree.LogHistorySource
import jp.co.tokubai.docpuree.ui.rawlogjson.components.RowLogJsonItem

@Composable
fun RawLogJsonScreen() {
    Scaffold {
        RawLogJsonContent(modifier = Modifier.padding(it))
    }
}

@Composable
private fun RawLogJsonContent(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize().padding(12.dp)) {
        items(LogHistorySource.successfullyLoggedClassHistory) { classToJson: Pair<String, String> ->
            RowLogJsonItem(classToJson = classToJson)
        }
    }
}
