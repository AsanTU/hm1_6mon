package mbk.io.sabrina_hm1_6m

import android.app.Application
import mbk.io.sabrina_hm1_6m.di.networkModule
import mbk.io.sabrina_hm1_6m.di.repositoryModule
import mbk.io.sabrina_hm1_6m.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App :Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@App)
            modules(viewModelModule, repositoryModule, networkModule)
        }
    }
}