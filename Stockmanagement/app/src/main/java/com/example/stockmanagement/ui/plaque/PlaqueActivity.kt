package com.example.stockmanagement.ui.plaque

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.stockmanagement.R
import com.example.stockmanagement.ui.lighting.AddActivityL
import com.example.stockmanagement.ui.lighting.AddNewL
import com.example.stockmanagement.ui.lighting.DashActivityL
import com.example.stockmanagement.ui.lighting.StockActivityL

class PlaqueActivity:AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    lateinit var addBtn: Button
    lateinit var removeBtn: Button
    lateinit var showBtn: Button
    lateinit var addNewBtn: Button
    lateinit var stockBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plaques)




        addBtn=findViewById(R.id.add_btn)
        stockBtn=findViewById(R.id.stock_btn)
        addNewBtn=findViewById(R.id.addNew_btn)
        showBtn=findViewById(R.id.dashBoard_btn)


        stockBtn.setOnClickListener {
            startActivity(Intent(this, StockActivityPl::class.java))
        }
        addBtn.setOnClickListener {

            startActivity(Intent(this, AddActivityPl::class.java))
        }

        addNewBtn.setOnClickListener {
            startActivity(Intent(this, AddNewPl::class.java))
        }
        showBtn.setOnClickListener {
            startActivity(Intent(this, DashActivityPl::class.java))
        }

    }
}