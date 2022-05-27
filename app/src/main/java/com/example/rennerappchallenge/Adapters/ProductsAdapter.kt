package com.example.rennerappchallenge.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.rennerappchallenge.Activities.MainActivity
import com.example.rennerappchallenge.Models.Product
import com.example.rennerappchallenge.R
import java.text.DecimalFormat

class ProductsAdapter (val products: ArrayList<Product>, val context: Context, val activity: MainActivity) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.row_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = products[position].name

        val imageName = products[position].photos[0]
        val id: Int =
            context.getResources().getIdentifier("com.example.rennerappchallenge:drawable/$imageName", null, null)
        holder.image.setImageResource(id)

        val decFormat = DecimalFormat("#,###.00")
        val price = decFormat.format(products[position].price)
        val pricex = decFormat.format(products[position].price / 5)

        holder.price.text = "R$ $price"
        holder.pricex.text = "5x de R$ $pricex"


        holder.like.setOnClickListener {
            holder.liked = !holder.liked

            if (holder.liked) {
                holder.like.setImageResource(R.drawable.cards_heart)
            } else {
                holder.like.setImageResource(R.drawable.cards_heart_outline)
            }
        }

        holder.card.setOnClickListener {
            activity.goToProduct(products[position], holder.liked)
        }
    }

    override fun getItemCount() = products.size

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image_product)
        val name: TextView = itemView.findViewById(R.id.name)
        val price: TextView = itemView.findViewById(R.id.price)
        val pricex: TextView = itemView.findViewById(R.id.pricex)
        val like: ImageView = itemView.findViewById(R.id.like)
        val card: CardView = itemView.findViewById(R.id.card_product)
        var liked: Boolean = false
    }
}