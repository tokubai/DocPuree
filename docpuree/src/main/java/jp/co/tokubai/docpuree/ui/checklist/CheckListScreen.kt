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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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

    fun refresh() = refreshScope.launch {
        viewModel.isRefreshing = true
        delay(500)
        viewModel.isRefreshing = false
    }

    val refreshState = rememberPullRefreshState(viewModel.isRefreshing, ::refresh)

    Scaffold(
        topBar = {
            CheckListAppBar(
                checkList = viewModel.checkList,
                isRefreshing = viewModel.isRefreshing,
                onClickClear = { viewModel.clearCheckList() },
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pullRefresh(refreshState),
        ) {
            if (!viewModel.isRefreshing) {
                CheckListContent(modifier = Modifier.padding(it), viewModel = viewModel)
            }
            PullRefreshIndicator(viewModel.isRefreshing, refreshState, Modifier.align(Alignment.TopCenter))
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
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(viewModel.checkList) { checkListItem ->
            val isLoggedIcon = if (checkListItem.isLogged) {
                Icons.Filled.CheckCircle
            } else {
                Icons.Default.Warning
            }
            val isLoggedIconColor = if (checkListItem.isLogged) Color.Cyan else Color.Red

            Card {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
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
                            Text(text = it, color = MaterialTheme.colors.secondaryVariant)
                        }
                    }
                }
            }
        }
    }
}
