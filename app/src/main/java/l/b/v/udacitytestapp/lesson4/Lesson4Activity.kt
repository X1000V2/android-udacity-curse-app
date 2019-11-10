package l.b.v.udacitytestapp.lesson4

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import l.b.v.udacitytestapp.R
import l.b.v.udacitytestapp.databinding.Activity4LayoutBinding
import timber.log.Timber

class Lesson4Activity: AppCompatActivity() {

    companion object {
        const val CONSTANT_PRICE_PER_UNIT = 5
        const val SAVE_AMOUNT_SOLD = "saveAmount"
        const val SAVE_REVENUE = "saveReve"
    }

    private lateinit var binding: Activity4LayoutBinding
    private var dessertTimer = DessertTimer(this.lifecycle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<Activity4LayoutBinding>(this, R.layout.activity_4_layout)

        binding.dessertButton.setImageResource(R.drawable.cupcake)

        if(savedInstanceState == null){
            binding.revenue = 0
            binding.amountSold = binding.revenue?.let { it * CONSTANT_PRICE_PER_UNIT}?: 0
        }


        binding.dessertButton.setOnClickListener {
            dessetButtonAction()
        }


        Timber.i("onCreate")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {

        outState.putInt(SAVE_AMOUNT_SOLD, binding.amountSold!!)
        outState.putInt(SAVE_REVENUE, binding.revenue!!)

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        binding.amountSold = savedInstanceState.getInt(SAVE_AMOUNT_SOLD)
        binding.revenue = savedInstanceState.getInt(SAVE_REVENUE)
    }

    private fun dessetButtonAction(){
        //add
        binding.amountSold = binding.amountSold!! + 1

        //set new values
        binding.revenue = binding.amountSold?.let { it * CONSTANT_PRICE_PER_UNIT}
    }
}