package com.example.rennerappchallenge.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.rennerappchallenge.Activities.ProductActivity
import com.example.rennerappchallenge.R

class SizesAdapter (val sizes: Array<String>, val context: Context, val activity: ProductActivity) : RecyclerView.Adapter<SizesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_size, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (position == activity.getSize()) {
            holder.size.setBackgroundResource(R.color.black)
            holder.text.setTextColor(ContextCompat.getColor(context, R.color.white))
        } else {
            holder.size.setBackgroundResource(R.drawable.border_background_black)
            holder.text.setTextColor(ContextCompat.getColor(context, R.color.black))
        }

        holder.text.text = sizes[position]

        holder.size.setOnClickListener {
            activity.setSize(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = sizes.size

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val size: RelativeLayout = itemView.findViewById(R.id.product_size)
        val text: TextView = itemView.findViewById(R.id.product_size_name)
    }
}