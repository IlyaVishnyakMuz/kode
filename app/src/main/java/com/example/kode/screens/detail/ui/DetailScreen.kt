package com.example.kode.screens.detail.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.kode.screens.detail.viewmodel.DetailViewModel

@Composable
fun DetailScreen(viewModel: DetailViewModel, userId: String) {
    Text(userId)
}
