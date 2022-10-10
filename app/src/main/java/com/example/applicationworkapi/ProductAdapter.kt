package com.example.applicationworkapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.applicationworkapi.model.Product
import kotlinx.android.synthetic.main.product_item.view.*

class ProductAdapter(
    private val context: Context,
    private val productList: List<Product>
    ): RecyclerView.Adapter<ProductViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder( LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false) )

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val item:Product = productList[position]
        holder.productName.text = item.prName
        holder.productPrice.text = item.prPrice
        Glide.with(context).load(item.prImage).into(holder.productImage)

    }
}

class ProductViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val productImage: ImageView = itemView.ivProduct
    val productName: TextView = itemView.tvNameProduct
    val productPrice: TextView = itemView.tvPriceProduct
}