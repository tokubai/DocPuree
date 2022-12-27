package jp.co.tokubai.docpuree.ui.searchlog

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.ui.RichText
import jp.co.tokubai.docpuree.source.DocSource

@Composable
internal fun SearchLogScreen(
    viewModel: SearchLogViewModel,
) {
    Scaffold {
        SearchLogContent(modifier = Modifier.padding(it), viewModel = viewModel)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SearchLogContent(modifier: Modifier = Modifier, viewModel: SearchLogViewModel) {
    val context = LocalContext.current

    LazyColumn(modifier = modifier, contentPadding = PaddingValues(12.dp)) {
        items(DocSource.docSet.toList()) { logDocument ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                onClick = {
                    viewModel.addLogToCheckList(logDocument.clazz)
                    Toast.makeText(
                        context,
                        "Add ${logDocument.clazz.simpleName} to checklist.",
                        Toast.LENGTH_SHORT,
                    ).show()
                },
                backgroundColor = Color.White,
            ) {
                RichText(modifier = Modifier.padding(5.dp)) {
                    Markdown(content = logDocument.rawMarkdown)
                }
            }
        }
    }
}
