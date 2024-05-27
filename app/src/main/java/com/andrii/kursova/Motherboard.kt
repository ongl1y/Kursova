package com.andrii.kursova

data class Motherboard(
    val name: String,
    val image: Int,
    val socket: String,
    val ddr: String,
    val motherpower: String
) {
    companion object {
        fun getMotherboards(): List<Motherboard> {
            return listOf(
                Motherboard("MSI MAG B650 TOMAHAWK WIFI", R.drawable.msi_mag_b650_tomahawk, "AMD AM5", "DDR5", "24-pin/8+8-pin"),
                Motherboard("Gigabyte B550 AORUS ELITE V2", R.drawable.gigabyte_b550_aorus_elite_v2, "AMD AM4", "DDR4", "24-pin/8-pin"),
                Motherboard("Asus ROG STRIX B560-E GAMING WIFI", R.drawable.asus_rog_strix_b560_e_gaming_wifi, "Intel LGA 1200", "DDR4", "24-pin/8+4-pin"),
                Motherboard("MSI MPG B550 GAMING PLUS", R.drawable.msi_mpg_550_gaming_plus, "AMD AM4", "DDR4", "24-pin/8-pin"),
                Motherboard("Gigabyte Z390 D", R.drawable.gigabyte_z390_d, "Intel LGA 1151 v2", "DDR4", "24-pin/8-pin")
            )
        }
    }
}
