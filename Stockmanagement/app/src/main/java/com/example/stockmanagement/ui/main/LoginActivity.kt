package com.example.stockmanagement.ui.main



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.stockmanagement.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameInput: EditText = findViewById(R.id.username_input)
        val passwordInput: EditText = findViewById(R.id.password_input)
        val loginBtn: Button = findViewById(R.id.login_btn)

        loginBtn.setOnClickListener {
            val username = usernameInput.text.toString()
            val password = passwordInput.text.toString()

            // For now, let's hardcode a username and password
            val validUsername = "admin"
            val validPassword = "password"

            if (username == validUsername && password == validPassword) {
                // Login successful, navigate to the main dashboard
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Login failed, show error message
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
