package es.agil.sieteymedio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SieteYMedioActivity : ISieteYMedioVista, AppCompatActivity(){
    val hiddenCardImgPath:String ="hidden.png"
    val rulesText:String = "Lorem ipsum"

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
    }

    override fun enableCard(player: Int) {
        TODO("Not yet implemented")
    }

    override fun disableCard(player: Int) {
        TODO("Not yet implemented")
    }

    override fun hideCard(player: Int) {
        TODO("Not yet implemented")
    }

    override fun showCard(player: Int) {
        TODO("Not yet implemented")
    }

    override fun enablePlantarseButton(player: Int) {
        TODO("Not yet implemented")
    }

    override fun disablePlantarseButton(player: Int) {
        TODO("Not yet implemented")
    }

    override fun setCurrentSumValue(player: Int, value: Double) {
        TODO("Not yet implemented")
    }

    override fun setWinnerText(text: String) {
        TODO("Not yet implemented")
    }

    override fun showWinnerText() {
        TODO("Not yet implemented")
    }

    override fun hideWinnerText() {
        TODO("Not yet implemented")
    }

    override fun showWinnerGif() {
        TODO("Not yet implemented")
    }
}