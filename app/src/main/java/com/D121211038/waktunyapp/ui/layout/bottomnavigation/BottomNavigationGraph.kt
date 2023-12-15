package com.D121211038.waktunyapp.ui.layout.bottomnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.D121211038.waktunyapp.ui.activities.lists.ArticlesListActivity
import com.D121211038.waktunyapp.ui.activities.main.MainActivity
import com.D121211038.waktunyapp.ui.activities.search.ArticleSearchActivity

@Composable
fun BottomNavigationGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationScreens.Home.route
    ) {
        composable(route = BottomNavigationScreens.Home.route) {
            MainActivity()
        }
        composable(route = BottomNavigationScreens.Search.route) {
            ArticleSearchActivity()
        }
        composable(route = BottomNavigationScreens.Search.route) {
            ArticlesListActivity()
        }

    }
}