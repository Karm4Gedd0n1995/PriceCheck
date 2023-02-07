package com.example.pricecheck.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pricecheck.R
import com.example.pricecheck.data.model.Prospect

class FavouriteAdapter(
    private var update: (daoProspect: Prospect)-> Unit

): RecyclerView.Adapter<FavouriteAdapter.ItemViewHolder>() {
    private var dataset: List<Prospect> = listOf()
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        val prospectView: ImageView = view.findViewById(R.id.favouriteView)
        val prospectText: TextView = view.findViewById(R.id.favouriteText)
        val deletebutton: ImageView = view.findViewById(R.id.deletebutton)
    }

    fun submitlist(newlist:List<Prospect>){
        dataset = newlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterlayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.favourite_item, parent, false)

        return ItemViewHolder(adapterlayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val favourite = dataset[position]


        holder.prospectView.setImageResource(favourite.imageid)
        holder.prospectText.text = favourite.name
        holder.deletebutton.setOnClickListener {
            favourite.liked = !favourite.liked
            update(favourite)

        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}