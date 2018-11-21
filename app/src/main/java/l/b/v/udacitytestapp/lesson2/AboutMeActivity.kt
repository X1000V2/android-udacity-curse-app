package l.b.v.udacitytestapp.lesson2

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.about_me_layout.*
import l.b.v.udacitytestapp.R

class AboutMeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.about_me_layout)

        buttonDone.setOnClickListener { addNickName(it) }
    }

    fun addNickName(view: View){

        editText.visibility = GONE
        view.visibility = GONE

        textView2.text = editText.text
        textView2.visibility = VISIBLE

        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken, 0)

    }

}