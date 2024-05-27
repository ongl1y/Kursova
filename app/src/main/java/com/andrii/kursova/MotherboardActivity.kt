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

class MotherboardActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var socketTextView: TextView
    private lateinit var ddrTextView: TextView
    private lateinit var powerTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    // Змінні для збереження обраної компоненти та зображення
    private var selectedComponent: String = ""
    private var selectedComponentImageResource: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motherboard)

        spinner = findViewById(R.id.motherboard_spinner)
        socketTextView = findViewById(R.id.socketTextView)
        ddrTextView = findViewById(R.id.ddrTextView)
        powerTextView = findViewById(R.id.powerTextView)
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.button)

        // Отримання списку материнських плат
        val motherboards = Motherboard.getMotherboards()

        // Імена материнських плат для Spinner
        val componentNames = motherboards.map { it.name }

        // Адаптер для Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, componentNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Слухач для Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedMotherboard = motherboards[position]
                imageView.setImageResource(selectedMotherboard.image)
                socketTextView.text = "Сокет: ${selectedMotherboard.socket}"
                ddrTextView.text = "DDRX: ${selectedMotherboard.ddr}"
                powerTextView.text = "Живлення: ${selectedMotherboard.motherpower}"


                // Зберегти обрану компоненту та зображення
                selectedComponent = selectedMotherboard.name
                selectedComponentImageResource = selectedMotherboard.image
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Дія, якщо нічого не вибрано
            }
        }

        button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("componentType", "motherboard")
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
