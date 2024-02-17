package mbk.io.sabrina_hm1_6m.di


import mbk.io.sabrina_hm1_6m.BuildConfig
import mbk.io.sabrina_hm1_6m.data.api.CartoonApiService
import mbk.io.sabrina_hm1_6m.data.repository.Repository
import mbk.io.sabrina_hm1_6m.ui.first_activity.MainViewModel
import mbk.io.sabrina_hm1_6m.ui.second_activity.SecondViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/*val cartoonModule = module {
    принимает в себе список из 3х модулей
}*/

val networkModule = module {
    single {
        provideRetrofit(get())
    }

    single {
        provideOkHttpClient(get())
    }

    single {
        provideInterceptor()
    }

    single {
        provideCartoonApiService(get())
    }
}

val repositoryModule = module {
    single {
        Repository(get())
    }
}

val viewModelModule = module {

    viewModel {
        MainViewModel(get())
    }

    viewModel {
        SecondViewModel(get())
    }
}

val cartoonModule = listOf(networkModule, repositoryModule, viewModelModule)

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder().apply {
        writeTimeout(10, TimeUnit.SECONDS)
        readTimeout(10, TimeUnit.SECONDS)
        connectTimeout(10, TimeUnit.SECONDS)
        callTimeout(10, TimeUnit.SECONDS)
        addInterceptor(interceptor)
    }.build()


fun provideInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

fun provideCartoonApiService(retrofit: Retrofit): CartoonApiService =
    retrofit.create(CartoonApiService::class.java)