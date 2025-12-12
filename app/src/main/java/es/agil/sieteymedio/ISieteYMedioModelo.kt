package es.agil.sieteymedio

interface ISieteYMedioModelo{
    fun createCards()
    fun shuffleCards()

    fun activateCard(player:Int)
    fun disactivateCard(player:Int)
    fun getCardIsActive(player:Int):Boolean

    fun nextCard()
    fun getNextCard():SieteYMedioModelo.Carta
    fun resetCurrentCardPos()

    fun setTurno(player:Int)
    fun getTurno():Int

    fun getPlayerLost(player:Int):Boolean
    fun setPlayerLost(player:Int, b:Boolean)
    fun getPlayerLastCard(player:Int):SieteYMedioModelo.Carta
    fun setPlayerLastCard(player: Int, carta:SieteYMedioModelo.Carta)

    fun addPuntaje(player:Int, value:Double)
    fun getPuntaje(player:Int):Double

    fun resetPuntajes()
}