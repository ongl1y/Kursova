package com.andrii.kursova

class Storage(val name: String, val image: Int, val capacity: String, val formfactor: String, val m2: String)
{
    companion object {
        fun getStorage(): List<Storage> {
            return listOf(
                Storage("Kingston KC3000 SKC3000S/1024G", R.drawable.kingston_skc_3000s, "1024 ГБ", "M.2", "PCI-E 4.0 4x"),
                Storage("SSD Samsung 970 EVO Plus M.2 MZ-V7S1T0BW", R.drawable.samsung_970_evo_plus, "1000 ГБ", "M.2", "PCI-E 3.0 4x"),
                Storage("SSD Kingston A400 SA400S37/480G", R.drawable.kingston_a400, "480 ГБ", "2.5", " - "),
                Storage("WD Black SN770 WDS100T3X0E", R.drawable.wd_black_sn_770, "1000 ГБ", "M.2", "PCI-E 4.0 4x")
            )
        }
    }
}
