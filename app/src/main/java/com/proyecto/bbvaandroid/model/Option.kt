package com.proyecto.bbvaandroid.model

import androidx.annotation.DrawableRes
import com.proyecto.bbvaandroid.util.Options

/**
 * Created by AbelTarazona on 10/01/2021
 */
data class Option(
    val id: Options,
    val title: String,
    @DrawableRes val image: Int
)