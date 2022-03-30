package machado.felipe.calculadoradoamorfelipe

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import machado.felipe.calculadoradoamorfelipe.model.CalcLove

class MainActivity : AppCompatActivity() {

    private lateinit var name1: EditText
    private lateinit var name2: EditText
    private lateinit var button: TextView
    private lateinit var percentage: TextView
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initalizing()

        button.setOnClickListener {

            val name: String?
            name = name2.text.toString()

            if (name.isEmpty()) {
                toast()
            } else {
                val calculo = CalcLove()
                percentage.text = "${calculo.calc()}%"
                toastReturnCalc()
                play(R.raw.love_music)
            }
        }
    }

    private fun toast() {
        Toast.makeText(
            baseContext,
            R.string.error_null_name,
            Toast.LENGTH_LONG
        ).show()
    }

    private fun toastReturnCalc() {
        Toast.makeText(
            baseContext,
            "${getString((R.string.chances_response_toast))} ${percentage.text}",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun initalizing(){
        name1 = findViewById(R.id.name_people_one)
        name2 = findViewById(R.id.name_people_two)
        button = findViewById(R.id.button)
        percentage = findViewById(R.id.percentage)
    }

    private fun play(sound: Int) {
        mediaPlayer = MediaPlayer.create(this@MainActivity, sound)
        mediaPlayer.start()
    }
}