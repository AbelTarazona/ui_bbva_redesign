package com.proyecto.bbvaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.proyecto.bbvaandroid.adapter.CardAdapter
import com.proyecto.bbvaandroid.adapter.MovementAdapter
import com.proyecto.bbvaandroid.adapter.OptionAdapter
import com.proyecto.bbvaandroid.databinding.ActivityDetailCardBinding
import com.proyecto.bbvaandroid.databinding.ActivityMainBinding
import com.proyecto.bbvaandroid.util.*

class DetailCardActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityDetailCardBinding::inflate)
    private lateinit var adapterOption: OptionAdapter
    private lateinit var adapterMovement: MovementAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configBar()

        adapterOption = OptionAdapter()
        adapterMovement = MovementAdapter(getMovements())

        binding.include3.rvOptionsDetail.adapter = adapterOption
        adapterOption.submitList(getOptionsDetail())
        binding.containerMovement.rvMovement.adapter = adapterMovement
    }

    private fun configBar() {
        setSupportActionBar(binding.containerToolbar.toolbar)
        binding.containerToolbar.toolbar.setNavigationIcon(R.drawable.ic_icon_feather_arrow_left)
        binding.containerToolbar.titleToolbar.text = "Cuenta *37265"
        binding.containerToolbar.titleToolbar.setTextColor(resources.getColor(R.color.blue))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}