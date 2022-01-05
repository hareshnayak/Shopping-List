package com.hareshnayak.shoplist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hareshnayak.shoplist.data.db.enities.ShoppingItem


@Database(
    entities = [ShoppingItem::class],          // List of all the entities in the database
    version = 1                                // version of the database, change if update database
)
abstract class ShoppingDatabase : RoomDatabase() {     // ShoppingDatabase inherits from RoomDatabase

    abstract fun getItemDao(): ItemDao      // To access all the functions of ItemDao from Database

    // Only a single instance of the Database is required, hence, this is a Singleton
    companion object{
        @Volatile       // this instance will be visible to other threads too
        private var instance: ShoppingDatabase?= null
        private val LOCK  = Any()

        // This function is called when the instance of Database is created
        operator fun invoke(context: Context) = instance ?:
        // if instance is null then called synchronized so that the instance is in one thread only
        synchronized(LOCK){
            instance ?:
            // if the instance is still null then createDatabase
            createDatabase(context).also{ instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, ShoppingDatabase::class.java, "ShoppingDB.db").build()
    }
}