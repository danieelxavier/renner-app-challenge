package com.example.rennerappchallenge.Adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rennerappchallenge.Activities.ProductActivity
import com.example.rennerappchallenge.R

class ColorsAdapter (val colors: Array<String>, val context: Context, val activity: ProductActivity) : RecyclerView.Adapter<ColorsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_color, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.color.setBackgroundColor(Color.parseColor(colors[position]))

        if (position == activity.getColor()) {
            holder.border.setBackgroundResource(R.drawable.border_background_black_bold)
        } else {
            holder.border.setBackgroundResource(R.drawable.border_background_gray_bold)
        }

        holder.color.setOnClickListener {
            activity.setColor(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = colors.size

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val color: View = itemView.findViewById(R.id.product_color_item)
        val border: View = itemView.findViewById(R.id.product_color_border)
    }
}