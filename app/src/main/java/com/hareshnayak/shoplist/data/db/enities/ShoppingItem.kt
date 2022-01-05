package com.hareshnayak.shoplist.data.db.enities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(

    // Parameters of the ShoppingItem Entity

    @ColumnInfo(name = "item_name")
    var item_name :String,

    @ColumnInfo(name = "item_price")
    var item_price :Int

) {
    @PrimaryKey(autoGenerate = false)           // We don't need to manually add any id
    val id : Int ?= null
}