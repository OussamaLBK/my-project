package com.example.stockmanagement.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAllProducts (): LiveData<List<Product>>

    @Insert
    fun addProduct (product : Product)

    @Delete
    fun deleteProduct(product: Product)

    @Query("SELECT * FROM product WHERE id = :id")
    fun getProductById(id: Long): Product?

    @Query("SELECT * FROM product WHERE reference = :reference")
    fun getProductByReference(reference: String): LiveData<List<Product>>
    @Update
    fun updateProduct(product: Product)
}

@Dao
interface HistoryDao {
    @Query("SELECT * FROM history")
    fun getAllHistory (): LiveData<List<History>>

    @Insert
    fun addHistory (history: History)

    @Delete
    fun deleteHistory(history: History)

    @Update
    fun updateHistory(history: History)
}



@Dao
interface DashboardDao {
    @Query("SELECT * FROM dashboard")
    fun getAllProducts(): LiveData<List<Dashboard>>

    @Insert
    fun addDashboard(dashboard: Dashboard)

    @Delete
    fun deleteDashboard(dashboard: Dashboard)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(product: Dashboard)

    @Query("SELECT * FROM dashboard WHERE reference = :reference")
    fun getDashboardByReference(reference: String): LiveData<Dashboard>

    @Update
    fun updateDashboard(dashboard: Dashboard)
}
