package com.proyecto.bbvaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proyecto.bbvaandroid.databinding.ActivityMainBinding
import com.proyecto.bbvaandroid.util.replaceFragment
import com.proyecto.bbvaandroid.util.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bottomNavigationView.apply {
            setOnNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.home -> {
                        val fragment = HomeFragment.newInstance()
                        replaceFragment(fragment, R.id.container)
                        true
                    }

                    else -> false
                }
            }
            selectedItemId = R.id.home
        }

    }
}