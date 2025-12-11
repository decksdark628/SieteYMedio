package es.agil.sieteymedio

interface ISieteYMedioVista{
    fun showHiddenActive(player:Int)
    fun showHiddenInactive(player:Int)
    fun showCard(player:Int, carta: SieteYMedioModelo.Carta)

    fun enablePlantarseButton(player:Int)
    fun disablePlantarseButton(player:Int)

    fun setCurrentSumValue(player:Int, value:Double)

    fun setWinnerText(text:String)
    fun showWinnerText()
    fun hideWinnerText()
    fun showWinnerGif()
}