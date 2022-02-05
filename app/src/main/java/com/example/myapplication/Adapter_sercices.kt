package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter_sercices (var members: ArrayList<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.servis_item, parent, false)
        return CustomViewHolder(view)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member: Member = members[position]
        if (holder is CustomViewHolder) {
            holder.services_img.setImageResource(member.int)
            holder.services_text.setText(member.name)
        }
    }

    override fun getItemCount(): Int {
        return members.size
    }

    inner class CustomViewHolder internal constructor(private val view: View) :
        RecyclerView.ViewHolder(
            view
        ) {
        val services_text: TextView
        val services_img: ImageView

        init {
            services_text = view.findViewById(R.id.services_text)
            services_img = view.findViewById(R.id.services_img)
        }
    }
}