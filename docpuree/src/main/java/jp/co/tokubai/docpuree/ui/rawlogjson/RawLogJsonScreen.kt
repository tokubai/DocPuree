package jp.co.tokubai.docpuree.ui.rawlogjson

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.co.tokubai.docpuree.ui.components.SearchAppBar
import jp.co.tokubai.docpuree.ui.rawlogjson.components.RowLogJsonItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun RawLogJsonScreen(
    viewModel: RawLogJsonViewModel,
) {
    val searchTextState by viewModel.searchTextState

    val refreshScope = rememberCoroutineScope()
    var refreshing by remember { mutableStateOf(false) }

    fun refresh() = refreshScope.launch {
        refreshing = true
        viewModel.filterLoggedJson()
        delay(500)
        refreshing = false
    }

    val refreshState = rememberPullRefreshState(refreshing, ::refresh)

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
        Box(modifier = Modifier
            .fillMaxSize()
            .pullRefresh(refreshState)
        ) {
            if (!refreshing) {
                RawLogJsonContent(modifier = Modifier.padding(it), viewModel = viewModel)
            }
            PullRefreshIndicator(refreshing, refreshState, Modifier.align(Alignment.TopCenter))
        }
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
                items(items = state.data, key = { it }) { classToJson ->
                    RowLogJsonItem(classToJson = classToJson)
                }
            }
        }
    }
}
