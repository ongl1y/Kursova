package com.andrii.kursova

class Videocard(val name: String,
                val image: Int,
                val memory: String,
                val memorytype: String,
                val power: String)
{
    companion object {
        fun getVideocards(): List<Videocard> {
            return listOf(
                Videocard("Gigabyte GeForce RTX 4060 EAGLE OC 8G", R.drawable.gigabyte_geforce_rtx_4060_eagle_oc_8g, "8 ГБ", "GDDR6", "8 pin"),
                Videocard("MSI GeForce RTX 4090 VENTUS 3X 24G OC", R.drawable.msi_geforce_rtx_4090_ventus_3x_24g_oc, "24 ГБ", "GDDR6X", "16 pin"),
                Videocard("Asus ROG-STRIX GeForce GTX 1080 Ti", R.drawable.asus_rog_strix_geforce_gtx_1080_ti, "11 ГБ", "GDDR5X", "8 + 8 pin"),
                Videocard("Gigabyte GeForce GTX 1660 SUPER OC 6G", R.drawable.gigabyte_geforce_gtx_1660_super_oc_6g, "6ГБ", "GDDR6", "8 pin")
            )
        }
    }
}