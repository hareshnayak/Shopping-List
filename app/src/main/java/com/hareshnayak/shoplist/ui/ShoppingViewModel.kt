package com.hareshnayak.shoplist.ui

import androidx.lifecycle.ViewModel
import com.hareshnayak.shoplist.data.db.enities.ShoppingItem
import com.hareshnayak.shoplist.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val repository: ShoppingRepository
) : ViewModel(){

    // Here fun need not be a suspend fun as we are launching a Coroutine
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllItems() = repository.getAllItems()
}
