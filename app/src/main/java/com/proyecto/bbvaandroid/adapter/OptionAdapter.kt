package com.proyecto.bbvaandroid.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.proyecto.bbvaandroid.R
import com.proyecto.bbvaandroid.databinding.ItemOptionBinding
import com.proyecto.bbvaandroid.util.inflate
import com.proyecto.bbvaandroid.model.Option

/**
 * Created by AbelTarazona on 10/01/2021
 */
class OptionAdapter : ListAdapter<Option, OptionAdapter.OptionViewHolder>(OptionDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val view = parent.inflate(R.layout.item_option)
        return OptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class OptionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemOptionBinding.bind(view)
        fun bind(data: Option) {
            with(binding) {
                textView12.text = data.title
                imageView9.setImageDrawable(itemView.context.getDrawable(data.image))
            }
        }
    }

}

class OptionDiffCallback : DiffUtil.ItemCallback<Option>() {
    override fun areItemsTheSame(oldItem: Option, newItem: Option): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Option, newItem: Option): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }

}