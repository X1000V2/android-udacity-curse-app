package l.b.v.udacitytestapp.lesson2.part2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_color_my_views.*
import l.b.v.udacitytestapp.R

class ColorMyViewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_my_views)

        val listBoxes = listOf<View>(textView1, textView2,textView3,textView4,textView5,constaintLayoutBackground,
                button_red,button_yellow,button_green)

        listBoxes.forEach {
            it.setOnClickListener {
                when(it.id){
                    R.id.textView1 -> it.setBackgroundColor(getColor(android.R.color.holo_blue_bright))
                    R.id.textView2 -> it.setBackgroundColor(getColor(android.R.color.holo_red_dark))
                    R.id.textView3 -> it.setBackgroundColor(getColor(android.R.color.holo_orange_dark))
                    R.id.textView4 -> it.setBackgroundColor(getColor(android.R.color.holo_green_dark))
                    R.id.textView5 -> it.setBackgroundColor(getColor(android.R.color.holo_purple))

                    R.id.button_red -> textView3.setBackgroundResource(R.color.color_red)
                    R.id.button_yellow -> textView4.setBackgroundResource(R.color.color_yellow)
                    R.id.button_green -> textView5.setBackgroundResource(R.color.color_green)

                    else -> it.setBackgroundColor(getColor(R.color.color_grey))
                }
            }
        }
    }
}
