package com.hareshnayak.shoplist.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [ShoppingItem::class],          // List of all the entities in the database
    version = 1                                // version of the database, change if update database
)
abstract class ShoppingDatabase : RoomDatabase() {     // ShoppingDatabase inherits from RoomDatabase

    abstract fun getItemDao(): ItemDao      // To access all the functions of ItemDao from Database

    // Only a single instance of the Database is required, hence, this is a Singleton
    companion object{

    }
}