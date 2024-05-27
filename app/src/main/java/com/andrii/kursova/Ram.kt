package com.andrii.kursova

class Ram(val name: String,
          val image: Int,
          val capacity: String,
          val ddr: String,
          val ramfrequency: String )
{
    companion object {
        fun getRAM(): List<Ram> {
            return listOf(
                Ram("Kingston Fury Beast DDR4 2x8Gb", R.drawable.kingston_fury_beast_2_8, "16 ГБ", "DDR4", "3200 МГц"),
                Ram("GOODRAM IRDM DDR5 2x16Gb", R.drawable.goodram_irdm_ddr5_2x16gb, "32 ГБ", "DDR5", "6000 МГц"),
                Ram("Kingston Fury Renegade DDR4 Black 2x16Gb", R.drawable.kingston_fury_renegade_ddr4_black_2x16gb, "32 ГБ", "DDR4", "3600 МГц"),
                Ram("G.Skill Ripjaws S5 DDR5 2x16Gb", R.drawable.g_skill_ripjaws_s5_ddr5_2x16gb, "32 ГБ", "DDR5", "6800 МГц")
            )
        }
    }
}
