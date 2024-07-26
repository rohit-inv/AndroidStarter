package com.invictus.starter.domain.model

import com.invictus.starter.ui.recycler_utils.RecyclerModel

data class HorizontalListModel(
    val id: Int,
    val recyclerModels: List<RecyclerModel>,
    val horizontalGapDp: Float = 16F,
    val verticalGapDp: Float = 16F,
    val noOfRows: Int = 1,
) : RecyclerModel {
    override fun areContentsTheSame(other: RecyclerModel): Boolean {
        return other is HorizontalListModel && this == other && recyclerModels == other.recyclerModels
    }

    override fun areItemsTheSame(other: RecyclerModel): Boolean {
        return other is HorizontalListModel && id == other.id
    }
}
