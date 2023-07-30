package com.example.cart.listener

import com.example.cart.model.ProductModel

class ProductLoadListener {
    fun onProductLoadSuccess(productModelList:List<ProductModel>?)
    fun onProductLoadFailed(message:String?)


}