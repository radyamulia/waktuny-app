package com.D121211038.waktunyapp.ui.layout.bottomnavigation

import com.D121211038.waktunyapp.R

sealed class BottomNavigationScreens(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_active: Int
) {

    // Homepage
    object Home: BottomNavigationScreens(
        route = "home",
        title = "Home",
        icon = R.drawable.ic_home,
        icon_active = R.drawable.ic_home_active,
    )

    // Searchpage
    object Search: BottomNavigationScreens(
        route = "search",
        title = "Search",
        icon = R.drawable.ic_search,
        icon_active = R.drawable.ic_search_active,
    )

    // Article
    object Article: BottomNavigationScreens(
        route = "article",
        title = "Article",
        icon = R.drawable.ic_article,
        icon_active = R.drawable.ic_article_active,
    )
}