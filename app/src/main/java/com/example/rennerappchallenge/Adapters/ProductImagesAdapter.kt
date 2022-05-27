package com.example.rennerappchallenge.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.rennerappchallenge.R

public class ProductImagesAdapter (val images: Array<String>, val context: Context) : PagerAdapter() {

    lateinit var mLayoutInflater: LayoutInflater

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return  view.equals(`object`)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        mLayoutInflater = LayoutInflater.from(context)

        val view: View = mLayoutInflater.inflate(R.layout.row_image, container, false)

        val img: ImageView = view.findViewById(R.id.product_image_item)
        val txt: TextView = view.findViewById(R.id.image_counter)

        val imageName: String = images[position]
        val id: Int = context.getResources().getIdentifier("com.example.rennerappchallenge:drawable/$imageName", null, null)
        img.setImageResource(id)

        val current = position + 1
        val total = images.size
        txt.text = "$current / $total"

        container.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}