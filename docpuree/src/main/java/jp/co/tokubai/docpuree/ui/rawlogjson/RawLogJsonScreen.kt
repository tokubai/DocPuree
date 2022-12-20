package jp.co.tokubai.docpuree.ui.rawlogjson

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.co.tokubai.docpuree.ui.components.SearchAppBar
import jp.co.tokubai.docpuree.ui.rawlogjson.components.RowLogJsonItem

@Composable
fun RawLogJsonScreen(
    viewModel: RawLogJsonViewModel,
) {
    val searchTextState by viewModel.searchTextState

    Scaffold(
        topBar = {
            SearchAppBar(
                text = searchTextState,
                onTextChange = { viewModel.updateSearchTextState(it) },
                onCloseClicked = { viewModel.updateSearchTextState("") },
                onSearchClicked = { viewModel.filterLoggedJson() },
            )
        }
    ) {
        RawLogJsonContent(modifier = Modifier.padding(it), viewModel = viewModel)
    }
}

@Composable
private fun RawLogJsonContent(
    modifier: Modifier = Modifier,
    viewModel: RawLogJsonViewModel,
) {
    when (val state = viewModel.state.value) {
        is RawLogJsonState.Filtering -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
        }
        is RawLogJsonState.Success -> {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp),
            ) {
                items(items = state.data, key = { it }) { classToJson: Pair<String, String> ->
                    RowLogJsonItem(classToJson = classToJson)
                }
            }
        }
    }
}
