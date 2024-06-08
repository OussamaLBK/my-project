package com.example.stockmanagement.ui.construction

import com.example.stockmanagement.db.Dashboard
import com.example.stockmanagement.db.DashboardDao

class DashboardRepositoryL(private val dashboardDao: DashboardDao) {
  /*  suspend fun insertOrUpdateProduct(product: Dashboard) {
        val existingProduct = dashboardDao.getDashboardByReference(product.reference).value
        if (existingProduct != null) {
            // Product already exists, update the quantity
            val updatedQuantity = existingProduct.quatity + product.quatity
            existingProduct.quatity = updatedQuantity
            dashboardDao.insertOrUpdate(existingProduct)
        } else {
            // Product doesn't exist, insert a new one
            dashboardDao.insertOrUpdate(product)
        }
    }*/
}