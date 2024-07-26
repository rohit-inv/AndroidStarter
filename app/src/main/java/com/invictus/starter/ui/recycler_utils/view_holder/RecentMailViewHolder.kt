package com.invictus.starter.ui.recycler_utils.view_holder

import com.invictus.starter.databinding.RecentMailBinding
import com.invictus.starter.domain.model.RecentMailModel
import com.invictus.starter.ui.recycler_utils.RecyclerModel

class RecentMailViewHolder(private val binding: RecentMailBinding) :
    BaseViewHolder<RecentMailModel>(binding.root) {
    override fun bind(model: RecentMailModel, onItemClickListener: ((RecyclerModel) -> Unit)?) {
        binding.root.setOnClickListener {
            onItemClickListener?.invoke(model)
        }
        binding.name.text = model.name
        binding.nameIcon.text = model.name.take(1)
        binding.backgroundImg.setColorFilter(model.color)
    }

    override fun unbind() {
        binding.root.setOnClickListener(null)
    }
}