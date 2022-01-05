package com.hareshnayak.shoplist.ui

import com.hareshnayak.shoplist.data.db.enities.ShoppingItem

interface AddItemDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}
