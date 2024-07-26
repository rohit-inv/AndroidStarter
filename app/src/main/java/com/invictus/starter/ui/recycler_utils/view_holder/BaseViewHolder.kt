package com.invictus.starter.ui.recycler_utils.view_holder

import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.invictus.starter.ui.recycler_utils.RecyclerModel

abstract class BaseViewHolder<Item : RecyclerModel>(
    view: View
) : RecyclerView.ViewHolder(view) {

    protected val context: Context get() = itemView.context
    protected val displayMetrics: DisplayMetrics get() = context.resources.displayMetrics

    abstract fun bind(
        model: Item,
        onItemClickListener: ((RecyclerModel) -> Unit)? = null
    )

    open fun unbind() {}



}