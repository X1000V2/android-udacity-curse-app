package l.b.v.udacitytestapp.lesson4

import timber.log.Timber
import android.os.Handler

class DessertTimer {

    private var handler = Handler()
    private lateinit var runnable: Runnable
    private var secondsCount = 0

    fun startTimer(){

        runnable = Runnable {

            secondsCount++

            Timber.i("Timer is: $secondsCount")
            handler.postDelayed(runnable,1000)

        }

        handler.postDelayed(runnable,1000)

    }

    fun stopTimer(){

        handler.removeCallbacks(runnable)
    }


}