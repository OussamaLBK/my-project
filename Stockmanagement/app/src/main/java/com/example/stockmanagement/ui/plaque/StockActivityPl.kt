package com.example.stockmanagement.ui.plaque

import DashboardAdapter
import StockAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmanagement.R

import com.example.stockmanagement.db.Product
import com.example.stockmanagement.ui.main.MainApplication


class StockActivityPl: AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StockAdapter
    private val productDao = MainApplication.databasePl.getProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stock)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        productDao.getAllProducts().observe(this, Observer<List<Product>> { productList ->
            adapter = StockAdapter(this, productList, productDao )
            recyclerView.adapter = adapter
        })
    }
}