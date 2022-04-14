package com.example.kotlinretrofitmovie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptery(private val models:ArrayList<Model>): RecyclerView.Adapter<Adaptery.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptery.Holder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Adaptery.Holder, position: Int) {
        holder.textTitle.text=models.get(position).Title
    }

    override fun getItemCount(): Int {
        return models.size
    }

    class Holder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val textTitle:TextView=itemView.findViewById(R.id.textTitle)

    }
}