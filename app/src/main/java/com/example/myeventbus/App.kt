package com.example.myeventbus

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment

class App: Application() {
    val eventBus = EventBus()
}

val Fragment.app: App
    get() = requireContext().applicationContext as App

val Activity.app: App
    get() = applicationContext as App
