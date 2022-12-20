package jp.co.tokubai.docpuree.ui.searchlog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchLogScreen() {
    Scaffold {
        SearchLogContent(modifier = Modifier.padding(it))
    }
}

@Composable
private fun SearchLogContent(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {

    }
}
