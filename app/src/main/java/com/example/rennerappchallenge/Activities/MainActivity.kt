package com.example.rennerappchallenge.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rennerappchallenge.Adapters.ProductsAdapter
import com.example.rennerappchallenge.Models.Product
import com.example.rennerappchallenge.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.apply {
            setDisplayShowTitleEnabled(false)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = ProductsAdapter(loadProductsOffer(), this, this)

        val recyclerViewWomen = findViewById<RecyclerView>(R.id.recycler_view_women)
        recyclerViewWomen.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerViewWomen.adapter = ProductsAdapter(loadWomenProducts(), this, this)

        val recyclerViewMen = findViewById<RecyclerView>(R.id.recycler_view_men)
        recyclerViewMen.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recyclerViewMen.adapter = ProductsAdapter(loadMenProducts(), this, this)

    }

    fun goToProduct(product: Product, liked: Boolean) {
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra("EXTRA_PRODUCT", product)
        intent.putExtra("EXTRA_LIKED", liked)
        startActivity(intent)
    }

    fun loadProductsOffer() : ArrayList<Product> {
        val products: ArrayList<Product> = ArrayList()
        products.add(Product("0004", "BLUSA REGATA DE TRICÔ COM PONTO DIFERENCIADO",
            4.3, 19, 89.90, arrayOf<String>("f0004_1", "f0004_2"),
            arrayOf<String>("M", "G"), arrayOf<String>("#ADFF2F", "#000000")))
        products.add(Product("0008", "JAQUETA JEANS DESTROYED DELAVÊ",
            3.0, 2, 219.90, arrayOf<String>("f0008_1", "f0008_2"),
            arrayOf<String>("P", "M"), arrayOf<String>("#87CEEB")))
        products.add(Product("0001", "BLUSA EM SUEDINE COM BOTÃO NA BARA DA MANGA",
            4.7, 59, 59.90, arrayOf<String>("f0001_1", "f0001_2"),
            arrayOf<String>("PP"), arrayOf<String>("#8C705A", "#BC341F", "#FF0000", "#228B22", "#E0CBAF")))
        products.add(Product("0007", "BLUSÃO EM MOLETON COM CAPUZ E BOLSO CANGURU",
            4.8, 79, 159.90, arrayOf<String>("f0007_1", "f0007_2"),
            arrayOf<String>("PP", "P", "G"), arrayOf<String>("#FFFFFF", "#970017", "#5F97D2", "#FFFFE0", "#FD92A8", "#46402E", "#D29398")))
        products.add(Product("0003", "BLUSA BATA EM VISCOSE DECOTE OMBRO A OMBRO COM PREGAS",
            4.8, 13, 119.90, arrayOf<String>("f0003_1", "f0003_2"),
            arrayOf<String>("PP", "P"), arrayOf<String>("#DEB887", "#BC341F", "#FF0000")))
        products.add(Product("0005", "CAMISETA MANGA LONGA EM ALGODÃO COM GOLA MOCKNECK",
            5.0, 1, 89.90, arrayOf<String>("f0005_1", "f0005_2"),
            arrayOf<String>("PP", "P", "M", "G", "GG"), arrayOf<String>("#FFFFFF", "#000000")))

        return products
    }

    fun loadWomenProducts() : ArrayList<Product> {
        val products: ArrayList<Product> = ArrayList()
        products.add(Product("0001", "BLUSA EM SUEDINE COM BOTÃO NA BARA DA MANGA",
            4.7, 59, 59.90, arrayOf<String>("f0001_1", "f0001_2"),
            arrayOf<String>("PP"), arrayOf<String>("#8C705A", "#BC341F", "#FF0000", "#228B22", "#E0CBAF")))
        products.add(Product("0002", "CALÇA RETA EM VISCOSE SEM ESTAMPA COM PREGAS FRONTAIS",
            4.3, 9, 177.90, arrayOf<String>("f0002_1", "f0002_2"),
            arrayOf<String>("40", "42", "44"), arrayOf<String>("#FFC0CB", "#BC341F", "#FF0000")))
        products.add(Product("0003", "BLUSA BATA EM VISCOSE DECOTE OMBRO A OMBRO COM PREGAS",
            4.8, 13, 119.90, arrayOf<String>("f0003_1", "f0003_2"),
            arrayOf<String>("PP", "P"), arrayOf<String>("#DEB887", "#BC341F", "#FF0000")))
        products.add(Product("0004", "BLUSA REGATA DE TRICÔ COM PONTO DIFERENCIADO",
            4.3, 19, 89.90, arrayOf<String>("f0004_1", "f0004_2"),
            arrayOf<String>("M", "G"), arrayOf<String>("#ADFF2F", "#000000")))
        products.add(Product("0001", "BLUSA EM SUEDINE COM BOTÃO NA BARA DA MANGA",
            4.7, 59, 59.90, arrayOf<String>("f0001_1", "f0001_2"),
            arrayOf<String>("PP"), arrayOf<String>("#8C705A", "#BC341F", "#FF0000", "#228B22", "#E0CBAF")))
        products.add(Product("0002", "CALÇA RETA EM VISCOSE SEM ESTAMPA COM PREGAS FRONTAIS",
            4.3, 9, 177.90, arrayOf<String>("f0002_1", "f0002_2"),
            arrayOf<String>("40", "42", "44"), arrayOf<String>("#FFC0CB", "#BC341F", "#FF0000")))
        products.add(Product("0003", "BLUSA BATA EM VISCOSE DECOTE OMBRO A OMBRO COM PREGAS",
            4.8, 13, 119.90, arrayOf<String>("f0003_1", "f0003_2"),
            arrayOf<String>("PP", "P"), arrayOf<String>("#DEB887", "#BC341F", "#FF0000")))
        products.add(Product("0004", "BLUSA REGATA DE TRICÔ COM PONTO DIFERENCIADO",
            4.3, 19, 89.90, arrayOf<String>("f0004_1", "f0004_2"),
            arrayOf<String>("M", "G"), arrayOf<String>("#ADFF2F", "#000000")))

        return products
    }

    fun loadMenProducts() : ArrayList<Product> {
        val products: ArrayList<Product> = ArrayList()
        products.add(Product("0005", "CAMISETA MANGA LONGA EM ALGODÃO COM GOLA MOCKNECK",
            5.0, 1, 89.90, arrayOf<String>("f0005_1", "f0005_2"),
            arrayOf<String>("PP", "P", "M", "G", "GG"), arrayOf<String>("#FFFFFF", "#000000")))
        products.add(Product("0006", "CAMISETA EM ALGODÃO MANGA CURTA COM LETTERING AUTHENTICITY",
            4.9, 20, 59.90, arrayOf<String>("f0006_1", "f0006_2"),
            arrayOf<String>("PP", "P", "M", "G", "GG"), arrayOf<String>("#FFFFFF", "#000000")))
        products.add(Product("0007", "BLUSÃO EM MOLETON COM CAPUZ E BOLSO CANGURU",
            4.8, 79, 159.90, arrayOf<String>("f0007_1", "f0007_2"),
            arrayOf<String>("PP", "P", "G"), arrayOf<String>("#FFFFFF", "#970017", "#5F97D2", "#FFFFE0", "#FD92A8", "#46402E", "#D29398")))
        products.add(Product("0008", "JAQUETA JEANS DESTROYED DELAVÊ",
            3.0, 2, 219.90, arrayOf<String>("f0008_1", "f0008_2"),
            arrayOf<String>("P", "M"), arrayOf<String>("#87CEEB")))
        products.add(Product("0005", "CAMISETA MANGA LONGA EM ALGODÃO COM GOLA MOCKNECK",
            5.0, 1, 89.90, arrayOf<String>("f0005_1", "f0005_2"),
            arrayOf<String>("PP", "P", "M", "G", "GG"), arrayOf<String>("#FFFFFF", "#000000")))
        products.add(Product("0006", "CAMISETA EM ALGODÃO MANGA CURTA COM LETTERING AUTHENTICITY",
            4.9, 20, 59.90, arrayOf<String>("f0006_1", "f0006_2"),
            arrayOf<String>("PP", "P", "M", "G", "GG"), arrayOf<String>("#FFFFFF", "#000000")))
        products.add(Product("0007", "BLUSÃO EM MOLETON COM CAPUZ E BOLSO CANGURU",
            4.8, 79, 159.90, arrayOf<String>("f0007_1", "f0007_2"),
            arrayOf<String>("PP", "P", "G"), arrayOf<String>("#FFFFFF", "#970017", "#5F97D2", "#FFFFE0", "#FD92A8", "#46402E", "#D29398")))
        products.add(Product("0008", "JAQUETA JEANS DESTROYED DELAVÊ",
            3.0, 2, 219.90, arrayOf<String>("f0008_1", "f0008_2"),
            arrayOf<String>("P", "M"), arrayOf<String>("#87CEEB")))

        return products
    }

}