package l.b.v.udacitytestapp.mainMenu

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.menu_layout.*
import l.b.v.udacitytestapp.R
import l.b.v.udacitytestapp.lesson1.Lesson1Activity
import l.b.v.udacitytestapp.lesson2.part1.AboutMeActivity
import l.b.v.udacitytestapp.lesson2.part2.ColorMyViewsActivity

class MenuActivity : AppCompatActivity(), MenuContract.View {

    companion object {
        const val LESSON_1 = 1
        const val LESSON_2 = 2
        const val LESSON_3 = 3
    }

    private var mPresenter: MenuPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.menu_layout)

        buttonLesson1.setOnClickListener { goToLesson(LESSON_1) }
        buttonLesson2part1.setOnClickListener { goToLesson(LESSON_2) }
        buttonLesson2part2.setOnClickListener { goToLesson(LESSON_3) }
    }

    override fun onStart() {
        super.onStart()

        mPresenter = MenuPresenter()
        mPresenter?.setView(this)
    }

    private fun goToLesson(numberLesson: Int) {

        val intent = when (numberLesson) {
            LESSON_1 -> Intent(this, Lesson1Activity::class.java)
            LESSON_2 -> Intent(this, AboutMeActivity::class.java)
            LESSON_3 -> Intent(this, ColorMyViewsActivity::class.java)
            else -> Intent(this, Lesson1Activity::class.java)
        }
        startActivity(intent)

    }


}