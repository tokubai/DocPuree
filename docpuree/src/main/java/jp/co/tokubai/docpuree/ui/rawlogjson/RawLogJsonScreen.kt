package jp.co.tokubai.docpuree.ui.rawlogjson

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import jp.co.tokubai.docpuree.LogHistorySource

@Composable
fun RawLogJsonScreen() {
    Scaffold {
        RawLogJsonContent(modifier = Modifier.padding(it))
    }
}

@Composable
private fun RawLogJsonContent(modifier: Modifier = Modifier) {
    LazyColumn {
        items(LogHistorySource.successfullyLoggedClassHistory) { classToJson: Pair<String, String> ->
            Text(text = "Class: ${classToJson.first}, Json: ${classToJson.second}")
        }
    }
}
