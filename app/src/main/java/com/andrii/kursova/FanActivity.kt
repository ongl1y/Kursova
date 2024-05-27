package com.andrii.kursova

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FanActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var socketAmdTextView: TextView
    private lateinit var socketIntelTextView: TextView
    private lateinit var tdpTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    // Змінні для збереження обраної компоненти та зображення
    private var selectedComponent: String = ""
    private var selectedComponentImageResource: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fan)

        spinner = findViewById(R.id.fan_spinner)
        socketAmdTextView = findViewById(R.id.socketAmdTextView)
        socketIntelTextView = findViewById(R.id.socketIntelTextView)
        tdpTextView = findViewById(R.id.tdpTextView)
        imageView = findViewById(R.id.fanImageView)
        button = findViewById(R.id.button_fan)

        // Отримання списку вентиляторів
        val fans = Fan.getFan()

        // Імена вентиляторів для Spinner
        val componentNames = fans.map { it.name }

        // Адаптер для Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, componentNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Слухач для Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedFan = fans[position]
                imageView.setImageResource(selectedFan.image)
                socketAmdTextView.text = "Сокет AMD: ${selectedFan.socketamd}"
                socketIntelTextView.text = "Сокет Intel: ${selectedFan.socketintel}"
                tdpTextView.text = "TDP: ${selectedFan.tdp}"

                // Збереження обраної компоненти та зображення
                selectedComponent = selectedFan.name
                selectedComponentImageResource = selectedFan.image
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Дія, якщо нічого не вибрано
            }
        }

        button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("componentType", "fan")
            intent.putExtra("selectedComponent", selectedComponent)
            intent.putExtra("selectedComponentImage", selectedComponentImageResource)
            startActivity(intent)
            finish()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        // Повернення до попередньої активності
        finish()
    }
}
