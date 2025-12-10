package es.agil.sieteymedio

class SieteYMedioModelo{
    enum class Set{
        COPAS,
        ESPADAS,
        OROS,
        BASTOS
    }

    data class Carta(
        val set: Set,
        val count: Int,
        val value: Double,
        val lectura: String,
        val img: String
    )
    //TODO: Se puede sobreescribir el toString de este data class?

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

    var turno:Int = 1
    var currentDeckPosition:Int = 0
    var puntajeJ1:Double = 0.0
    var puntajeJ2:Double = 0.0
    lateinit var deck:List<Carta>
}