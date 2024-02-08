package com.example.poems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class InfoAdapter (private val infoList: List<Info>, private val onItemClick: (Info) -> Unit) : RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_info, parent, false)
        return InfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        val info = infoList[position]
        holder.bind(info)
        holder.itemView.setOnClickListener { onItemClick(info) }
    }

    override fun getItemCount(): Int {
        return infoList.size
    }

    class InfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)

        fun bind(info: Info) {
            titleTextView.text = info.title
        }
    }
}
