package com.invictus.starter.ui.recycler_utils.view_holder

import com.invictus.starter.databinding.MailLayoutBinding
import com.invictus.starter.ui.recycler_utils.Mail
import com.invictus.starter.ui.recycler_utils.RModel

class MailViewHolder(private val binding: MailLayoutBinding) :
    BaseViewHolder(binding.root) {
    override fun bind(model: RModel) {
        (model as? Mail)?.let {
            binding.iconText.text = it.model.name.take(1).uppercase()
            binding.name.text = it.model.name
            binding.subject.text = it.model.subject
            binding.body.text = it.model.body
            binding.time.text = it.model.time
            binding.iconBg.setColorFilter(it.model.color)
        }
    }
}