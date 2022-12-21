package jp.co.tokubai.docpuree.ui.checklist.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import jp.co.tokubai.docpuree.model.CheckListItem
import jp.co.tokubai.docpuree.ui.theme.DocPureeTheme

@Composable
fun CheckListAppBar(
    checkList: List<CheckListItem>,
    isRefreshing: Boolean,
) {
    val isCheckListCompleted = checkList.all { it.isLogged }

    val navigationIcon =
        if (isCheckListCompleted) Icons.Filled.CheckCircle else Icons.Default.Warning
    val navigationIconTint = if (isCheckListCompleted) Color.Cyan else Color.Red
    val title = if (isCheckListCompleted) "Completed" else "Some logs are missing"

    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {}) {
                if (!isRefreshing) {
                    Icon(
                        imageVector = navigationIcon,
                        contentDescription = "",
                        tint = navigationIconTint,
                    )
                } else {
                    CircularProgressIndicator(color = Color.White)
                }
            }
        },
        title = { Text(text = title) },
    )
}

@Preview
@Composable
private fun CheckListAppBarPreview() {
    DocPureeTheme {
        Column {
            CheckListAppBar(checkList = emptyList(), isRefreshing = false)
            CheckListAppBar(checkList = listOf(CheckListItem(Any::class.java)), isRefreshing = false)
            CheckListAppBar(checkList = emptyList(), isRefreshing = true)
        }
    }
}
