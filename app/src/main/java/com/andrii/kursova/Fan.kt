package com.andrii.kursova

class Fan(val name: String, val image: Int, val socketamd: String, val socketintel: String, val tdp: String)
{
    companion object {
        fun getFan(): List<Fan> {
            return listOf(
                Fan("Deepcool GAMMAXX 300", R.drawable.deepcool_gammaxx_300, "AM4, AM5", "1150, 1155/1156, 1151/1151 v2, 1200, 1700", "130 Вт"),
                Fan("ID-COOLING SE-206-XT", R.drawable.id_cooling_se_206_xt, "AM4, AM5", "1150, 1155/1156, 1151/1151 v2, 1200, 1700", "250 Вт"),
                Fan("Deepcool AK620 Zero Dark", R.drawable.deepcool_ak620, "AM4, AM5", "1150, 1155/1156, 2011/2011 v3, 2066, 1151/1151 v2, 1200, 1700", "260 Вт"),
                Fan("ARCTIC Liquid Freezer III 240", R.drawable.arctic_liquid, "AM4, AM5", "1700", "300 Вт")
            )
        }
    }
}