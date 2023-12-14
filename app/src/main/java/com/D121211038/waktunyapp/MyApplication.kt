package com.D121211038.waktunyapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.D121211038.waktunyapp.data.AppContainer
import com.D121211038.waktunyapp.data.DefaultAppContainer
import com.D121211038.waktunyapp.ui.layout.bottomnavigation.BottomNavigation
import com.D121211038.waktunyapp.ui.theme.WaktuNYAppTheme

class MyApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}