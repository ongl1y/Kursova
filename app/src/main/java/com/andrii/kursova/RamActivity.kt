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

class RamActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var capacityTextView: TextView
    private lateinit var ddrTextView: TextView
    private lateinit var frequencyTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    // Змінні для збереження обраної компоненти та зображення
    private var selectedComponent: String = ""
    private var selectedComponentImageResource: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ram)

        spinner = findViewById(R.id.ram_spinner)
        capacityTextView = findViewById(R.id.capacityTextView)
        ddrTextView = findViewById(R.id.ddrTextView)
        frequencyTextView = findViewById(R.id.frequencyTextView)
        imageView = findViewById(R.id.ramImageView)
        button = findViewById(R.id.button_ram)

        // Отримання списку оперативної пам'яті (RAM)
        val rams = Ram.getRAM()

        // Імена оперативної пам'яті (RAM) для Spinner
        val componentNames = rams.map { it.name }

        // Адаптер для Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, componentNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Слухач для Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedRam = rams[position]
                imageView.setImageResource(selectedRam.image)
                capacityTextView.text = "Об'єм пам'яті: ${selectedRam.capacity}"
                ddrTextView.text = "Тип пам'яті: ${selectedRam.ddr}"
                frequencyTextView.text = "Частота: ${selectedRam.ramfrequency}"

                // Зберегти обрану компоненту та зображення
                selectedComponent = selectedRam.name
                selectedComponentImageResource = selectedRam.image
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Дія, якщо нічого не вибрано
            }
        }

        button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("componentType", "ram")
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
