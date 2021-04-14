package com.demo.cartrack.di.module

import android.content.Context
import com.demo.cartrack.storage.CarTrackStoarge
import com.demo.cartrack.usecase.LoginUseCase
import com.demo.cartrack.viewmodel.LoginViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appViewModelModule = module {
    single { provideStorage(androidContext()) }
    factory { LoginUseCase(get()) }
    viewModel { LoginViewModel(get()) }
}

fun provideStorage(context: Context): CarTrackStoarge {
    return CarTrackStoarge(context)
}
