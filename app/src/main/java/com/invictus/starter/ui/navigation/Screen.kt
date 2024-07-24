package com.invictus.starter.ui.navigation

sealed class Screen(val route: String) {
    data object Mails : Screen("mails")
    data object MailDetails : Screen("details")
    data object Compose : Screen("compose")
}