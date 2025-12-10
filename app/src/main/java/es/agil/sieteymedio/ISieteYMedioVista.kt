package es.agil.sieteymedio

interface ISieteYMedioVista{
    fun enableCard(player:Int)
    fun disableCard(player:Int)
    fun hideCard(player:Int)
    fun showCard(player:Int)

    fun enablePlantarseButton(player:Int)
    fun disablePlantarseButton(player:Int)

    fun setCurrentSumValue(player:Int, value:Double)

    fun setWinnerText(text:String)
    fun showWinnerText()
    fun hideWinnerText()
    fun showWinnerGif()
}