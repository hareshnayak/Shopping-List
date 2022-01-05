package com.hareshnayak.shoplist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.hareshnayak.shoplist.R
import com.hareshnayak.shoplist.adapter.ShoppingItemAdapter
import com.hareshnayak.shoplist.data.db.ShoppingDatabase
import com.hareshnayak.shoplist.data.db.enities.ShoppingItem
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

        val adapter = ShoppingItemAdapter(listOf(), viewModel)
        val recyclerView = findViewById<RecyclerView>(R.id.rvShoppingItems)
        val floatingActionButton = findViewById<FloatingActionButton>(R.id.fab)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.getAllItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        floatingActionButton.setOnClickListener {
            AddItemDialog(this,
                object : AddItemDialogListener{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }

    }
}