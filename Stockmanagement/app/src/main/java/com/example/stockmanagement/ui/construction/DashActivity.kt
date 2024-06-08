package com.example.stockmanagement.ui.construction

import DashboardAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmanagement.R
import com.example.stockmanagement.db.History
import com.example.stockmanagement.ui.main.MainApplication


class DashActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DashboardAdapter
    private val historyDao = MainApplication.database.getHistoryDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

       historyDao.getAllHistory().observe(this, Observer<List<History>> { historyList ->
            adapter = DashboardAdapter(this, historyList, historyDao)
            recyclerView.adapter = adapter
        })
    }

}
