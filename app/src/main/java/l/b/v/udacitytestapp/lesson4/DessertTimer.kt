package l.b.v.udacitytestapp.lesson4

import timber.log.Timber
import android.os.Handler
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class DessertTimer(lifecycle: Lifecycle): LifecycleObserver {

    private var handler = Handler()
    private lateinit var runnable: Runnable
    private var secondsCount = 0

    init {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun startTimer(){

        runnable = Runnable {

            secondsCount++

            Timber.i("Timer is: $secondsCount")
            handler.postDelayed(runnable,1000)

        }

        handler.postDelayed(runnable,1000)

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopTimer(){

        handler.removeCallbacks(runnable)
    }


}