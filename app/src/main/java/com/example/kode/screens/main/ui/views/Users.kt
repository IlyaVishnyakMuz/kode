package com.example.kode.screens.main.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.domain.repo.entity.UsersData
import com.example.kode.screens.main.viewmodel.MainViewModel

@Composable
fun Users(viewModel: MainViewModel) {
    val state = viewModel.state.collectAsState().value
    when (viewModel.selectedTabIndex.collectAsState().value) {
        0 -> {
            when {
                state.isLoading -> LoadingView()
                else -> UserList(users = state.users)
            }
        }
    }
}

@Composable
fun UserList(users: List<UsersData>) {
    LazyColumn(
        modifier = Modifier.padding(16.dp, 0.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        for(user in users) {
            item { User(
                avatarUrl = user.avatarUrl,
                firstName = user.firstName,
                lastName = user.lastName,
                userTag = user.userTag,
                position = user.position
            ) }
        }
    }
}

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
