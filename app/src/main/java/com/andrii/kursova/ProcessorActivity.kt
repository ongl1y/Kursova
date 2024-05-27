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

class ProcessorActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var socketTextView: TextView
    private lateinit var frequencyTextView: TextView
    private lateinit var processorImageView: ImageView
    private lateinit var button: Button
    private lateinit var tdpTextView: TextView

    private var selectedComponent: String = ""
    private var selectedComponentImageResource: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_processor)

        spinner = findViewById(R.id.processor_spinner)
        socketTextView = findViewById(R.id.socketTextView)
        frequencyTextView = findViewById(R.id.frequencyTextView)
        processorImageView = findViewById(R.id.processorImageView)
        button = findViewById(R.id.button)
        tdpTextView = findViewById(R.id.tdpTextView)

        // Отримання списку процесорів
        val processors = Processor.getProcessors()

        // Отримання назви обраного компонента з попередньої активності
        val componentNames = processors.map { it.name }

        // Адаптер для Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, componentNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Слухач для Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedProcessor = processors[position]
                processorImageView.setImageResource(selectedProcessor.image)
                socketTextView.text = "Сокет: ${selectedProcessor.socket}"
                frequencyTextView.text = "Частота: ${selectedProcessor.frequency}"
                tdpTextView.text = "TDP: ${selectedProcessor.tdp}"


                // Зберегти обрану компоненту та зображення
                selectedComponent = selectedProcessor.name
                selectedComponentImageResource = selectedProcessor.image
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Дія, якщо нічого не вибрано
            }
        }

        button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("componentType", "processor")
            intent.putExtra("selectedComponent", selectedComponent)
            intent.putExtra("selectedComponentImage", selectedComponentImageResource)
            startActivity(intent)
            finish()
        }
    }
}
