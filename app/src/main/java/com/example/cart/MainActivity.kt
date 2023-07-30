package com.example.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cart.adapter.MyProductAdapter
import com.example.cart.model.ProductModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    lateinit var productLoadListener:ProductLoadListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

    }

    private fun loadProductFromFirebase(){
        val productModel : MutableList<ProductModel> =ArrayList()
        FirebaseDatabase.getInstance()
            .getReference(path:"Drink")
            .addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    for (productSnapshot in snapshot.children) {
                        val productModel = productSnapshot.getValue(ProductModel::class.java)
                        productModel!!.key = productSnapshot.key
                        productModel.add(productModel)
                    }
                    productLoadListener.onProductLoadSuccess(productModel)
                }else
                    productLoadListener.onProductLoadFailed("Product item not exists")
            }

            override fun onCancelled(error: DatabaseError) {
                productLoadListener.onProductLoadFailed(error.message)
            }
        })
    }

    private fun init(){
        productLoadListener =this

    }
    override fun onProductLoadSuccess(ProductModelList:List<DrinkModel>?){
        val adapter = MyProductAdapter(this.productModelList)
        recycler_product.adapter =adapter
    }
    override fun onProductLoadFailed(message: String?){
        Snackbar.make(mainLayout,message.Snackbar.LENGTH_LONG).show()
    }

}