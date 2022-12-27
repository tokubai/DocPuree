package jp.co.tokubai.docpuree.ui.searchlog

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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

    LazyColumn(modifier = modifier, contentPadding = PaddingValues(5.dp)) {
        items(DocSource.logDocSet.toList()) { logDoc ->
            Card(
                modifier = Modifier.fillMaxSize(),
                onClick = {
                    viewModel.addLogToCheckList(logDoc.clazz)
                    Toast.makeText(
                        context,
                        "Add ${logDoc.clazz.simpleName} to checklist.",
                        Toast.LENGTH_SHORT,
                    ).show()
                },
                backgroundColor = Color.White,
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    // Title
                    Text(
                        text = logDoc.clazz.simpleName,
                        style = MaterialTheme.typography.h6.copy(color = MaterialTheme.colors.primary),
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    // Category
                    logDoc.category?.let { category ->
                        Chip(
                            onClick = {},
                            enabled = false,
                            colors = ChipDefaults.chipColors(
                                disabledContentColor = Color.White,
                                disabledBackgroundColor = Color.Gray,
                            ),
                        ) {
                            Text(text = category)
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))

                    // Description
                    Text(text = logDoc.description, style = MaterialTheme.typography.caption)
                    Spacer(modifier = Modifier.height(8.dp))


                    // Params
                    if (logDoc.params.isNotEmpty()) {
                        Divider()
                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Parameters",
                            style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight.Bold),
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                    Column(modifier = Modifier.padding(start = 20.dp)) {
                        logDoc.params.forEach { param ->
                            Text(
                                text = param.title,
                                color = MaterialTheme.colors.secondary,
                                fontWeight = FontWeight.Bold,
                            )
                            Text(
                                text = param.description,
                                modifier = Modifier.padding(start = 20.dp),
                                style = MaterialTheme.typography.caption,
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}
