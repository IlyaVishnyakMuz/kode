package com.example.kode.screens.main.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.domain.repo.entity.User
import com.example.kode.screens.Screen
import com.example.kode.screens.main.viewmodel.MainViewModel

@Composable
fun Users(viewModel: MainViewModel, navController: NavController) {
    val users = viewModel.users.collectAsState().value
    UserList(users, navController)
}

@Composable
fun UserList(users: List<User>, navController: NavController) {
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
                position = user.position,
                onItemClick = {
                    navController.navigate(Screen.Detail.createRoute(user.id))
                }
            ) }
        }
    }
}
