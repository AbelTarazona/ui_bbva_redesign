package com.proyecto.bbvaandroid.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proyecto.bbvaandroid.R
import com.proyecto.bbvaandroid.databinding.ItemMovementBinding
import com.proyecto.bbvaandroid.databinding.ItemMovementHeaderBinding
import com.proyecto.bbvaandroid.model.MovementView
import com.proyecto.bbvaandroid.util.TypeAmount
import com.proyecto.bbvaandroid.util.TypeMovement
import com.proyecto.bbvaandroid.util.inflate

/**
 * Created by AbelTarazona on 10/01/2021
 */
class MovementAdapter(
    private val list: List<MovementView>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View

        when (viewType) {
            TypeMovement.HEADER.ordinal -> {
                view = parent.inflate(R.layout.item_movement_header)
                return HeaderHolder(view)
            }

            TypeMovement.SECONDARY.ordinal -> {
                view = parent.inflate(R.layout.item_movement)
                return ItemHolder(view)
            }
        }

        return null!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        when (item.typeView) {
            TypeMovement.HEADER -> (holder as HeaderHolder).bind(item)
            TypeMovement.SECONDARY -> (holder as ItemHolder).bind(item)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        if (!list.isNullOrEmpty()) {
            val item = list[position]
            return item.typeView.ordinal
        }
        return -1
    }

    class HeaderHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMovementHeaderBinding.bind(view)
        fun bind(data: MovementView) {
            if (data.title.isEmpty()) {
                binding.textView23.visibility = View.GONE
            } else {
                binding.textView23.text = data.title
            }
        }
    }

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMovementBinding.bind(view)
        fun bind(data: MovementView) {
            binding.textView19.text = data.title
            binding.textView20.text = data.detail
            binding.textView22.text = data.date
            binding.textView21.also {
                when (data.type) {
                    TypeAmount.INCREASE -> it.setTextColor(itemView.context.resources.getColor(R.color.increase))

                    TypeAmount.DECREASE -> it.setTextColor(itemView.context.resources.getColor(R.color.decrease))

                    TypeAmount.NEUTRAL -> it.setTextColor(itemView.context.resources.getColor(R.color.blue))
                }
                it.text = data.getAmountFormatted()
            }
        }


    }
}