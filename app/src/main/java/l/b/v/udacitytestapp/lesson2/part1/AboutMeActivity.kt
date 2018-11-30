package l.b.v.udacitytestapp.lesson2.part1

import android.content.Context
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import l.b.v.udacitytestapp.R
import l.b.v.udacitytestapp.databinding.AboutMeLayoutBinding
import l.b.v.udacitytestapp.lesson2.part1.databinding.MyName

class AboutMeActivity: AppCompatActivity() {

    private lateinit var binding: AboutMeLayoutBinding
    private var myNameVar = MyName("Luis Barroso", "luisNickname")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Delete to use databinding
        setContentView(R.layout.about_me_layout)

        binding = DataBindingUtil.setContentView(this,R.layout.about_me_layout)
        binding.myName = myNameVar
        binding.buttonDone.setOnClickListener { addNickName(it) }
    }

    fun addNickName(view: View){

        view.visibility = GONE
        binding.apply {
            editText.visibility = GONE
            myName?.nickName = editText.text.toString()
            invalidateAll()
            binding.textView2.visibility = VISIBLE
        }

        val inm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inm.hideSoftInputFromWindow(view.windowToken, 0)

    }

}