package jp.co.tokubai.docpuree.ui.checklist

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
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
    // TODO delete
    val successLog = viewModel.latestLog.collectAsState()
    LaunchedEffect(successLog) {
        Log.d("Success", successLog.value)
    }

    LazyColumn(modifier = modifier, contentPadding = PaddingValues(12.dp)) {
        items(viewModel.checkList) { checkListItem ->
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(text = checkListItem.clazz.simpleName)
            }
        }
    }
}
