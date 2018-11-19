package l.b.v.udacitytestapp.mainMenu

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.menu_layout.*
import l.b.v.udacitytestapp.lesson1.Lesson1Activity
import l.b.v.udacitytestapp.R

class MenuActivity: AppCompatActivity(), MenuContract.View{

    companion object {
        const val LESSON_1 = 1
    }

    private var mPresenter: MenuPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.menu_layout)

        buttonLesson1.setOnClickListener {
            goToLesson(LESSON_1)
        }
    }

    override fun onStart() {
        super.onStart()

        mPresenter = MenuPresenter()
        mPresenter?.setView(this)
    }

    private fun goToLesson(numberLesson: Int){

        val intent = when(numberLesson){
            LESSON_1 -> Intent(this, Lesson1Activity::class.java)
            else -> Intent(this, Lesson1Activity::class.java)
        }
        startActivity(intent)

    }


}