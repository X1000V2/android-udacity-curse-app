package l.b.v.udacitytestapp.lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import l.b.v.udacitytestapp.R
import java.util.*

class Lesson1Activity : AppCompatActivity() {

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
