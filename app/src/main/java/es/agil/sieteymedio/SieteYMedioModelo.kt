package es.agil.sieteymedio

class SieteYMedioModelo:ISieteYMedioModelo{
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
        val img: String
    )
    //TODO: Se puede sobreescribir el toString de este data class?

    var turno:Int = 1
    var currentDeckPosition:Int = 0
    var puntajeJ1:Double = 0.0
    var puntajeJ2:Double = 0.0
    var leftCardActive:Boolean = false
    var RightCardActive:Boolean = false
    lateinit var deck:MutableList<Carta>

    override fun createCards() {
        deck.clear()
        for(set in Set.values()){
            val name = when (set){
                Set.COPAS -> "copas"
                Set.OROS -> 
            }
            var cardName =
            for(i in 1..10){
                var value = 1.0
                if (i in 8..10)
                    value = 0.5
                deck.add(Carta(set, i, value, name+i))
            }
        }
    }

    override fun shuffleCards() {
        deck = deck.shuffled()
    }

    override fun activateCard(player: Int) {
        TODO("Not yet implemented")
    }

    override fun disactivateCard(player: Int) {
        TODO("Not yet implemented")
    }

    override fun nextCard() {
        TODO("Not yet implemented")
    }

    override fun getNextCard(): Carta {
        TODO("Not yet implemented")
    }

    override fun resetCurrentCardPos() {
        TODO("Not yet implemented")
    }

    override fun setTurno(player: Int) {
        TODO("Not yet implemented")
    }

    override fun getTurno(): Int {
        TODO("Not yet implemented")
    }

    override fun addPuntaje(player: Int, value: Double) {
        TODO("Not yet implemented")
    }

    override fun getPuntaje(player: Int): Double {
        TODO("Not yet implemented")
    }

    override fun resetPuntajes() {
        TODO("Not yet implemented")
    }
}