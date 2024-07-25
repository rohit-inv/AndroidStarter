package com.invictus.starter.ui.recycler_utils.view_holder

import com.invictus.starter.databinding.HeaderLayoutBinding
import com.invictus.starter.ui.recycler_utils.Header

class HeaderViewHolder(private val binding: HeaderLayoutBinding) :
    BaseViewHolder<Header>(binding.root) {
    override fun bind(model: Header) {
        binding.header.text = model.name
    }

    override fun setOnItemClickListener(onItemClickListener: (() -> Unit)?) {}
}