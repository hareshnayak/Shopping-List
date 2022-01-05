package com.hareshnayak.shoplist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.hareshnayak.shoplist.R
import com.hareshnayak.shoplist.data.db.ShoppingDatabase
import com.hareshnayak.shoplist.data.repositories.ShoppingRepository

class ShoppingActivity : AppCompatActivity() {

    lateinit var viewModel: ShoppingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository =  ShoppingRepository(database)
        val viewModelProviderFactory = ViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[ShoppingViewModel::class.java]

    }
}