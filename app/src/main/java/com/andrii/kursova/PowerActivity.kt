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

class PowerActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var powerTextView: TextView
    private lateinit var certificateTextView: TextView
    private lateinit var motherPowerTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    // Змінні для збереження обраної компоненти та зображення
    private var selectedComponent: String = ""
    private var selectedComponentImageResource: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_power)

        spinner = findViewById(R.id.power_spinner)
        powerTextView = findViewById(R.id.powerTextView)
        certificateTextView = findViewById(R.id.certificateTextView)
        motherPowerTextView = findViewById(R.id.motherPowerTextView)
        imageView = findViewById(R.id.powerImageView)
        button = findViewById(R.id.button_power)

        // Отримання списку блоків живлення
        val powers = Power.getPower()

        // Імена блоків живлення для Spinner
        val componentNames = powers.map { it.name }

        // Адаптер для Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, componentNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Слухач для Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedPower = powers[position]
                imageView.setImageResource(selectedPower.image)
                powerTextView.text = "Потужність: ${selectedPower.power}"
                certificateTextView.text = "Сертифікат: ${selectedPower.certificate}"
                motherPowerTextView.text = "Материнське живлення: ${selectedPower.motherpower}"

                // Збереження обраної компоненти та зображення
                selectedComponent = selectedPower.name
                selectedComponentImageResource = selectedPower.image
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Дія, якщо нічого не вибрано
            }
        }

        button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("componentType", "power")
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
