package com.example.stockmanagement.ui.waterpoint

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmanagement.R
import com.example.stockmanagement.ui.plaque.AddActivityPl
import com.example.stockmanagement.ui.plaque.AddNewPl
import com.example.stockmanagement.ui.plaque.DashActivityPl
import com.example.stockmanagement.ui.plaque.StockActivityPl

class WaterPointActivity:AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    lateinit var addBtn: Button
    lateinit var removeBtn: Button
    lateinit var showBtn: Button
    lateinit var addNewBtn: Button
    lateinit var stockBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_point)




        addBtn=findViewById(R.id.add_btn)
        stockBtn=findViewById(R.id.stock_btn)
        addNewBtn=findViewById(R.id.addNew_btn)
        showBtn=findViewById(R.id.dashBoard_btn)


        stockBtn.setOnClickListener {
            startActivity(Intent(this, StockActivityWp::class.java))
        }
        addBtn.setOnClickListener {

            startActivity(Intent(this, AddActivityWp::class.java))
        }

        addNewBtn.setOnClickListener {
            startActivity(Intent(this, AddNewWp::class.java))
        }
        showBtn.setOnClickListener {
            startActivity(Intent(this, DashActivityWp::class.java))
        }

    }
}


