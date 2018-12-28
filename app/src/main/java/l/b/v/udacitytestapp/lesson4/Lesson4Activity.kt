package l.b.v.udacitytestapp.lesson4

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import l.b.v.udacitytestapp.R
import l.b.v.udacitytestapp.databinding.Activity4LayoutBinding

class Lesson4Activity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<Activity4LayoutBinding>(this, R.layout.activity_4_layout)

        Log.i(Lesson4Activity::class.java.simpleName, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(Lesson4Activity::class.java.simpleName, "onStart")
    }
}