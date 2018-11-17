package l.b.v.udacitytestapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        roll_button.text = "Let's Roll!"
        roll_button.setOnClickListener {
            buttonClicked()
        }
    }

    private fun buttonClicked() {
        val randomInt = Random().nextInt(6) + 1
        result_text.text = "$randomInt"

        val imageDrawable = when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        dice_image.setImageResource(imageDrawable)
    }
}
