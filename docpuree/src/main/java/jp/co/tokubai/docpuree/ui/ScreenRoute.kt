package jp.co.tokubai.docpuree.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import jp.co.tokubai.docpuree.R

internal sealed class ScreenRoute(val route: String) {

    object SearchLogScreen : ScreenRoute(route = "search-log")
    object CheckListScreen : ScreenRoute(route = "check-list")
    object RawLogJsonScreen : ScreenRoute(route = "raw-log-json")
}

internal sealed class BottomBarMenuItem(
    val route: ScreenRoute,
    @StringRes
    val titleRes: Int,
    val icon: ImageVector,
) {

    object SearchLog : BottomBarMenuItem(
        route = ScreenRoute.SearchLogScreen,
        titleRes = R.string.search,
        icon = Icons.Default.Search,
    )

    object CheckList : BottomBarMenuItem(
        route = ScreenRoute.CheckListScreen,
        titleRes = R.string.check_list,
        icon = Icons.Default.Check,
    )

    object RawLogJson : BottomBarMenuItem(
        route = ScreenRoute.RawLogJsonScreen,
        titleRes = R.string.json,
        icon = Icons.Default.List,
    )
}
