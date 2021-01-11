package com.proyecto.bbvaandroid.model

import com.proyecto.bbvaandroid.util.TypeAmount

/**
 * Created by AbelTarazona on 10/01/2021
 */
data class Movement(
    val title: String,
    val detail: String,
    val amount: Double,
    val type: TypeAmount,
    val date: String
)