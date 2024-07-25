package com.invictus.starter.ui.recycler_utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.invictus.starter.databinding.HeaderLayoutBinding
import com.invictus.starter.databinding.MailLayoutBinding
import com.invictus.starter.domain.model.MailModel
import com.invictus.starter.ui.recycler_utils.Header
import com.invictus.starter.ui.recycler_utils.RecyclerModel
import com.invictus.starter.ui.recycler_utils.view_holder.BaseViewHolder
import com.invictus.starter.ui.recycler_utils.view_holder.HeaderViewHolder
import com.invictus.starter.ui.recycler_utils.view_holder.MailViewHolder






























class MyRecycleAdapter :
    ListAdapter<RecyclerModel, BaseViewHolder<RecyclerModel>>(DIFF_CALLBACK) {

    private var onItemClickListener: ((RecyclerModel) -> Unit)? = null
    fun setOnItemClickListener(listener: (RecyclerModel) -> Unit) {
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

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<RecyclerModel>, position: Int) {
        val model = currentList[position]
        holder.setOnItemClickListener {
            onItemClickListener?.invoke(model)
        }
        holder.bind(model)
    }

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position]) {
            is Header -> 1
            is MailModel -> 2
            else -> 0
        }
    }

}





