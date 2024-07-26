package com.invictus.starter.domain.model

import com.invictus.starter.ui.recycler_utils.RecyclerModel

data class RecentMailModel(
    val name: String,
    val color: Int
) : RecyclerModel {
    override fun areContentsTheSame(other: RecyclerModel): Boolean {
        return other is RecentMailModel && this == other
    }

    override fun areItemsTheSame(other: RecyclerModel): Boolean {
        return other is RecentMailModel && name == other.name && color == other.color
    }
}
