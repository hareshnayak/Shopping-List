package com.hareshnayak.shoplist.data.repositories

import com.hareshnayak.shoplist.data.db.ShoppingDatabase
import com.hareshnayak.shoplist.data.db.enities.ShoppingItem



// ViewModel accesses the functions / data from the repository
class ShoppingRepository(
    private var db: ShoppingDatabase
){
    suspend fun upsert(item: ShoppingItem) = db.getItemDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getItemDao().delete(item)

    fun getAllItems() = db.getItemDao().getAllItems()
}