package jp.co.tokubai.docpuree.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import jp.co.tokubai.docpuree.LogHistorySource
import jp.co.tokubai.docpuree.ui.theme.DocPureeTheme

class DocPureeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DocPureeTheme {
                LazyColumn {
                    items(LogHistorySource.successfullyLoggedClassHistory) { classToJson: Pair<String, String> ->
                        Text(text = "Class: ${classToJson.first}, Json: ${classToJson.second}")
                    }
                }

                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomBar(navController = navController) }
                ) {

                    NavHost(
                        modifier = Modifier.padding(it),
                        navController = navController,
                        startDestination = ScreenRoute.SearchLogScreen.route
                    ) {

                        composable(route = ScreenRoute.SearchLogScreen.route) {
                            // TODO 検索画面
                        }

                        composable(route = ScreenRoute.CheckListScreen.route) {
                            // TODO チェックリスト画面
                        }

                        composable(route = ScreenRoute.RawLogJsonScreen.route) {
                            // TODO 生のJson一覧画面
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
) {
    val menuItems = listOf(
        BottomBarMenuItem.SearchLog,
        BottomBarMenuItem.CheckList,
        BottomBarMenuItem.RawLogJson,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation {
        menuItems.forEach { menuItem ->
            AddItem(
                menuItem = menuItem,
                currentDestination = currentDestination,
                navController = navController,
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    menuItem: BottomBarMenuItem,
    currentDestination: NavDestination?,
    navController: NavHostController,
) {
    BottomNavigationItem(
        label = { Text(text = stringResource(id = menuItem.titleRes)) },
        icon = { Icon(imageVector = menuItem.icon, contentDescription = "Navigation Icon") },
        selected = currentDestination?.hierarchy?.any { it.route == menuItem.route.route } == true,
        onClick = {
            // Navigate only when current route and destination is not the same
            if (navController.currentDestination?.route != menuItem.route.route) {
                navController.navigate(menuItem.route.route) { popUpTo(ScreenRoute.SearchLogScreen.route) }
            }
        },
    )
}

