package com.example.myapplication.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getExtras()
    }

    private fun getExtras(){
        intent.extras?.let {bundle->
            val id = bundle.getString(MainActivity.ID_EXTRA)
            val value = bundle.getString(MainActivity.VALUE_EXTRA)
            val update = bundle.getString(MainActivity.UPDATE_EXTRA)

            binding.tvId.text = id
            binding.tvCreateData.text = value
            binding.tvUpdate.text = update
        }
    }
}