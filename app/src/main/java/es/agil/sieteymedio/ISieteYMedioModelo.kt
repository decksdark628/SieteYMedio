package es.agil.sieteymedio

interface ISieteYMedioModelo{
    fun createCards()
    fun shuffleCards()

    fun activateCard(player:Int)
    fun disactivateCard(player:Int)

    fun nextCard()
    fun getNextCard():SieteYMedioModelo.Carta
    fun resetCurrentCardPos()

    fun setTurno(player:Int)
    fun getTurno():Int

    fun addPuntaje(player:Int, value:Double)
    fun getPuntaje(player:Int):Double

    fun resetPuntajes()
}