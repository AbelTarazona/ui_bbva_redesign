package com.proyecto.bbvaandroid.util

import com.proyecto.bbvaandroid.R
import com.proyecto.bbvaandroid.model.*

/**
 * Created by AbelTarazona on 10/01/2021
 */

fun getAccounts() = listOf(
    Account(account = "001ah7297", card = "*37265", amount = 20000.0),
    Account(account = "001ah7246", card = "*36264", amount = 15800.0)
)

fun getOptions() = listOf(
    Option(id = Options.OPORTUNIDADES, title = "Oportunidades", R.drawable.option_oportunity),
    Option(id = Options.TRANSFERIR, title = "Transferir", R.drawable.options_transfer),
    Option(id = Options.RETIRO, title = "Retiro sin tarjeta", R.drawable.options_retiro),
    Option(id = Options.PAGO_SERVICIO, title = "Pagar servicio", R.drawable.options_config)
)

fun getOptionsDetail() = listOf(
    Option(id = Options.PAGO_SERVICIO, title = "Pagar servicio", R.drawable.option_pay_service),
    Option(id = Options.TRANSFERIR, title = "Transferir", R.drawable.options_transfer),
    Option(id = Options.RETIRO, title = "Retiro sin tarjeta", R.drawable.options_retiro),
    Option(id = Options.MORE, title = "6 más", R.drawable.options_more)
)

fun getCards() = listOf(
    Card(card = "*62396", type = TypeCard.MAIN),
    Card(card = "*62397", type = TypeCard.SECONDARY),
    Card(card = "*62398", type = TypeCard.SECONDARY),
    Card(card = "*62399", type = TypeCard.SECONDARY)
)

// Mock response from webservice
fun getMovementsResponse() = listOf(
    Movements(
        title = "", list = listOf(
            Movement(
                title = "Su pago en efectivo",
                detail = "Movimiento BBVA",
                amount = 1600.0,
                type = TypeAmount.INCREASE,
                date = "Hoy"
            ),
            Movement(
                title = "Spei enviado azteca",
                detail = "Transferencia interbancaria",
                amount = 3400.0,
                type = TypeAmount.DECREASE,
                date = "Hoy"
            ),
        )
    ),
    Movements(
        title = "2 enero", list = listOf(
            Movement(
                title = "Su pago en efectivo",
                detail = "Movimiento BBVA",
                amount = 190.0,
                type = TypeAmount.NEUTRAL,
                date = "Hoy"
            ),
            Movement(
                title = "Spei enviado azteca",
                detail = "Transferencia interbancaria",
                amount = 50.0,
                type = TypeAmount.DECREASE,
                date = "Hoy"
            ),
        )
    )
)

fun getMovements(): ArrayList<UIMovementModel> {
    val res = getMovementsResponse()
    val list = arrayListOf<UIMovementModel>()

    for (movements in res) {
        if (movements.title.isNotEmpty()) {
            list.add(UIMovementModel.HeaderModel(movements.title))
        }

        for (child in movements.list) {
            list.add(UIMovementModel.MovementModel(child))
        }
    }

    return list
}


sealed class UIMovementModel {
    class HeaderModel(val title: String) : UIMovementModel()
    class MovementModel(val item: Movement) : UIMovementModel()
}

enum class Options {
    OPORTUNIDADES,
    TRANSFERIR,
    RETIRO,
    PAGO_SERVICIO,
    MORE
}

enum class TypeCard {
    MAIN,
    SECONDARY
}

enum class TypeAmount {
    INCREASE,
    DECREASE,
    NEUTRAL
}
