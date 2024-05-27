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

class CaseActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var formfactorTextView: TextView
    private lateinit var weightTextView: TextView
    private lateinit var sizeTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    // Variables to store the selected component and image
    private var selectedComponent: String = ""
    private var selectedComponentImageResource: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_case)

        spinner = findViewById(R.id.case_spinner)
        formfactorTextView = findViewById(R.id.formfactorTextView)
        weightTextView = findViewById(R.id.weightTextView)
        sizeTextView = findViewById(R.id.sizeTextView)
        imageView = findViewById(R.id.caseImageView)
        button = findViewById(R.id.button_case)

        // Get the list of cases
        val cases = Case.getCase()

        // Names of cases for Spinner
        val caseNames = cases.map { it.name }

        // Adapter for Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, caseNames)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // Listener for Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedCase = cases[position]
                imageView.setImageResource(selectedCase.image)
                formfactorTextView.text = "Форм-фактор: ${selectedCase.formfactor}"
                weightTextView.text = "Вага: ${selectedCase.weight}"
                sizeTextView.text = "Розміри: ${selectedCase.size}"

                // Store the selected component and image
                selectedComponent = selectedCase.name
                selectedComponentImageResource = selectedCase.image
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Action if nothing is selected
            }
        }

        button.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("componentType", "case")
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