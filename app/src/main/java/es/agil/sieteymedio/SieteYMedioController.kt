package es.agil.sieteymedio

class SieteYMedioController(vista: SieteYMedioActivity) {
    private val modelo:SieteYMedioModelo = SieteYMedioModelo()
    private val vista:SieteYMedioActivity = vista

    fun initialState(){
        modelo.shuffleCards()
        modelo.activateCard(1)
        modelo.disactivateCard(2)
        modelo.resetCurrentCardPos()
        modelo.resetPuntajes()
        modelo.setTurno(1)
        modelo.setPlayerLost(1, false)
        modelo.setPlayerLost(2, false)

        vista.showHiddenActive(1)
        vista.showHiddenInactive(2)
        vista.enablePlantarseButton(1)
        vista.disablePlantarseButton(2)
        vista.setCurrentSumValue(1, 0.0)
        vista.setCurrentSumValue(2, 0.0)
        vista.showCurrentSumValue(1)
        vista.hideCurrentSumValue(2)
        vista.hideWinnerText()
    }

    fun clickLeftImage() {
        if(modelo.getCardIsActive(1) && modelo.getTurno() == 1){
            val card = modelo.getNextCard()
            modelo.addPuntaje(1, card.value)
            vista.showCard(1, card)

            if(modelo.getPuntaje(1)>7.5) {
                modelo.setPlayerLost(1, true)
                modelo.disactivateCard(1)
            }
            vista.setCurrentSumValue(1, modelo.getPuntaje(1))
            vista.showCurrentSumValue(1)

            modelo.nextCard()
        }
    }

    fun clickRightImage() {
        if(modelo.getCardIsActive(2) && modelo.getTurno() == 2){
            val card = modelo.getNextCard()
            modelo.setPlayerLastCard(1, card)
            modelo.addPuntaje(2, card.value)
            vista.showCard(2, card)

            if(modelo.getPuntaje(2)>7.5) {
                modelo.setPlayerLost(2, true)
                modelo.disactivateCard(2)
            }
            vista.setCurrentSumValue(2, modelo.getPuntaje(2))
            vista.showCurrentSumValue(2)

            modelo.nextCard()
        }
    }

    fun clickedPlantarseLeft(){
        if(modelo.getTurno() == 1){
            modelo.disactivateCard(1)
            modelo.setTurno(2)
            modelo.activateCard(2)
            vista.disablePlantarseButton(1)
            vista.enablePlantarseButton(2)
            vista.showHiddenInactive(1)
            vista.showHiddenActive(2)
            vista.hideCurrentSumValue(1)
        }
    }

    fun clickedPlantarseRight(){
        modelo.disactivateCard(1)
        modelo.disactivateCard(2)
        vista.disablePlantarseButton(1)
        vista.disablePlantarseButton(2)
        vista.showHiddenInactive(1)
        vista.showHiddenInactive(2)
        vista.showCurrentSumValue(1)
        val winner = determinarWinner()
        if(winner == null){
            vista.setWinnerText("EMPATE")
        }
        else if(winner == 1){
            vista.setWinnerText("GANADOR: JUGADOR 1")
        }
        else{
            vista.setWinnerText("GANADOR: JUGADOR 2")
        }
        vista.showWinnerText()
    }

    private fun determinarWinner():Int?{
        val p1Lost = modelo.getPlayerLost(1)
        val p2Lost = modelo.getPlayerLost(2)
        if (p1Lost){
            if(p2Lost){
                return null
            }
            else
                return 2
        }
        else {
            if (p2Lost){
                return 1
            }
            else{
                val p1Score = modelo.getPuntaje(1)
                val p2Score = modelo.getPuntaje(2)
                if(p1Score > p2Score)
                    return 1
                else if (p2Score >p1Score)
                    return 2
                else
                    return null
            }
        }
    }
}