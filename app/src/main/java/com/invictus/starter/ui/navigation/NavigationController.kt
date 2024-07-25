package com.invictus.starter.ui.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.withResumed
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

interface Navigator {
    fun navUp()
    fun navigate(screenRoute: ScreenRoute)
    fun changeGraph(fromScreenRoute: ScreenRoute, toScreenRoute: ScreenRoute)
}

fun NavController.navigate(screenRoute: ScreenRoute) {
    navigate(screenRoute.route)
}


@Composable
fun rememberNavigationController(
    controller: NavHostController,
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): NavigationController = remember(coroutineScope, controller) {
    NavigationController(coroutineScope, controller)
}

private const val TAG = "NavigationController"


class NavigationController(
    private val coroutineScope: CoroutineScope,
    private val controller: NavHostController,
) : Navigator {


    private val currentRoute get() = controller.currentDestination?.route

    override fun navUp() {
        controller.navigateUp()
    }

    override fun navigate(screenRoute: ScreenRoute) {
        if (screenRoute.route == currentRoute) return
        coroutineScope.launch {
            controller.currentBackStackEntry?.withResumed {
                when (screenRoute) {
                    is BottomBarRoute,
                    is NavigationRoute -> {
                        controller.navigate(screenRoute.route) {
                            popUpTo(controller.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }

                    else -> {
                        controller.navigate(screenRoute.route)
                    }
                }
            } ?: run {
                Log.e(TAG, "navigate: Failed to navigate to $screenRoute")
            }
        }
    }

    override fun changeGraph(fromScreenRoute: ScreenRoute, toScreenRoute: ScreenRoute) {
        if (toScreenRoute.route == currentRoute) return
        coroutineScope.launch {
            controller.currentBackStackEntry?.withResumed {
                controller.navigate(toScreenRoute.route) {
                    popUpTo(fromScreenRoute.route) {
                        inclusive = true
                    }
                }
            } ?: run {
                Log.e(TAG, "changeGraph: Failed to change graph $fromScreenRoute -> $toScreenRoute")
            }
        }
    }

}