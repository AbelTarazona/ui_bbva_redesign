package com.proyecto.bbvaandroid.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.proyecto.bbvaandroid.R
import com.proyecto.bbvaandroid.databinding.ItemAccountBinding
import com.proyecto.bbvaandroid.util.inflate
import com.proyecto.bbvaandroid.model.Account

/**
 * Created by AbelTarazona on 10/01/2021
 */
class AccountAdapter :
    ListAdapter<Account, AccountAdapter.AccountViewHolder>(AccountDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val view = parent.inflate(R.layout.item_account)
        return AccountViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class AccountViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemAccountBinding.bind(view)
        fun bind(data: Account) {
            with(binding) {
                textView9.text = data.account
                textView11.text = data.card
                textView10.text = data.getFormattedAmount()
            }
        }
    }
}

class AccountDiffCallback : DiffUtil.ItemCallback<Account>() {
    override fun areItemsTheSame(oldItem: Account, newItem: Account): Boolean {
        return oldItem.account == newItem.account
    }

    override fun areContentsTheSame(oldItem: Account, newItem: Account): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }

}