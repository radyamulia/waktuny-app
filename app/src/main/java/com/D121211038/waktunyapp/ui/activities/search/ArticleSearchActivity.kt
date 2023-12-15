package com.D121211038.waktunyapp.ui.activities.search

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.D121211038.waktunyapp.ui.activities.main.MainViewModel
import com.D121211038.waktunyapp.ui.layout.bottomnavigation.BottomNavigation
import com.D121211038.waktunyapp.ui.theme.WaktuNYAppTheme

class ArticleSearchActivity: ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaktuNYAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigation()
                        }
                    ) {
                        Column(modifier = Modifier.padding(it)) {
                            Text("Ini search")
                        }
                    }
                }
            }
        }
    }

}