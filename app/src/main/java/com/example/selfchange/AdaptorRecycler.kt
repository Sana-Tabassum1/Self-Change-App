package com.example.selfchange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptorRecycler(private val newList: ArrayList<ModelRecycler>): RecyclerView.Adapter<AdaptorRecycler.ViewHolder>() {
 private lateinit var mlist: onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)
    }

    fun onItemCkick(listener: onItemClickListener){

        mlist=listener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview =
            LayoutInflater.from(parent.context).inflate(R.layout.samplecard, parent, false)
        return ViewHolder(itemview,mlist)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem=newList[position]
        holder.imageView.setImageResource(currentItem.image)
        holder.textView.text=currentItem.title
    }

    class ViewHolder(itemView: View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById(R.id.imageActivity)
        val textView: TextView = itemView.findViewById(R.id.title)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }

    }
}