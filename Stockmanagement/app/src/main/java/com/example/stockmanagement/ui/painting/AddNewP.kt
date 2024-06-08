package com.example.stockmanagement.ui.painting

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.stockmanagement.ui.main.MainApplication
import com.example.stockmanagement.R
import com.example.stockmanagement.db.Product
import com.example.stockmanagement.db.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNewP : AppCompatActivity() {

    lateinit var addBtn: Button
    lateinit var input_name: EditText
    lateinit var input_ref: EditText
    val productDao = MainApplication.databaseP.getProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addnewp)

        input_name = findViewById(R.id.name_input)
        input_ref = findViewById(R.id.ref)
        addBtn = findViewById(R.id.add_btn)

        addBtn.setOnClickListener {
            val name = input_name.text.toString()
            val ref = input_ref.text.toString()
            if(name.isNotBlank()||ref.isNotBlank()){
                addProduct(name, ref)
                Toast.makeText(applicationContext, "Added seccesfully !!", Toast.LENGTH_SHORT)
                    .show()

            }else {
                Toast.makeText(applicationContext, "Please fill in all fields ", Toast.LENGTH_SHORT)
                    .show()

            }

        }
    }

   private fun addProduct(name: String, reference: String) {
       CoroutineScope(Dispatchers.IO).launch {
            productDao.addProduct(Product(name = name, reference = reference))
        }
    }
}
