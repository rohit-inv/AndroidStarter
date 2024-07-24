package com.invictus.starter.ui.recycler_utils.view_holder

import com.invictus.starter.databinding.HeaderLayoutBinding
import com.invictus.starter.ui.recycler_utils.Header
import com.invictus.starter.ui.recycler_utils.RModel

class HeaderViewHolder(private val binding: HeaderLayoutBinding) :
    BaseViewHolder(binding.root) {
    override fun bind(model: RModel) {
        (model as? Header)?.let {
            binding.header.text = it.name
        }
    }
}