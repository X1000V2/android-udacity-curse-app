package l.b.v.udacitytestapp.lesson3Navigation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import l.b.v.udacitytestapp.R
import l.b.v.udacitytestapp.databinding.ActivityAndroidTriviaBinding

class AndroidTriviaActivity : AppCompatActivity() {

    private var drawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_android_trivia)

        var binding =
            DataBindingUtil.setContentView<ActivityAndroidTriviaBinding>(this, R.layout.activity_android_trivia)
        drawerLayout = binding.drawer
        //setup nav controller
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)

        //control the side menu to be open only in menu screen
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if(destination.id == controller.graph.startDestination){
                drawerLayout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            }else{
                drawerLayout?.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}
