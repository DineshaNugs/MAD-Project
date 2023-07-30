package com.example.cart.adapter

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cart.model.ProductModel

class MyProductAdapter {(
    private val context:context,
    private val list:List<ProductModel>
); RecyclerView.Adapter<MyProductAdapter.MyProductViewHolder>{
    class MyProductViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
        lateinit var imageView: ImageView
        lateinit var txtName: TextView
        lateinit var txtPrice: TextView

        init{

        }
    }
}


}