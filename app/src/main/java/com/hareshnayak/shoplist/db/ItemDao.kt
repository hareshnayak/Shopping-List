package com.hareshnayak.shoplist.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface ItemDao {
    @Insert(onConflict = REPLACE)    // On conflict strategy
    //Suspend fun as the queries are not to be run in the main thread and and a new coroutine has to be launched
    suspend fun upsert(item: ShoppingItem)   // A mix of update and insert functions - if already not present insert or else update

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items ")
    fun getAllItems(): LiveData<List<ShoppingItem>> // LiveDat makes it easier to update the data
}