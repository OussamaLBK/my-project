package com.example.stockmanagement.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stockmanagement.db.Product
import com.example.stockmanagement.db.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {

    val allProducts: LiveData<List<Product>> = repository.allProducts

    fun insert(product: Product) = viewModelScope.launch {
        repository.insert(product)
    }

    fun delete(product: Product) = viewModelScope.launch {
        repository.delete(product)
    }
}
