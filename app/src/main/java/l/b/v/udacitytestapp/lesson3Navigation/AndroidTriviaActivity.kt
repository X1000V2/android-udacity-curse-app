package l.b.v.udacitytestapp.lesson3Navigation

import android.app.Fragment
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import l.b.v.udacitytestapp.R
import l.b.v.udacitytestapp.databinding.ActivityAndroidTriviaBinding

class AndroidTriviaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_android_trivia)

        var binding = DataBindingUtil.setContentView<ActivityAndroidTriviaBinding>(this, R.layout.activity_android_trivia)

        //setup nav controller
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this,navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}
