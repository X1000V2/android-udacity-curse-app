package l.b.v.udacitytestapp.lesson4

import android.app.Application
import timber.log.Timber

class CustomApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        //Init Timbre
        Timber.plant(Timber.DebugTree())

    }
}