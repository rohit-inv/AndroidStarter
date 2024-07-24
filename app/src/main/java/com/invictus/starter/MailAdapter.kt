package com.invictus.starter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.invictus.starter.domain.model.MailModel

class MailAdapter(
    private val items: List<MailModel>
) : RecyclerView.Adapter<MailAdapter.MailItem>() {


    class MailItem(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.name)
        private val iconText = view.findViewById<TextView>(R.id.iconText)
        private val subject = view.findViewById<TextView>(R.id.subject)
        private val body = view.findViewById<TextView>(R.id.body)
        private val time = view.findViewById<TextView>(R.id.time)
        private val iconBg = view.findViewById<ImageView>(R.id.icon_bg)
        fun update(model: MailModel) {
            name.text = model.name
            iconText.text = model.name.take(1).uppercase()
            subject.text = model.subject
            body.text = model.body
            time.text = model.time
            iconBg.setColorFilter(model.color)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailItem {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.mail_layout, parent, false)
        return MailItem(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: MailItem, position: Int) {
        holder.update(items[position])
    }
}