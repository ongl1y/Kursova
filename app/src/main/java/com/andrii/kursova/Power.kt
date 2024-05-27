package com.andrii.kursova

class Power(val name: String, val image: Int, val power: String, val certificate: String, val motherpower: String)
{
    companion object {
        fun getPower(): List<Power> {
            return listOf(
                Power("MSI MAG", R.drawable.msi_mag, "650 Вт", "80+ Bronze", "24+8 (4+4) pin"),
                Power("be quiet! Pure Power 12 M", R.drawable.be_quiet_bn344, "850 Вт", "80+ Gold", "24+8+8(4+4) pin"),
                Power("FSP PNR", R.drawable.fsp_pnr, "400 Вт", "без 80+", "24+4 pin"),
                Power("be quiet! Straight Power 12", R.drawable.be_quiet_straight_power, "750 Вт", "80+ Platinum", "24+8+8(4+4) pin")
            )
        }
    }
}