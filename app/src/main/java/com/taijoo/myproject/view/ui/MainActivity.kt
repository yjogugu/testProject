package com.taijoo.myproject.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.taijoo.myproject.R
import com.taijoo.myproject.data.model.BookStore
import com.taijoo.myproject.data.model.Store
import com.taijoo.myproject.databinding.ActivityMainBinding
import com.taijoo.myproject.module.BookStoreQualifier
import com.taijoo.myproject.module.ClothingStoreQualifier
import com.taijoo.myproject.view.adapter.MainAdapter
import com.taijoo.myproject.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocketListener
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    private lateinit var adapter : MainAdapter

    @BookStoreQualifier
    @Inject lateinit var bookStore : Store

    @ClothingStoreQualifier
    @Inject lateinit var clothingStore : Store

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            binding.rv.setHasFixedSize(true)
            binding.rv.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.lifecycleOwner = this@MainActivity
        }

        Log.e("das","asd")

        lifecycleScope.launch {
            viewModel.item.collectLatest {
                adapter = MainAdapter(it)
                binding.rv.adapter = adapter
            }
        }

        bookStore.open()

        clothingStore.open()



    }


}