package com.invictus.starter.ui.screen.mail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.invictus.starter.databinding.MailItemBinding

class MailAdapter : RecyclerView.Adapter<MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(MailItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind("$position")
    }

    override fun getItemCount(): Int {
        return 10
    }
}


class MyViewHolder(private val binding: MailItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(text: String) {
        binding.text.text = text
    }
}