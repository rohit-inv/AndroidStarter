package com.invictus.starter.domain.model

import com.invictus.starter.ui.recycler_utils.RecyclerModel


data class HeaderModel(
    val name: String,
    val textSizeSP: Float = 6F
) : RecyclerModel {
    override fun areItemsTheSame(other: RecyclerModel): Boolean {
        return other is HeaderModel && name == other.name
    }

    override fun areContentsTheSame(other: RecyclerModel): Boolean {
        return other is HeaderModel && this == other
    }
}