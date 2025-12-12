package es.agil.sieteymedio

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import es.agil.sieteymedio.databinding.ActivityMainBinding

class SieteYMedioActivity : ISieteYMedioVista, AppCompatActivity(){
    private val activeHiddenCard:String ="hidden_active"
    private val unactiveHiddenCard:String ="hidden_unactive"
    private val controller:SieteYMedioController= SieteYMedioController(this)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        binding.cardsP1.setOnClickListener{
            controller.clickLeftImage()
        }
        binding.cardsP2.setOnClickListener{
            controller.clickRightImage()
        }

        controller.initialState()
    }

    override fun showHiddenActive(player: Int){
        val imgCarta = resources.getIdentifier(activeHiddenCard, "drawable", "es.agil.sieteymedio")
        if(player == 1){
            binding.cardsP1.setImageResource(imgCarta)
        }
        else{
            binding.cardsP2.setImageResource(imgCarta)
        }
    }

    override fun showHiddenInactive(player: Int) {
        val imgCarta = resources.getIdentifier(unactiveHiddenCard, "drawable", "es.agil.sieteymedio")
        if(player == 1){
            binding.cardsP1.setImageResource(imgCarta)
        }
        else{
            binding.cardsP2.setImageResource(imgCarta)
        }
    }

    override fun showCard(player: Int, carta: SieteYMedioModelo.Carta) {
        val imgCarta = resources.getIdentifier(carta.img, "drawable", "es.agil.sieteymedio")
        if(player == 1) {
            binding.cardsP1.setImageResource(imgCarta)
        }
        else{
            binding.cardsP2.setImageResource(imgCarta)
        }
    }

    override fun enablePlantarseButton(player: Int) {
        if(player == 1) {
            binding.btnPlantP1.isEnabled = true
        }
        else{
            binding.btnPlantP2.isEnabled = true
        }
    }

    override fun disablePlantarseButton(player: Int) {
        if(player == 1) {
            binding.btnPlantP1.isEnabled = false
        }
        else{
            binding.btnPlantP2.isEnabled = false
        }
    }

    override fun setCurrentSumValue(player: Int, value: Double) {
        if(player == 1) {
            binding.txtPuntajeP1.text = value.toString()
        }
        else{
            binding.txtPuntajeP2.text = value.toString()
        }
    }

    override fun showCurrentSumValue(player: Int) {
        if(player == 1){
            binding.txtPuntajeP1.visibility = View.VISIBLE
        }
        else{
            binding.txtPuntajeP2.visibility = View.VISIBLE
        }
    }

    override fun hideCurrentSumValue(player: Int) {
        if(player == 1){
            binding.txtPuntajeP1.visibility = View.INVISIBLE
        }
        else{
            binding.txtPuntajeP2.visibility = View.INVISIBLE
        }
    }

    override fun setWinnerText(text: String) {
        binding.txtWinner.text = text
    }

    override fun showWinnerText() {
        binding.txtWinner.visibility = View.VISIBLE
    }

    override fun hideWinnerText() {
        binding.txtWinner.visibility = View.INVISIBLE
    }

    override fun showWinnerGif() {
        TODO("Not yet implemented")
    }

    fun clickedPlantarseLeft(view: View){
        controller.clickedPlantarseLeft()
    }

    fun clickedPlantarseRight(view: View){
        controller.clickedPlantarseRight()
    }

    fun restartAll(view: View) {
        controller.initialState()
    }
}