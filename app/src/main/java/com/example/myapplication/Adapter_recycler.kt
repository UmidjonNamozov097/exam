package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter_recycler(var members: ArrayList<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.advensting_item, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member: Member = members[position]
        if (holder is CustomViewHolder) {
            holder.tv_image.setImageResource(member.int)
            holder.tv_text.setText(member.name)
        }
    }

    override fun getItemCount(): Int {
return members.size
    }

    inner class CustomViewHolder internal constructor(private val view: View) :
        RecyclerView.ViewHolder(
            view
        ) {
        val tv_text: TextView
        val tv_image: ImageView

        init {
            tv_text = view.findViewById(R.id.textView_id)
            tv_image = view.findViewById(R.id.advens_image)
        }
    }
}