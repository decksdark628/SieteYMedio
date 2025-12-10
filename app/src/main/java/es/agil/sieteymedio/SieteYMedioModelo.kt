package es.agil.sieteymedio

class SieteYMedioModelo{
    enum class Set{
        COPAS,
        ESPADAS,
        OROS,
        BASTOS
    }

    val stringValues = mapOf(
        1 to "Uno",
        2 to "Dos",
        3 to "Tres",
        4 to "Cuatro",
        5 to "Cinco",
        6 to "Seis",
        7 to "Siete",
        8 to "Sota",
        9 to "Caballo",
        10 to "Rey"
    )

    data class Carta(
        val set: Set,
        val count: Int,
        val value: Double,
        val lectura: String,
        val img: String
    )
}