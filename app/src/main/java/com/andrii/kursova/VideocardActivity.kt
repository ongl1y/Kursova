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

class VideocardActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var memoryTextView: TextView
    private lateinit var typeMemoryTextView: TextView
    private lateinit var powerTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    // Змінні для збереження обраної компоненти та зображення
    private var selectedComponent: String = ""
    private var selectedComponentImageResource: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videocard)

        spinner = findViewById(R.id.videocard_spinner)
        memoryTextView = findViewById(R.id.memoryTextView)
        typeMemoryTextView = findViewById(R.id.type_memoryTextView)
        powerTextView = findViewById(R.id.videocard_powerTextView)
        imageView = findViewById(R.id.videocardimageView)
        button = findViewById(R.id.button_videocard)

        // Отримання списку відеокарт
        val videocards = Videocard.getVideocards()

        // Імена відеокарт для Spinner
        val componentNames = videocards.map { it.name }

        // Адаптер для Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, componentNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Слухач для Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedVideocard = videocards[position]
                imageView.setImageResource(selectedVideocard.image)
                memoryTextView.text = "GPU: ${selectedVideocard.memory}"
                typeMemoryTextView.text = "Тип пам'яті: ${selectedVideocard.memorytype}"
                powerTextView.text = "Додаткове живлення: ${selectedVideocard.power}"

                // Зберегти обрану компоненту та зображення
                selectedComponent = selectedVideocard.name
                selectedComponentImageResource = selectedVideocard.image
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Дія, якщо нічого не вибрано
            }
        }

        button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("componentType", "videocard")
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
