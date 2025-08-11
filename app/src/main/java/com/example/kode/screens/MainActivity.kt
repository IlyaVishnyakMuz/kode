package com.example.kode.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.kode.App
import com.example.kode.screens.common.theme.KodeTheme
import com.example.kode.screens.main.ui.MainScreen
import com.example.kode.screens.main.viewmodel.MainViewModel
import com.example.kode.screens.main.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as App).appComponent.inject(this)

        mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            KodeTheme {
                MainScreen(mainViewModel)
            }
        }
    }
}
