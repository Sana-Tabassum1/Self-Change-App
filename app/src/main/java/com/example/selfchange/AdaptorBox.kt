package com.example.selfchange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptorBox(private val numList: MutableList<modelbox>): RecyclerView.Adapter<AdaptorBox.ViewHolder>() {

    private lateinit var Blist: onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position: Int)
    }

    fun onItemCkick(listener: onItemClickListener){

        Blist=listener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.boxsample, parent, false)
        return ViewHolder(itemview,Blist)
    }

    override fun getItemCount(): Int {
        return numList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentBox=numList[position]
        holder.textView.text=currentBox.numletter
    }

    class ViewHolder(itemView: View,listener:onItemClickListener):RecyclerView.ViewHolder(itemView){
        val textView:TextView=itemView.findViewById(R.id.numLetter)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }

    }
}