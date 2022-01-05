package com.hareshnayak.shoplist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.hareshnayak.shoplist.R
import com.hareshnayak.shoplist.data.db.enities.ShoppingItem
import com.hareshnayak.shoplist.ui.ShoppingViewModel

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel:ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>(){
    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shopping, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]
        holder.itemView.findViewById<TextView>(R.id.tv_item_name).text = curShoppingItem.item_name
        holder.itemView.findViewById<TextView>(R.id.tv_item_count).text = curShoppingItem.item_price.toString()

        holder.itemView.findViewById<ImageView>(R.id.iv_delete).setOnClickListener {
            viewModel.delete(curShoppingItem)
        }
        holder.itemView.findViewById<ImageView>(R.id.iv_plus).setOnClickListener {
            curShoppingItem.item_price++
            viewModel.upsert(curShoppingItem)
        }
        holder.itemView.findViewById<ImageView>(R.id.iv_minus).setOnClickListener {
            if(curShoppingItem.item_price>0){
                curShoppingItem.item_price--
                viewModel.upsert(curShoppingItem)
            }
            else if(curShoppingItem.item_price==0){
            val tempName : String = curShoppingItem.item_name
            viewModel.delete(curShoppingItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}