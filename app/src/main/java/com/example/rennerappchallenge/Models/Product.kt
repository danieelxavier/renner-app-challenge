package com.example.rennerappchallenge.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    var id: String,
    val name: String,
    val rate: Double,
    val reviews: Int,
    val price: Double,
    val photos: Array<String>,
    val sizes: Array<String>,
    val colors: Array<String>
) : Parcelable