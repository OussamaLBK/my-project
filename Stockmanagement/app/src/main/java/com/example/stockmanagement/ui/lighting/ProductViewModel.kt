package com.example.stockmanagement.ui.construction

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.stockmanagement.ui.main.MainApplication
import com.example.stockmanagement.db.Product

class ProductViewModel : ViewModel() {
 val productDao= MainApplication.database.getProductDao()
    val productList:LiveData<List<Product>> =productDao.getAllProducts()

    fun addProduct(name: String, reference: String) {
        productDao.addProduct(Product(name = name, reference = reference))
    }



}