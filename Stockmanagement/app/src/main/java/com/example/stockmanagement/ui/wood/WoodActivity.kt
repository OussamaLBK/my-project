package com.example.stockmanagement.ui.wood

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmanagement.R
import com.example.stockmanagement.ui.waterpoint.AddActivityWp
import com.example.stockmanagement.ui.waterpoint.AddNewWp
import com.example.stockmanagement.ui.waterpoint.DashActivityWp
import com.example.stockmanagement.ui.waterpoint.StockActivityWp

class WoodActivity:AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    lateinit var addBtn: Button
    lateinit var removeBtn: Button
    lateinit var showBtn: Button
    lateinit var addNewBtn: Button
    lateinit var stockBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wood)




        addBtn=findViewById(R.id.add_btn)
        stockBtn=findViewById(R.id.stock_btn)
        addNewBtn=findViewById(R.id.addNew_btn)
        showBtn=findViewById(R.id.dashBoard_btn)


        stockBtn.setOnClickListener {
            startActivity(Intent(this, StockActivityW::class.java))
        }
        addBtn.setOnClickListener {

            startActivity(Intent(this, AddActivityW::class.java))
        }

        addNewBtn.setOnClickListener {
            startActivity(Intent(this, AddNewW::class.java))
        }
        showBtn.setOnClickListener {
            startActivity(Intent(this, DashActivityW::class.java))
        }

    }
}