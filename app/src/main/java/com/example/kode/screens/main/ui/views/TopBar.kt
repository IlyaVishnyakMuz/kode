package com.example.kode.screens.main.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.kode.screens.main.viewmodel.MainViewModel

@Composable
fun TopBar(viewModel: MainViewModel) {
    Column {
        CustomSearchBar()
        CustomTabs(viewModel)
    }
}
