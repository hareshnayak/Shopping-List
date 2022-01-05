package com.hareshnayak.shoplist.ui

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.hareshnayak.shoplist.R
import com.hareshnayak.shoplist.data.db.enities.ShoppingItem

class AddItemDialog(
    context: Context, var addItemDialogListener: AddItemDialogListener
) : AppCompatDialog(context){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_item)
        findViewById<TextView>(R.id.tv_add)!!.setOnClickListener {
            val name = findViewById<EditText>(R.id.ed_add_item)?.text
            if(name==null) {
                Toast.makeText(context, "Please enter the Item name to add",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item = ShoppingItem(name.toString(),1)
            addItemDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        findViewById<TextView>(R.id.tv_cancel)!!.setOnClickListener{
            cancel()
        }
    }
}