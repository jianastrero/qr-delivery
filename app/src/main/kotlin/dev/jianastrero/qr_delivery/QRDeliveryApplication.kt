package dev.jianastrero.qr_delivery

import android.app.Application
import android.content.pm.ApplicationInfo
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class QRDeliveryApplication : Application() {

    private val isDebuggable: Boolean
        get() = (applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0

    override fun onCreate() {
        super.onCreate()

        if (isDebuggable) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
