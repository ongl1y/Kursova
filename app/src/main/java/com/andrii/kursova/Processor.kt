package com.andrii.kursova

class Processor(val name: String,
                val image: Int,
                val socket: String,
                val frequency: String,
                val tdp: String
) {
    companion object {
        fun getProcessors(): List<Processor> {
            return listOf(
                Processor("AMD Ryzen 5 Vermeer 5600", R.drawable.amd_ryzen_5_5600, "AMD AM5", "3.5 ГГц", "65 Вт"),
                Processor("AMD Ryzen 7 Phoenix 8700G", R.drawable.amd_ryzen_7_8700g, "AMD AM5","4.2 ГГц","65 Вт"),
                Processor("Intel Core i7-8700K", R.drawable.intel_core_i7_8700k, "Intel LGA 1151 v2","3.7 ГГц","95 Вт"),
                Processor("Intel Core i5-11600K", R.drawable.intel_core_i5_11600k, "Intel LGA 1200","3.9 ГГц","125 Вт"),
                Processor("Intel Core i5-11400F", R.drawable.core_i5_11400f, "Intel LGA 1200","3.9 ГГц","65 Вт"),
                Processor("AMD Ryzen 5 Cezanne 5600G", R.drawable.amd_ryzen_5_5600g, "AMD AM4", "3.9 ГГц","65 Вт")
            )
        }
    }
}