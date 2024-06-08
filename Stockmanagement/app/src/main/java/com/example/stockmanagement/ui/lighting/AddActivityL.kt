package com.example.stockmanagement.ui.lighting

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.stockmanagement.ui.main.MainApplication
import com.example.stockmanagement.R
import com.example.stockmanagement.db.Dashboard
import com.example.stockmanagement.db.History
import com.example.stockmanagement.db.DashboardDao


import com.example.stockmanagement.db.Product
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddActivityL : AppCompatActivity() {

    lateinit var addBtn: Button
    lateinit var quantityInput: EditText
    lateinit var dateInput: EditText
    lateinit var in_out: Spinner

    private lateinit var spinner: Spinner
    private val historyDao = MainApplication.databaseL.getHistoryDao()
    private val dashboardDao = MainApplication.databaseL.getDashboardDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_l)

        val productDao = MainApplication.databaseL.getProductDao()
        in_out = findViewById(R.id.in_out)
        quantityInput = findViewById(R.id.quantity_input)
        dateInput = findViewById(R.id.date_input)
        addBtn = findViewById(R.id.add_btn)
        spinner = findViewById(R.id.ref)

        val items = arrayOf("In", "Out")
        val adapterI = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapterI.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        in_out.adapter = adapterI

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mutableListOf())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        productDao.getAllProducts().observe(this, Observer<List<Product>> { products ->
            val productNames = products.map { it.name }
            adapter.clear()
            adapter.addAll(productNames)
            adapter.notifyDataSetChanged()
        })

        addBtn.setOnClickListener {
            val ref = spinner.selectedItem.toString()
            val date = dateInput.text.toString()
            val quantity = quantityInput.text.toString().toIntOrNull()
            val inOrOUT = in_out.selectedItem.toString()

            if (ref.isNotBlank() && date.isNotBlank() && quantity != null) {
                addHistory(date, ref, quantity, inOrOUT)
                updateDashboard(ref, quantity, inOrOUT)
                Toast.makeText(applicationContext, "Added successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addHistory(date: String, reference: String, quantity: Int, inOrOUT: String) {
        val history = History(quatity = quantity, reference = reference, date = date, in_out = inOrOUT)
        GlobalScope.launch {
            historyDao.addHistory(history)
        }
    }

    private fun updateDashboard(reference: String, quantity: Int, inOrOUT: String) {
        GlobalScope.launch {
            val existingProduct = dashboardDao.getDashboardByReference(reference).value
            if (existingProduct != null) {
                val updatedQuantity = if (inOrOUT == "In") {
                    existingProduct.quatity + quantity
                } else {
                    existingProduct.quatity - quantity
                }
                existingProduct.quatity = updatedQuantity // Modify the local copy
                dashboardDao.updateDashboard(existingProduct)
            } else {
                // Product doesn't exist, create a new one
                val product = Dashboard(productName = reference, reference = reference, quatity = quantity)
                dashboardDao.addDashboard(product)
            }
        }
    }
}
