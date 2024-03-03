package mbk.io.sabrina_hm1_6m

import android.app.Application
import mbk.io.sabrina_hm1_6m.di.cartoonModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App :Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@App)
            modules(cartoonModule)
        }
    }
}