package com.invictus.starter.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment
import com.invictus.starter.ui.screen.compose.ComposeFragment
import com.invictus.starter.ui.screen.mail.MailFragment
import com.invictus.starter.ui.screen.mail_details.MailDetailsFragment

fun createNavGraph(navController: NavController): NavGraph {
    return navController.createGraph(Screen.Mails.route) {
        fragment<MailFragment>(Screen.Mails.route) {
            label = "Mails"
        }
        fragment<MailDetailsFragment>(
            Screen.MailDetails.route,
        ) {
            label = "MailDetails"
        }
        fragment<ComposeFragment>(Screen.Compose.route) {
            label = "Compose"
        }
    }
}