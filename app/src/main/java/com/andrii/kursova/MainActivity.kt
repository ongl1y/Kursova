package com.andrii.kursova

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPassword: EditText = findViewById(R.id.user_password)
        val button: Button = findViewById(R.id.registration_button)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
            finish()
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (login.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Не всі поля заповнені", Toast.LENGTH_LONG).show()
            } else {
                val user = User(login, email, password)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Користувач $login зареєстрований", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()

                // Переход на activity_home після успішної реєстрації
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
        }


    }
}
