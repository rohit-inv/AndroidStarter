package com.invictus.starter.ui.recycler_utils.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.invictus.starter.ui.recycler_utils.RModel

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(model: RModel)
}