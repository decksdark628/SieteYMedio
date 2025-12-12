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

    private var turno:Int = 1
    private var currentDeckPosition:Int = 0
    private var puntajeJ1:Double = 0.0
    private var puntajeJ2:Double = 0.0
    private var P1Lost = false
    private var P2Lost = false
    private var leftCardActive:Boolean = false
    var rightCardActive:Boolean = false
    private lateinit var deck:MutableList<Carta>
    private lateinit var P1LastCard:Carta
    private lateinit var P2LastCard:Carta

    override fun createCards() {
        deck.clear()
        for(set in Set.values()){
            val palo = when (set){
                Set.COPAS -> "copas"
                Set.OROS -> "oros"
                Set.ESPADAS -> "espadas"
                Set.BASTOS -> "bastos"
            }
            for(i in 1..10){
                var value = 1.0
                if (i in 8..10)
                    value = 0.5
                val cardName:String = palo+i
                deck.add(Carta(set, i, value, cardName))
            }
        }
    }

    override fun shuffleCards() {
        deck = deck.shuffled().toMutableList()
    }

    override fun activateCard(player: Int) {
        if(player == 1){
            leftCardActive = true
        }
        else{
            rightCardActive = true
        }
    }

    override fun disactivateCard(player: Int) {
        if(player == 1){
            leftCardActive = false
        }
        else{
            rightCardActive = false
        }
    }

    override fun getCardIsActive(player: Int):Boolean {
        if(player == 1){
            return leftCardActive
        }
        else{
            return rightCardActive
        }
    }

    override fun nextCard() {
        currentDeckPosition += 1
    }

    override fun getNextCard(): Carta {
        return deck[currentDeckPosition]
    }

    override fun resetCurrentCardPos() {
        currentDeckPosition = 0
    }

    override fun setTurno(player: Int) {
        if(player == 1)
            turno = 1
        else
            turno = 2
    }

    override fun getTurno(): Int {
        return turno
    }

    override fun getPlayerLost(player: Int): Boolean {
        if(player == 1){
            return P1Lost
        }
        else{
            return P2Lost
        }
    }

    override fun setPlayerLost(player: Int, b: Boolean) {
        if(player == 1){
            P1Lost = b
        }
        else{
            P2Lost = b
        }
    }

    override fun getPlayerLastCard(player: Int): Carta {
        if(player == 1){
            return P1LastCard
        }
        else{
            return P2LastCard
        }
    }

    override fun setPlayerLastCard(player: Int, carta: Carta) {
        if(player == 1){
            P1LastCard = carta
        }
        else{
            P2LastCard = carta
        }
    }

    override fun addPuntaje(player: Int, value: Double) {
        if(player == 1){
            puntajeJ1 += value
        }
        else{
            puntajeJ2 += value
        }
    }

    override fun getPuntaje(player: Int): Double {
        if(player == 1){
            return puntajeJ1
        }
        else{
            return puntajeJ2
        }
    }

    override fun resetPuntajes() {
        puntajeJ1 = 0.0
        puntajeJ2 = 0.0
    }
}