package com.invictus.starter.ui.recycler_utils.view_holder

import androidx.core.util.TypedValueCompat.spToPx
import com.invictus.starter.databinding.HeaderLayoutBinding
import com.invictus.starter.domain.model.HeaderModel
import com.invictus.starter.ui.recycler_utils.RecyclerModel

class HeaderViewHolder(private val binding: HeaderLayoutBinding) :
    BaseViewHolder<HeaderModel>(binding.root) {
    override fun bind(model: HeaderModel, onItemClickListener: ((RecyclerModel) -> Unit)?) {
        binding.header.textSize = spToPx(
            model.textSizeSP,
            binding.root.context.resources.displayMetrics
        )
        binding.header.text = model.name
    }
}