package com.proyecto.bbvaandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proyecto.bbvaandroid.R
import com.proyecto.bbvaandroid.databinding.ItemMovementBinding
import com.proyecto.bbvaandroid.databinding.ItemMovementHeaderBinding
import com.proyecto.bbvaandroid.util.TypeAmount
import com.proyecto.bbvaandroid.util.UIMovementModel

/**
 * Created by AbelTarazona on 10/01/2021
 */
class MovementAdapter(
    private val list: ArrayList<UIMovementModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val v = layoutInflater.inflate(viewType, parent, false)

        return when (viewType) {
            R.layout.item_movement_header -> HeaderHolder(v)
            R.layout.item_movement -> ItemHolder(v)
            else -> null!!
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        when (holder) {
            is HeaderHolder -> holder.bind(item as UIMovementModel.HeaderModel)
            is ItemHolder -> holder.bind(item as UIMovementModel.MovementModel)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int) = when (list[position]) {
        is UIMovementModel.HeaderModel -> R.layout.item_movement_header
        is UIMovementModel.MovementModel -> R.layout.item_movement
        null -> throw IllegalStateException("Unknown view")
    }

    class HeaderHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMovementHeaderBinding.bind(view)
        fun bind(data: UIMovementModel.HeaderModel) {
            if (data.title.isEmpty()) {
                binding.textView23.visibility = View.GONE
            } else {
                binding.textView23.text = data.title
            }
        }
    }

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMovementBinding.bind(view)
        fun bind(data: UIMovementModel.MovementModel) {
            binding.textView19.text = data.item.title
            binding.textView20.text = data.item.detail
            binding.textView22.text = data.item.date
            binding.textView21.also {
                when (data.item.type) {
                    TypeAmount.INCREASE -> it.setTextColor(itemView.context.resources.getColor(R.color.increase))

                    TypeAmount.DECREASE -> it.setTextColor(itemView.context.resources.getColor(R.color.decrease))

                    TypeAmount.NEUTRAL -> it.setTextColor(itemView.context.resources.getColor(R.color.blue))
                }
                it.text = data.item.getAmountFormatted()
            }
        }


    }
}