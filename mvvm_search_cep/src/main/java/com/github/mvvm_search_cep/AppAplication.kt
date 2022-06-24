package com.github.mvvm_search_cep

import android.app.Application
import com.github.mvvm_search_cep.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppAplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppAplication)
            modules(viewModelModule)
        }

    }

}