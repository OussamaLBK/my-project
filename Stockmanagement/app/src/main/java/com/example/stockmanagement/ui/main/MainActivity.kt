package com.example.stockmanagement.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.stockmanagement.R
import com.example.stockmanagement.ui.construction.ConstructionActivity
import com.example.stockmanagement.ui.lighting.LightingActivity
import com.example.stockmanagement.ui.painting.PaintingActivity
import com.example.stockmanagement.ui.plaque.PlaqueActivity
import com.example.stockmanagement.ui.waterpoint.WaterPointActivity
import com.example.stockmanagement.ui.wood.WoodActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val constructionBtn: Button = findViewById(R.id.construction_btn)
        val paintingBtn: Button = findViewById(R.id.painting_btn)
        val lightingBtn: Button = findViewById(R.id.lighting_btn)
        val plaqueBtn: Button = findViewById(R.id.plaque_btn)
        val woodBtn: Button = findViewById(R.id.wood_btn)
        val waterPointBtn: Button = findViewById(R.id.water_point_btn)

        constructionBtn.setOnClickListener {
            // Navigate to Construction activity
            startActivity(Intent(this, ConstructionActivity::class.java))
        }

        paintingBtn.setOnClickListener {
            // Navigate to Painting activity
            startActivity(Intent(this, PaintingActivity::class.java))
        }

        lightingBtn.setOnClickListener {
            // Navigate to Lighting activity
            startActivity(Intent(this, LightingActivity::class.java))
        }

        plaqueBtn.setOnClickListener {
            // Navigate to Plaque activity
            startActivity(Intent(this, PlaqueActivity::class.java))
        }

        woodBtn.setOnClickListener {
            // Navigate to Wood activity
            startActivity(Intent(this, WoodActivity::class.java))
        }

        waterPointBtn.setOnClickListener {
            // Navigate to WaterPoint activity
            startActivity(Intent(this, WaterPointActivity::class.java))
        }
    }
}
