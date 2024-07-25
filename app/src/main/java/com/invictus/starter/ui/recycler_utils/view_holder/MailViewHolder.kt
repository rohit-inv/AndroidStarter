package com.invictus.starter.ui.recycler_utils.view_holder

import com.invictus.starter.databinding.MailLayoutBinding
import com.invictus.starter.domain.model.MailModel

class MailViewHolder(
    private val binding: MailLayoutBinding
) : BaseViewHolder<MailModel>(binding.root) {
    override fun bind(model: MailModel) {
        binding.iconText.text = model.name.take(1).uppercase()
        binding.name.text = model.name
        binding.subject.text = model.subject
        binding.body.text = model.body
        binding.time.text = model.time
        binding.iconBg.setColorFilter(model.color)
    }
}