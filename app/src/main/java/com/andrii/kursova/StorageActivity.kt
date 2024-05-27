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

class StorageActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var capacityTextView: TextView
    private lateinit var formFactorTextView: TextView
    private lateinit var m2TextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    // Змінні для збереження обраної компоненти та зображення
    private var selectedComponent: String = ""
    private var selectedComponentImageResource: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storage)

        spinner = findViewById(R.id.storage_spinner)
        capacityTextView = findViewById(R.id.capacityTextView)
        formFactorTextView = findViewById(R.id.formFactorTextView)
        m2TextView = findViewById(R.id.m2TextView)
        imageView = findViewById(R.id.storageImageView)
        button = findViewById(R.id.button_storage)

        // Отримання списку пристроїв зберігання
        val storageDevices = Storage.getStorage()

        // Імена пристроїв зберігання для Spinner
        val componentNames = storageDevices.map { it.name }

        // Адаптер для Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, componentNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Слухач для Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedStorage = storageDevices[position]
                imageView.setImageResource(selectedStorage.image)
                capacityTextView.text = "Об'єм: ${selectedStorage.capacity}"
                formFactorTextView.text = "Форм-фактор: ${selectedStorage.formfactor}"
                m2TextView.text = "M.2: ${selectedStorage.m2}"

                // Збереження обраної компоненти та зображення
                selectedComponent = selectedStorage.name
                selectedComponentImageResource = selectedStorage.image
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Дія, якщо нічого не вибрано
            }
        }

        button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("componentType", "storage")
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
