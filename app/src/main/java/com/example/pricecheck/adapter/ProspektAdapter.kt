package com.example.pricecheck.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pricecheck.R
import com.example.pricecheck.data.model.Prospect
import com.example.pricecheck.ui.MainFragmentDirections

class ProspektAdapter(
    private val context: Context,
    private var dataset: List<Prospect>
) : RecyclerView.Adapter<ProspektAdapter.ItemViewHolder>(){

    class ItemViewHolder(private val view:View) : RecyclerView.ViewHolder(view){
        val prospectname: TextView = view.findViewById(R.id.prospectname)
        val prospectimage: ImageView = view.findViewById(R.id.prospectview)
    }

    fun submitlist(newlist:List<Prospect>){
        dataset = newlist
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val prospect = dataset[position]

        holder.prospectname.text = prospect.name
        holder.prospectimage.setImageResource(prospect.imageId)
        holder.prospectimage.setOnClickListener {
            holder.itemView.findNavController().navigate(MainFragmentDirections.actionHomeFragmentToProspectFragment())
        }
        }




    override fun getItemCount(): Int {
        return dataset.size


}}