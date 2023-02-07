package com.example.pricecheck.adapter

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.pricecheck.R
import com.example.pricecheck.data.model.Prospect
import com.example.pricecheck.ui.MainFragmentDirections
import com.example.pricecheck.ui.MainViewModel

class ProspektAdapter(
    private var update: (daoProspect: Prospect)-> Unit,
    private val context: Context,
    private var dataset: List<Prospect>

) : RecyclerView.Adapter<ProspektAdapter.ItemViewHolder>(){



    class ItemViewHolder(private val view:View) : RecyclerView.ViewHolder(view){
        val prospectname: TextView = view.findViewById(R.id.prospectname)
        val prospectimage: ImageView = view.findViewById(R.id.prospectview)
        val likebutton: ImageView = view.findViewById(R.id.likeprospect)

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

        fun colorizer() {

            val animator = ObjectAnimator.ofArgb(
                holder.likebutton, "colorFilter",
                ContextCompat.getColor(context, R.color.red),
                Color.BLACK
            )

            animator.duration = 2000
            animator.repeatCount = 1
            animator.repeatMode = ObjectAnimator.REVERSE
            animator.start()
        }


        val prospect = dataset[position]

        holder.prospectname.text = prospect.name
        holder.prospectimage.setImageResource(prospect.imageid)
        holder.prospectimage.setOnClickListener {
            holder.itemView.findNavController().navigate(MainFragmentDirections.actionHomeFragmentToProspectFragment())
        }
        holder.likebutton.setOnClickListener{
            val name = prospect.name
            val imageid = prospect.imageid
            prospect.liked = !prospect.liked
            update(prospect)
            colorizer()

        }







            }









    override fun getItemCount(): Int {
        return dataset.size


    }
}
