package com.example.stockmanagement.db
import androidx.lifecycle.LiveData
import com.example.stockmanagement.db.Product
import com.example.stockmanagement.db.ProductDao
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class ProductRepository(private val productDao: ProductDao) {

    private val firestoreDB = FirebaseFirestore.getInstance()
    private val productsCollection = firestoreDB.collection("products")

    val allProducts: LiveData<List<Product>> = productDao.getAllProducts()

    suspend fun insert(product: Product) {
        val id = addProductToFirestore(product)
        val productWithId = product.copy(id = id.toLong())
        productDao.addProduct(productWithId)
    }

    suspend fun delete(product: Product) {
        productDao.deleteProduct(product)
        deleteProductFromFirestore(product)
    }

    private suspend fun addProductToFirestore(product: Product): String {
        val document = productsCollection.add(product).await()
        return document.id
    }

    private suspend fun deleteProductFromFirestore(product: Product) {
        productsCollection.document(product.id.toString()).delete().await()
    }
}
