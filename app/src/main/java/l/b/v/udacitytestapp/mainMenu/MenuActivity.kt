package l.b.v.udacitytestapp.mainMenu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.menu_layout.*
import l.b.v.udacitytestapp.R
import l.b.v.udacitytestapp.lesson1.Lesson1Activity
import l.b.v.udacitytestapp.lesson2.part1.AboutMeActivity
import l.b.v.udacitytestapp.lesson2.part2.ColorMyViewsActivity
import l.b.v.udacitytestapp.lesson3Navigation.AndroidTriviaActivity
import l.b.v.udacitytestapp.lesson4.Lesson4Activity

class MenuActivity : AppCompatActivity(), MenuContract.View {

    companion object {
        const val LESSON_1 = 1
        const val LESSON_2_1 = 2
        const val LESSON_2_2 = 3
        const val LESSON_3 = 4
        const val LESSON_4 = 5
    }

    private var mPresenter: MenuPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.menu_layout)

        buttonLesson1.setOnClickListener { goToLesson(LESSON_1) }
        buttonLesson2part1.setOnClickListener { goToLesson(LESSON_2_1) }
        buttonLesson2part2.setOnClickListener { goToLesson(LESSON_2_2) }
        buttonLesson3Navigation.setOnClickListener { goToLesson(LESSON_3) }
        buttonLesson4LifeCycle.setOnClickListener { goToLesson(LESSON_4) }
    }

    override fun onStart() {
        super.onStart()

        mPresenter = MenuPresenter()
        mPresenter?.setView(this)
    }

    private fun goToLesson(numberLesson: Int) {

        val intent = when (numberLesson) {
            LESSON_1 -> Intent(this, Lesson1Activity::class.java)
            LESSON_2_1 -> Intent(this, AboutMeActivity::class.java)
            LESSON_2_2 -> Intent(this, ColorMyViewsActivity::class.java)
            LESSON_3 -> Intent(this, AndroidTriviaActivity::class.java)
            LESSON_4 -> Intent(this, Lesson4Activity::class.java)
            else -> Intent(this, Lesson1Activity::class.java)
        }
        startActivity(intent)

    }


}