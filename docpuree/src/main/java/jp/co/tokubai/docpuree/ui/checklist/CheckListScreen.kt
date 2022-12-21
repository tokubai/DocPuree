package jp.co.tokubai.docpuree.ui.checklist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CheckListScreen(viewModel: CheckListViewModel) {
    Scaffold {
        CheckListContent(modifier = Modifier.padding(it), viewModel = viewModel)
    }
}

@Composable
private fun CheckListContent(
    modifier: Modifier = Modifier,
    viewModel: CheckListViewModel,
) {
    LazyColumn(
        modifier = modifier,
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
                ) {
                    Icon(imageVector = isLoggedIcon, contentDescription = null, tint = isLoggedIconColor)
                    Spacer(modifier = modifier.padding(10.dp))
                    Column {
                        Text(text = checkListItem.clazz.simpleName)
                        Text(text = checkListItem.successfullyLoggedJson ?: "", color = Color.Green)
                    }
                }
            }
        }
    }
}
