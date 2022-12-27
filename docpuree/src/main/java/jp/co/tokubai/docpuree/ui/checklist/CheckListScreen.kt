package jp.co.tokubai.docpuree.ui.checklist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import jp.co.tokubai.docpuree.ui.checklist.components.CheckListAppBar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun CheckListScreen(viewModel: CheckListViewModel) {
    val refreshScope = rememberCoroutineScope()
    var refreshing by remember { mutableStateOf(false) }

    fun refresh() = refreshScope.launch {
        refreshing = true
        delay(500)
        refreshing = false
    }

    val refreshState = rememberPullRefreshState(refreshing, ::refresh)

    Scaffold(
        topBar = {
            CheckListAppBar(
                checkList = viewModel.checkList,
                isRefreshing = refreshing,
                onClickClear = { viewModel.clearCheckList() },
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pullRefresh(refreshState),
        ) {
            if (!refreshing) {
                CheckListContent(modifier = Modifier.padding(it), viewModel = viewModel)
            }
            PullRefreshIndicator(refreshing, refreshState, Modifier.align(Alignment.TopCenter))
        }
    }
}

@Composable
private fun CheckListContent(
    modifier: Modifier = Modifier,
    viewModel: CheckListViewModel,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        items(viewModel.checkList) { checkListItem ->
            val isLoggedIcon = if (checkListItem.isLogged) {
                Icons.Filled.CheckCircle
            } else {
                Icons.Default.Warning
            }
            val isLoggedIconColor = if (checkListItem.isLogged) Color.Cyan else Color.Red

            Card(backgroundColor = Color.Black, contentColor = Color.White) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = isLoggedIcon,
                        contentDescription = null,
                        tint = isLoggedIconColor
                    )
                    Spacer(modifier = modifier.padding(10.dp))
                    Column {
                        Text(text = checkListItem.clazz.simpleName)
                        checkListItem.successfullyLoggedJson?.let {
                            Text(text = it, color = Color.Green)
                        }
                    }
                }
            }
        }
    }
}
