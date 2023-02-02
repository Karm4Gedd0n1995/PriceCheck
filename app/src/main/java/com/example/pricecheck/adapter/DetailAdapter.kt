package com.example.pricecheck.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pricecheck.R
import com.example.pricecheck.data.model.Prospect
import com.example.pricecheck.data.model.ProspectApi

class DetailAdapter() : RecyclerView.Adapter<DetailAdapter.ItemViewHolder>() {

    private var dataset = listOf<ProspectApi>()


    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val prospectView: ImageView = view.findViewById(R.id.detailprospect)
        val seiteview: TextView = view.findViewById(R.id.seitetext)
    }

    fun submitlist(newlist: List<ProspectApi>){
        dataset = newlist
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterlayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.prospect_item, parent, false)

        return ItemViewHolder(adapterlayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val prospects = dataset[position]
        holder.prospectView.load(prospects.image)
        holder.seiteview.text = prospects.name
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
