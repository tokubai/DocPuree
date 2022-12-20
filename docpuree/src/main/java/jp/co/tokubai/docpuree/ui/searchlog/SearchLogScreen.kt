package jp.co.tokubai.docpuree.ui.searchlog

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.ui.RichText
import jp.co.tokubai.docpuree.ui.DocSource

@Composable
fun SearchLogScreen() {
    Scaffold {
        SearchLogContent(modifier = Modifier.padding(it))
    }
}

@Composable
private fun SearchLogContent(modifier: Modifier = Modifier) {

    LazyColumn(modifier = modifier, contentPadding = PaddingValues(12.dp)) {
        items(DocSource.classToRawMarkdownMap.toList()) { classToMarkdown ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                backgroundColor = Color.White,
            ) {
                RichText(modifier = Modifier.padding(5.dp)) {
                    Markdown(content = classToMarkdown.second)
                }
            }
        }
    }
}
