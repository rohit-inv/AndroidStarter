package com.invictus.starter.ui.recycler_utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.invictus.starter.databinding.HeaderLayoutBinding
import com.invictus.starter.databinding.MailLayoutBinding
import com.invictus.starter.databinding.RecentMailBinding
import com.invictus.starter.domain.model.HeaderModel
import com.invictus.starter.domain.model.HorizontalListModel
import com.invictus.starter.domain.model.MailModel
import com.invictus.starter.domain.model.RecentMailModel
import com.invictus.starter.ui.recycler_utils.RecyclerModel
import com.invictus.starter.ui.recycler_utils.view_holder.BaseViewHolder
import com.invictus.starter.ui.recycler_utils.view_holder.HeaderViewHolder
import com.invictus.starter.ui.recycler_utils.view_holder.HorizontalListViewHolder
import com.invictus.starter.ui.recycler_utils.view_holder.MailViewHolder
import com.invictus.starter.ui.recycler_utils.view_holder.RecentMailViewHolder


class MyRecycleAdapter :
    ListAdapter<RecyclerModel, BaseViewHolder<RecyclerModel>>(DIFF_CALLBACK) {

    private var onItemClickListener: ((RecyclerModel) -> Unit)? = null
    fun setOnItemClickListener(listener: ((RecyclerModel) -> Unit)?) {
        onItemClickListener = listener
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<RecyclerModel>() {
            override fun areItemsTheSame(oldItem: RecyclerModel, newItem: RecyclerModel): Boolean {
                return oldItem.areItemsTheSame(newItem)
            }

            override fun areContentsTheSame(
                oldItem: RecyclerModel,
                newItem: RecyclerModel
            ): Boolean {
                return oldItem.areContentsTheSame(newItem)
            }

        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<RecyclerModel> {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            1 -> HeaderViewHolder(
                HeaderLayoutBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            ) as BaseViewHolder<RecyclerModel>

            2 -> MailViewHolder(
                MailLayoutBinding.inflate(inflater, parent, false)
            ) as BaseViewHolder<RecyclerModel>

            3 -> HorizontalListViewHolder(
                RecyclerView(parent.context).apply {
                    ViewCompat.setNestedScrollingEnabled(this, false)
                }
            ) as BaseViewHolder<RecyclerModel>

            4 -> RecentMailViewHolder(
                RecentMailBinding.inflate(inflater, parent, false)
            ) as BaseViewHolder<RecyclerModel>

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<RecyclerModel>, position: Int) {
        val model = currentList[position]
        holder.bind(model, onItemClickListener)
    }

    override fun onViewRecycled(holder: BaseViewHolder<RecyclerModel>) {
        super.onViewRecycled(holder)
        holder.unbind()
    }

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position]) {
            is HeaderModel -> 1
            is MailModel -> 2
            is HorizontalListModel -> 3
            is RecentMailModel -> 4
            else -> 0
        }
    }

}





