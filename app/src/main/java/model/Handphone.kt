package com.example.getgadget_2407051007.model

import androidx.annotation.DrawableRes

data class Handphone(
    val nama: String,
    val merk: String,
    val harga: String,
    @DrawableRes val imageRes: Int
)