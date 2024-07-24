package com.invictus.starter.ui.recycler_utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.invictus.starter.databinding.HeaderLayoutBinding
import com.invictus.starter.databinding.MailLayoutBinding
import com.invictus.starter.domain.model.MailModel
import com.invictus.starter.ui.recycler_utils.RModel
import com.invictus.starter.ui.recycler_utils.view_holder.BaseViewHolder
import com.invictus.starter.ui.recycler_utils.view_holder.HeaderViewHolder
import com.invictus.starter.ui.recycler_utils.view_holder.MailViewHolder


class MyRecycleAdapter : RecyclerView.Adapter<BaseViewHolder>() {
    private val diffUtil = object : DiffUtil.ItemCallback<RModel>() {
        override fun areItemsTheSame(oldItem: RModel, newItem: RModel): Boolean {
            return oldItem.type == newItem.type && oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RModel, newItem: RModel): Boolean {
            return oldItem == newItem
        }
    }
    private val asyncListDiffer = AsyncListDiffer(this, diffUtil)
    private var onItemClickListener: ((MailModel) -> Unit)? = null


    fun setOnItemClickListener(listener: (MailModel) -> Unit) {
        this.onItemClickListener = listener
    }

    fun saveData(items: List<RModel>) {
        asyncListDiffer.submitList(items)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : BaseViewHolder {
        return when (viewType) {
            0 -> HeaderViewHolder(
                HeaderLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )

            )

            1 -> MailViewHolder(
                MailLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> throw IllegalArgumentException("Invalid view type")
        }

    }

    override fun getItemViewType(position: Int): Int {
        return asyncListDiffer.currentList[position].type
    }

    override fun getItemCount(): Int {
        return asyncListDiffer.currentList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val model = asyncListDiffer.currentList[position]
        holder.bind(model)
    }
}