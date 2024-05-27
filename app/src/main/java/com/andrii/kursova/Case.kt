package com.andrii.kursova

class Case(val name: String, val image: Int, val formfactor: String, val weight: String, val size: String)
{
    companion object {
        fun getCase(): List<Case> {
            return listOf(
                Case("GTL N3202C Mandalorian", R.drawable.gtl_n3202c, "ATX", "2.8 кг", "410x176x360 мм"),
                Case("Gamemax Infinity", R.drawable.gamemax_infinity, "ATX", "7.5 кг", "399x273x420 мм"),
                Case("be quiet! Pure Base 500DX", R.drawable.be_quiet_pure_base, "ATX", "7.8 кг", "463x232x450 мм"),
                Case("Vinga Tomcat", R.drawable.vinga_tomcat, "ATX", "5.7 кг", "482x215x410 мм")
            )
        }
    }
}