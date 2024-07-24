package com.invictus.starter.domain.model

import androidx.annotation.ColorInt

data class MailModel(
    val name: String,
    val subject: String,
    val body: String,
    val time: String,
    @ColorInt val color: Int
)

