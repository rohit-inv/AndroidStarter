package com.invictus.starter.ui.recycler_utils.view_holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.invictus.starter.ui.recycler_utils.RecyclerModel

abstract class BaseViewHolder<Item : RecyclerModel>(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(model: Item)
    open fun setOnItemClickListener(onItemClickListener: (() -> Unit)?) {
        itemView.setOnClickListener {
            onItemClickListener?.invoke()
        }
    }
}