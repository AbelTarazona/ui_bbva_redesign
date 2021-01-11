package com.proyecto.bbvaandroid.model

/**
 * Created by AbelTarazona on 10/01/2021
 */
data class Account(
    val account: String,
    val card: String,
    val amount: Double
) {
    fun getFormattedAmount() : String = "S/ ${String.format("%.2f", amount)}"
}