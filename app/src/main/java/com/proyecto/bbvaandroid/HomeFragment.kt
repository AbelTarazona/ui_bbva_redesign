package com.proyecto.bbvaandroid

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.proyecto.bbvaandroid.adapter.AccountAdapter
import com.proyecto.bbvaandroid.adapter.CardAdapter
import com.proyecto.bbvaandroid.adapter.OptionAdapter
import com.proyecto.bbvaandroid.databinding.FragmentHomeBinding
import com.proyecto.bbvaandroid.util.getAccounts
import com.proyecto.bbvaandroid.util.getCards
import com.proyecto.bbvaandroid.util.getOptions


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapterAccount: AccountAdapter
    private lateinit var adapterOption: OptionAdapter
    private lateinit var adapterCards: CardAdapter

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configBar()
        adapterAccount = AccountAdapter()
        adapterOption = OptionAdapter()
        adapterCards = CardAdapter(getCards()) { openDetailScreen() }

        binding.containerAccount.rvAccounts.adapter = adapterAccount
        adapterAccount.submitList(getAccounts())
        binding.containerOptions.rvOptions.adapter = adapterOption
        adapterOption.submitList(getOptions())
        binding.containerCards.rvCards.adapter = adapterCards
    }

    private fun configBar() {
        changeStatusBar()
        (activity as AppCompatActivity).setSupportActionBar(binding.containerToolbar.toolbar)
        binding.containerToolbar.toolbar.setNavigationIcon(R.drawable.ic_icon_open_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    private fun changeStatusBar() {
        val window = activity!!.window
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(activity!!, R.color.blue)
    }

    private fun openDetailScreen() {
        startActivity(Intent(activity, DetailCardActivity::class.java))
    }

}