package com.invictus.starter.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavType
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment
import com.invictus.starter.ui.screen.compose.ComposeFragment
import com.invictus.starter.ui.screen.mail.MailFragment
import com.invictus.starter.ui.screen.mail_details.MailDetailsFragment

fun createNavGraph(navController: NavController): NavGraph {
    return navController.createGraph(ScreenRoute.Mails.route) {
        fragment<MailFragment>(
            route = ScreenRoute.Mails.route
        ) {
            label = "Mails"
        }
        fragment<MailDetailsFragment>(
            route = ScreenRoute.MailDetails.route,
        ) {
            label = "MailDetails"
            this.argument("mailId") {
                type = NavType.IntType
            }
        }
        fragment<ComposeFragment>(ScreenRoute.Compose.route) {
            label = "Compose"
        }
    }
}