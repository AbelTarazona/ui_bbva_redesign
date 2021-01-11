package com.proyecto.bbvaandroid.model

import com.proyecto.bbvaandroid.util.TypeAmount
import com.proyecto.bbvaandroid.util.TypeMovement

/**
 * Created by AbelTarazona on 10/01/2021
 */
data class MovementView(
    val title: String,
    val typeView: TypeMovement,
    val detail: String?,
    val amount: Double?,
    val type: TypeAmount?,
    val date: String?
) {
    fun getAmountFormatted(): String {
        var amount = ""
        when (type) {
            TypeAmount.INCREASE -> amount = "+ S/ $amount"
            TypeAmount.DECREASE -> amount = "- S/ $amount"
            TypeAmount.NEUTRAL -> amount = "S/ $amount"
        }
        return amount
    }
}