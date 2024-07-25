package com.invictus.starter.domain.model

import androidx.annotation.ColorInt
import com.invictus.starter.ui.recycler_utils.RecyclerModel

data class MailModel(
    val id: Int,
    val name: String,
    val subject: String,
    val body: String,
    val time: String,
    @ColorInt val color: Int
) : RecyclerModel {
    override fun areItemsTheSame(other: RecyclerModel): Boolean {
        return other is MailModel && id == other.id
    }
}

