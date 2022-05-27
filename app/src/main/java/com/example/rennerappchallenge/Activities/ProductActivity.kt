package com.example.rennerappchallenge.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.rennerappchallenge.Adapters.ColorsAdapter
import com.example.rennerappchallenge.Adapters.ProductImagesAdapter
import com.example.rennerappchallenge.Adapters.SizesAdapter
import com.example.rennerappchallenge.Models.Product
import com.example.rennerappchallenge.R
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat

class ProductActivity : AppCompatActivity() {

    var mSelectedColor: Int = 0
    var mSelectedSize: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        setupToolbar()

        val product = this.intent.getParcelableExtra<Product>("EXTRA_PRODUCT")
        var liked = this.intent.getBooleanExtra("EXTRA_LIKED", false)

        val pager: ViewPager = findViewById(R.id.view_pager_product_images)
        val tvName: TextView = findViewById(R.id.product_name)
        val tvPrice: TextView = findViewById(R.id.product_price)
        val tvPriceX: TextView = findViewById(R.id.product_pricex)
        val tvNumRates: TextView = findViewById(R.id.product_nrates)
        val ivLiked: ImageView = findViewById(R.id.like)
        val rbRating: RatingBar = findViewById(R.id.product_rating_bar)
        val btBuy: RelativeLayout = findViewById(R.id.bt_buy)

        val adapter = ProductImagesAdapter(product!!.photos, this)
        pager.adapter = adapter


        val decFormat = DecimalFormat("#,###.00")
        val price = decFormat.format(product.price)
        val pricex = decFormat.format(product.price / 5)

        val reviews: Int = product.reviews

        tvName.text = product.name
        tvPrice.text = "R$ $price"
        tvPriceX.text = "5x de R$ $pricex sem juros* no cartão Renner"
        tvNumRates.text = "($reviews avaliações)"

        if (liked) {
            ivLiked.setImageResource(R.drawable.cards_heart)
        } else {
            ivLiked.setImageResource(R.drawable.cards_heart_outline)
        }

        rbRating.rating = product.rate.toFloat()

        val rvColors: RecyclerView = findViewById(R.id.recycler_view_colors)
        rvColors.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rvColors.adapter = ColorsAdapter(product.colors, this, this)

        val rvSizes: RecyclerView = findViewById(R.id.recycler_view_sizes)
        rvSizes.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rvSizes.adapter = SizesAdapter(product.sizes, this, this)

        ivLiked.setOnClickListener {
            liked = !liked

            if (liked) {
                ivLiked.setImageResource(R.drawable.cards_heart)
            } else {
                ivLiked.setImageResource(R.drawable.cards_heart_outline)
            }
        }

        btBuy.setOnClickListener {
            onSNACK(it)
        }
    }

    fun setColor(position: Int) {
        mSelectedColor = position
    }

    fun setSize(position: Int) {
        mSelectedSize = position
    }

    fun getColor(): Int {
        return mSelectedColor
    }

    fun getSize(): Int {
        return mSelectedSize
    }

    private fun setupToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = ""
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun onSNACK(view: View){
        //Snackbar(view)
        val snackbar = Snackbar.make(view, getText(R.string.sold),
            Snackbar.LENGTH_LONG).setAction("Action", null)
        snackbar.show()
    }
}