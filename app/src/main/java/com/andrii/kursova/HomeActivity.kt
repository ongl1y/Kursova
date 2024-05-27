package com.andrii.kursova

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Налаштування кнопок для переходу до інших активностей
        val buttonMotherboard: ImageButton = findViewById(R.id.open_motherboard_activity)
        buttonMotherboard.setOnClickListener {
            val intent = Intent(this, MotherboardActivity::class.java)
            startActivity(intent)

        }

        val buttonProcessor: ImageButton = findViewById(R.id.open_processor_activity)
        buttonProcessor.setOnClickListener {
            val intent = Intent(this, ProcessorActivity::class.java)
            startActivity(intent)
        }

        val buttonVideocard: ImageButton = findViewById(R.id.open_videocard_activity)
        buttonVideocard.setOnClickListener {
            val intent = Intent(this, VideocardActivity::class.java)
            startActivity(intent)

        }

        val buttonRam: ImageButton = findViewById(R.id.open_ram_activity)
        buttonRam.setOnClickListener {
            val intent = Intent(this, RamActivity::class.java)
            startActivity(intent)

        }

        val buttonStorage: ImageButton = findViewById(R.id.open_storage_activity)
        buttonStorage.setOnClickListener {
            val intent = Intent(this, StorageActivity::class.java)
            startActivity(intent)

        }

        val buttonFan: ImageButton = findViewById(R.id.open_fan_activity)
        buttonFan.setOnClickListener {
            val intent = Intent(this, FanActivity::class.java)
            startActivity(intent)

        }

        val buttonPower: ImageButton = findViewById(R.id.open_power_activity)
        buttonPower.setOnClickListener {
            val intent = Intent(this, PowerActivity::class.java)
            startActivity(intent)

        }

        val buttonCase: ImageButton = findViewById(R.id.open_case_activity)
        buttonCase.setOnClickListener {
            val intent = Intent(this, CaseActivity::class.java)
            startActivity(intent)

        }



        // Ініціалізація елементів для процесора та материнської плати
        val processorNameTextView: TextView = findViewById(R.id.processorNameTextView)
        val processorImageView: ImageView = findViewById(R.id.processorImageView)
        val motherboardNameTextView: TextView = findViewById(R.id.motherboardNameTextView)
        val motherboardImageView: ImageView = findViewById(R.id.motherboardImageView)
        val videocardNameTextView: TextView = findViewById(R.id.videocardNameTextView)
        val videocardImageView: ImageView = findViewById(R.id.videocardImageView)
        val ramNameTextView: TextView = findViewById(R.id.ramNameTextView)
        val ramImageView: ImageView = findViewById(R.id.ramImageView)
        val storageNameTextView: TextView = findViewById(R.id.storageNameTextView)
        val storageImageView: ImageView = findViewById(R.id.storageImageView)
        val fanNameTextView: TextView = findViewById(R.id.fanNameTextView)
        val fanImageView: ImageView = findViewById(R.id.fanImageView)
        val powerNameTextView: TextView = findViewById(R.id.powerNameTextView)
        val powerImageView: ImageView = findViewById(R.id.powerImageView)
        val caseNameTextView: TextView = findViewById(R.id.caseNameTextView)
        val caseImageView: ImageView = findViewById(R.id.caseImageView)

        val clearAll: Button = findViewById(R.id.clearAll)
        clearAll.setOnClickListener{
            val sharedPref = getSharedPreferences("com.andrii.kursova.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()

            // Очищення всіх налаштувань
            editor.clear()
            editor.apply()

            // Встановлення значень за замовчуванням для кожного компонента
            processorNameTextView.text = "Процесор"
            processorImageView.setImageResource(R.drawable.processor)
            editor.putString("processorName", "Процесор")
            editor.putInt("processorImage", R.drawable.processor)

            motherboardNameTextView.text = "Материнська плата"
            motherboardImageView.setImageResource(R.drawable.motherboard)
            editor.putString("motherboardName", "Материнська плата")
            editor.putInt("motherboardImage", R.drawable.motherboard)

            videocardNameTextView.text = "Відеокарта"
            videocardImageView.setImageResource(R.drawable.videocard)
            editor.putString("videocardName", "Відеокарта")
            editor.putInt("videocardImage", R.drawable.videocard)

            ramNameTextView.text = "Оперативна пам'ять"
            ramImageView.setImageResource(R.drawable.ram)
            editor.putString("ramName", "Оперативна пам'ять")
            editor.putInt("ramImage", R.drawable.ram)

            storageNameTextView.text = "Накопичувач"
            storageImageView.setImageResource(R.drawable.storage)
            editor.putString("storageName", "Накопичувач")
            editor.putInt("storageImage", R.drawable.storage)

            fanNameTextView.text = "Система охолодження"
            fanImageView.setImageResource(R.drawable.fan)
            editor.putString("fanName", "Система охолодження")
            editor.putInt("fanImage", R.drawable.fan)

            powerNameTextView.text = "Блок живлення"
            powerImageView.setImageResource(R.drawable.power)
            editor.putString("powerName", "Блок живлення")
            editor.putInt("powerImage", R.drawable.power)

            caseNameTextView.text = "Корпус"
            caseImageView.setImageResource(R.drawable.case_pc)
            editor.putString("caseName", "Корпус")
            editor.putInt("caseImage", R.drawable.case_pc)
        }

        // Отримання даних з Intent
        val componentType = intent.getStringExtra("componentType")
        val selectedComponent = intent.getStringExtra("selectedComponent")
        val selectedComponentImageResource = intent.getIntExtra("selectedComponentImage", -1)

        // Збереження даних в SharedPreferences
        var sharedPref = getSharedPreferences("com.andrii.kursova.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE)
        var editor = sharedPref.edit()


        // Відображення отриманих даних для відповідного компоненту
        if (componentType != null && selectedComponent != null && selectedComponentImageResource != -1) {
            when (componentType) {
                "processor" -> {
                    processorNameTextView.text = selectedComponent
                    processorImageView.setImageResource(selectedComponentImageResource)
                    editor.putString("processorName", selectedComponent)
                    editor.putInt("processorImage", selectedComponentImageResource)
                }
                "motherboard" -> {
                    motherboardNameTextView.text = selectedComponent
                    motherboardImageView.setImageResource(selectedComponentImageResource)
                    editor.putString("motherboardName", selectedComponent)
                    editor.putInt("motherboardImage", selectedComponentImageResource)
                }
                "videocard" -> {
                    videocardNameTextView.text = selectedComponent
                    videocardImageView.setImageResource(selectedComponentImageResource)
                    editor.putString("videocardName", selectedComponent)
                    editor.putInt("videocardImage", selectedComponentImageResource)
                }
                "ram" -> {
                    ramNameTextView.text = selectedComponent
                    ramImageView.setImageResource(selectedComponentImageResource)
                    editor.putString("ramName", selectedComponent)
                    editor.putInt("ramImage", selectedComponentImageResource)
                }
                "storage" -> {
                    storageNameTextView.text = selectedComponent
                    storageImageView.setImageResource(selectedComponentImageResource)
                    editor.putString("storageName", selectedComponent)
                    editor.putInt("storageImage", selectedComponentImageResource)
                }
                "fan" -> {
                    fanNameTextView.text = selectedComponent
                    fanImageView.setImageResource(selectedComponentImageResource)
                    editor.putString("fanName", selectedComponent)
                    editor.putInt("fanImage", selectedComponentImageResource)
                }
                "power" -> {
                    powerNameTextView.text = selectedComponent
                    powerImageView.setImageResource(selectedComponentImageResource)
                    editor.putString("powerName", selectedComponent)
                    editor.putInt("powerImage", selectedComponentImageResource)
                }
                "case" -> {
                    caseNameTextView.text = selectedComponent
                    caseImageView.setImageResource(selectedComponentImageResource)
                    editor.putString("caseName", selectedComponent)
                    editor.putInt("caseImage", selectedComponentImageResource)
                }
            }
        } else {
            sharedPref = getSharedPreferences("com.andrii.kursova.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE)
            editor = sharedPref.edit()

            // Очищення всіх налаштувань
            editor.clear()
            editor.apply()

            // Встановлення значень за замовчуванням для кожного компонента
            processorNameTextView.text = "Процесор"
            processorImageView.setImageResource(R.drawable.processor)
            editor.putString("processorName", "Процесор")
            editor.putInt("processorImage", R.drawable.processor)

            motherboardNameTextView.text = "Материнська плата"
            motherboardImageView.setImageResource(R.drawable.motherboard)
            editor.putString("motherboardName", "Материнська плата")
            editor.putInt("motherboardImage", R.drawable.motherboard)

            videocardNameTextView.text = "Відеокарта"
            videocardImageView.setImageResource(R.drawable.videocard)
            editor.putString("videocardName", "Відеокарта")
            editor.putInt("videocardImage", R.drawable.videocard)

            ramNameTextView.text = "Оперативна пам'ять"
            ramImageView.setImageResource(R.drawable.ram)
            editor.putString("ramName", "Оперативна пам'ять")
            editor.putInt("ramImage", R.drawable.ram)

            storageNameTextView.text = "Накопичувач"
            storageImageView.setImageResource(R.drawable.storage)
            editor.putString("storageName", "Накопичувач")
            editor.putInt("storageImage", R.drawable.storage)

            fanNameTextView.text = "Система охолодження"
            fanImageView.setImageResource(R.drawable.fan)
            editor.putString("fanName", "Система охолодження")
            editor.putInt("fanImage", R.drawable.fan)

            powerNameTextView.text = "Блок живлення"
            powerImageView.setImageResource(R.drawable.power)
            editor.putString("powerName", "Блок живлення")
            editor.putInt("powerImage", R.drawable.power)

            caseNameTextView.text = "Корпус"
            caseImageView.setImageResource(R.drawable.case_pc)
            editor.putString("caseName", "Корпус")
            editor.putInt("caseImage", R.drawable.case_pc)

       }
        editor.apply()

        // Завантаження збережених даних
        val savedProcessorName = sharedPref.getString("processorName", null)
        val savedProcessorImage = sharedPref.getInt("processorImage", -1)
        if (savedProcessorName != null && savedProcessorImage != -1) {
            processorNameTextView.text = savedProcessorName
            processorNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.toFloat()) // Встановлення розміру тексту 20sp
            processorImageView.setImageResource(savedProcessorImage)

            // Встановлення розміру зображення
            val dpToPx = resources.displayMetrics.density
            val sizeInDp = 80
            val sizeInPx = (sizeInDp * dpToPx).toInt()

            val layoutParams = processorImageView.layoutParams
            layoutParams.width = sizeInPx
            layoutParams.height = sizeInPx
            processorImageView.layoutParams = layoutParams
        }

        val savedMotherboardName = sharedPref.getString("motherboardName", null)
        val savedMotherboardImage = sharedPref.getInt("motherboardImage", -1)
        if (savedMotherboardName != null && savedMotherboardImage != -1) {
            motherboardNameTextView.text = savedMotherboardName
            motherboardNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.toFloat()) // Встановлення розміру тексту 20sp
            motherboardImageView.setImageResource(savedMotherboardImage)

            // Встановлення розміру зображення
            val dpToPx = resources.displayMetrics.density
            val sizeInDp = 80 // Розмір у dp
            val sizeInPx = (sizeInDp * dpToPx).toInt()

            val layoutParams = motherboardImageView.layoutParams
            layoutParams.width = sizeInPx
            layoutParams.height = sizeInPx
            motherboardImageView.layoutParams = layoutParams
        }
        val savedVideocardName = sharedPref.getString("videocardName", null)
        val savedVideocardImage = sharedPref.getInt("videocardImage", -1)
        if (savedVideocardName != null && savedVideocardImage != -1) {
            videocardNameTextView.text = savedVideocardName
            videocardNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.toFloat()) // Встановлення розміру тексту 20sp
            videocardImageView.setImageResource(savedVideocardImage)

            // Встановлення розміру зображення
            val dpToPx = resources.displayMetrics.density
            val sizeInDp = 80 // Розмір у dp
            val sizeInPx = (sizeInDp * dpToPx).toInt()

            val layoutParams = videocardImageView.layoutParams
            layoutParams.width = sizeInPx
            layoutParams.height = sizeInPx
            videocardImageView.layoutParams = layoutParams
        }


        val savedRamName = sharedPref.getString("ramName", null)
        val savedRAMImage = sharedPref.getInt("ramImage", -1)
        if (savedRamName != null && savedRAMImage != -1) {
            ramNameTextView.text = savedRamName
            ramNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.toFloat()) // Встановлення розміру тексту 20sp
            ramImageView.setImageResource(savedRAMImage)

            val dpToPx = resources.displayMetrics.density
            val sizeInDp = 80 // Розмір у dp
            val sizeInPx = (sizeInDp * dpToPx).toInt()

            // Встановлення розміру зображення
            val layoutParamsRam = ramImageView.layoutParams
            layoutParamsRam.width = sizeInPx
            layoutParamsRam.height = sizeInPx
            ramImageView.layoutParams = layoutParamsRam
        }
        // Для storage
        val savedStorageName = sharedPref.getString("storageName", null)
        val savedStorageImage = sharedPref.getInt("storageImage", -1)
        if (savedStorageName != null && savedStorageImage != -1) {
            storageNameTextView.text = savedStorageName
            storageNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.toFloat()) // Встановлення розміру тексту 20sp
            storageImageView.setImageResource(savedStorageImage)

            // Встановлення розміру зображення
            val dpToPxStorage = resources.displayMetrics.density
            val sizeInDpStorage = 80 // Розмір у dp
            val sizeInPxStorage = (sizeInDpStorage * dpToPxStorage).toInt()

            val layoutParamsStorage = storageImageView.layoutParams
            layoutParamsStorage.width = sizeInPxStorage
            layoutParamsStorage.height = sizeInPxStorage
            storageImageView.layoutParams = layoutParamsStorage
        }

// Для fan
        val savedFanName = sharedPref.getString("fanName", null)
        val savedFanImage = sharedPref.getInt("fanImage", -1)
        if (savedFanName != null && savedFanImage != -1) {
            fanNameTextView.text = savedFanName
            fanNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.toFloat()) // Встановлення розміру тексту 20sp
            fanImageView.setImageResource(savedFanImage)

            // Встановлення розміру зображення
            val dpToPxFan = resources.displayMetrics.density
            val sizeInDpFan = 80 // Розмір у dp
            val sizeInPxFan = (sizeInDpFan * dpToPxFan).toInt()

            val layoutParamsFan = fanImageView.layoutParams
            layoutParamsFan.width = sizeInPxFan
            layoutParamsFan.height = sizeInPxFan
            fanImageView.layoutParams = layoutParamsFan
        }

// Для power
        val savedPowerName = sharedPref.getString("powerName", null)
        val savedPowerImage = sharedPref.getInt("powerImage", -1)
        if (savedPowerName != null && savedPowerImage != -1) {
            powerNameTextView.text = savedPowerName
            powerNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.toFloat()) // Встановлення розміру тексту 20sp
            powerImageView.setImageResource(savedPowerImage)

            // Встановлення розміру зображення
            val dpToPxPower = resources.displayMetrics.density
            val sizeInDpPower = 80 // Розмір у dp
            val sizeInPxPower = (sizeInDpPower * dpToPxPower).toInt()

            val layoutParamsPower = powerImageView.layoutParams
            layoutParamsPower.width = sizeInPxPower
            layoutParamsPower.height = sizeInPxPower
            powerImageView.layoutParams = layoutParamsPower
        }

// Для case
        val savedCaseName = sharedPref.getString("caseName", null)
        val savedCaseImage = sharedPref.getInt("caseImage", -1)
        if (savedCaseName != null && savedCaseImage != -1) {
            caseNameTextView.text = savedCaseName
            caseNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20.toFloat()) // Встановлення розміру тексту 20sp
            caseImageView.setImageResource(savedCaseImage)

            // Встановлення розміру зображення
            val dpToPxCase = resources.displayMetrics.density
            val sizeInDpCase = 80 // Розмір у dp
            val sizeInPxCase = (sizeInDpCase * dpToPxCase).toInt()

            val layoutParamsCase = caseImageView.layoutParams
            layoutParamsCase.width = sizeInPxCase
            layoutParamsCase.height = sizeInPxCase
            caseImageView.layoutParams = layoutParamsCase
        }


    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
    override fun onDestroy() {
        super.onDestroy()
        val sharedPref = getSharedPreferences("com.andrii.kursova.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        // Очищення всіх налаштувань
        editor.clear()
        editor.apply()
    }
}