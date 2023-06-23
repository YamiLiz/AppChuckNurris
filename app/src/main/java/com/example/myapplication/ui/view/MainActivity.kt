package com.example.myapplication.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.Adapter.CategoriesAdapter
import com.example.myapplication.ui.viewmodel.GetCategoriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: GetCategoriesViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val ID_EXTRA = "id"
        const val VALUE_EXTRA = "value"
        const val UPDATE_EXTRA = "update"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.listCategories.observe(this) { list ->
            initRecycler(list)
        }

        viewModel.detailCategory.observe(this) { category ->
            Log.e("DETAIL", "Detail: ${category.toString()}")
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(ID_EXTRA, category.id)
            intent.putExtra(VALUE_EXTRA, category.value)
            intent.putExtra(UPDATE_EXTRA, category.updatedAt)
            startActivity(intent)
        }
        viewModel.getCategories()

    }

    private fun initRecycler(listCategories: List<String>) {
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CategoriesAdapter(listCategories) { category ->
                onCategorySelected(category)
            }
        }
    }

    private fun onCategorySelected(category: String) {
        viewModel.getDetailCategory(category)
    }

}