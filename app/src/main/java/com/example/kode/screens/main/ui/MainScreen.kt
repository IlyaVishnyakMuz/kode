package com.example.kode.screens.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kode.screens.main.ui.views.TopBar
import com.example.kode.screens.main.ui.views.Users
import com.example.kode.screens.main.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel, navController: NavController) {
    viewModel.loadUsers()
    Surface (
        Modifier.systemBarsPadding()
    ){
        Column {
            TopBar(viewModel)
            Users(viewModel, navController)
        }
    }
}
