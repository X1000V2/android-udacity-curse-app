package l.b.v.udacitytestapp.lesson4

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import l.b.v.udacitytestapp.R
import l.b.v.udacitytestapp.databinding.Activity4LayoutBinding
import timber.log.Timber

class Lesson4Activity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<Activity4LayoutBinding>(this, R.layout.activity_4_layout)

        Timber.i("onCreate")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart")
    }
}