package com.invictus.starter.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink
import androidx.navigation.NavType
import androidx.navigation.navArgument


sealed class Screen(val route: String)

@Suppress("UNUSED")
sealed class ScreenRoute(
    route: String,
) : Screen(route) {
    data object Mails : ScreenRoute("mails")
    data class MailDetails(val mailId: Int) : ScreenRoute("mail_details?mailId=$mailId") {
        companion object : ArgScreen("mail_details?mailId={mailId}") {
            override val arguments: List<NamedNavArgument> = listOf(
                navArgument("mailId") {
                    type = NavType.IntType
                }
            )
            override val deepLinks: List<NavDeepLink> = emptyList()

        }
    }

    data object Compose : ScreenRoute("compose")
}


sealed class ArgScreen(route: String) : Screen(route) {
    abstract val arguments: List<NamedNavArgument>
    abstract val deepLinks: List<NavDeepLink>
}


sealed class AuthenticatedRoute(route: String) : ScreenRoute(route) {


}

sealed class NavigationRoute(route: String, val name: String, val icon: ImageVector) :
    AuthenticatedRoute(route)

sealed class BottomBarRoute(route: String, name: String, icon: ImageVector) :
    NavigationRoute(route, name, icon)


val BottomBarRoutes: List<BottomBarRoute> = listOf(

)