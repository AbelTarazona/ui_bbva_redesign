package com.proyecto.bbvaandroid.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proyecto.bbvaandroid.R
import com.proyecto.bbvaandroid.databinding.CardWhiteBinding
import com.proyecto.bbvaandroid.databinding.ItemCardMainBinding
import com.proyecto.bbvaandroid.model.Card
import com.proyecto.bbvaandroid.util.TypeCard
import com.proyecto.bbvaandroid.util.inflate

/**
 * Created by AbelTarazona on 10/01/2021
 */
class CardAdapter(
    private val list: List<Card>,
    private val onClickMainCard: () -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View

        when (viewType) {
            TypeCard.MAIN.ordinal -> {
                view = parent.inflate(R.layout.item_card_main)
                return MainHolder(view)
            }

            TypeCard.SECONDARY.ordinal -> {
                view = parent.inflate(R.layout.card_white)
                return SecondaryHolder(view)
            }
        }

        return null!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        when (item.type) {
            TypeCard.MAIN -> (holder as MainHolder).bind(item)
            TypeCard.SECONDARY -> (holder as SecondaryHolder).bind(item)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        if (!list.isNullOrEmpty()) {
            val item = list[position]
            return item.type.ordinal
        }
        return -1
    }

    inner class MainHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemCardMainBinding.bind(view)

        init {
            binding.include.root.setOnClickListener {
                onClickMainCard()
            }
        }

        fun bind(data: Card) {
            with(binding) {
                include.textView14.text = data.card
            }
        }
    }

    class SecondaryHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = CardWhiteBinding.bind(view)
        fun bind(data: Card) {
            with(binding) {
                textView14.text = data.card
            }
        }
    }
}