package com.example.kode.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kode.App
import com.example.kode.screens.common.theme.KodeTheme
import com.example.kode.screens.detail.ui.DetailScreen
import com.example.kode.screens.detail.viewmodel.DetailViewModel
import com.example.kode.screens.detail.viewmodel.DetailViewModelFactory
import com.example.kode.screens.main.ui.MainScreen
import com.example.kode.screens.main.viewmodel.MainViewModel
import com.example.kode.screens.main.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    @Inject
    lateinit var detailViewModelFactory: DetailViewModelFactory

    private lateinit var mainViewModel: MainViewModel
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (applicationContext as App).appComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
        detailViewModel = ViewModelProvider(this, detailViewModelFactory)[DetailViewModel::class.java]

        enableEdgeToEdge()
        setContent {
            KodeTheme {
                NavController(
                    mainViewModel,
                    detailViewModel
                )
            }
        }
    }
}

@Composable
fun NavController(
    mainViewModel: MainViewModel,
    detailViewModel: DetailViewModel
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Main.route) {
        composable(Screen.Main.route) {
            MainScreen(mainViewModel, navController)
        }
        composable(
            Screen.Detail.route,
            arguments = listOf(navArgument("userId") { type = NavType.StringType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId") ?: ""
            DetailScreen(detailViewModel, userId)
        }
    }
}

sealed class Screen(val route: String) {
    object Main: Screen("main")
    object Detail: Screen("detail/{userId}") {
        fun createRoute(userId: String) = "detail/$userId"
    }
}
