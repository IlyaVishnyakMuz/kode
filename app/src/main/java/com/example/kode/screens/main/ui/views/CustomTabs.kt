package com.example.kode.screens.main.ui.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kode.screens.common.theme.TextPrimary
import com.example.kode.screens.common.theme.TextTertiary
import com.example.kode.screens.main.viewmodel.MainViewModel

@Composable
fun CustomTabs(viewModel: MainViewModel) {
    val tabs = listOf(
        TabItem("Все", null),
        TabItem("Android", "android"),
        TabItem("iOS", "ios"),
        TabItem("Дизайн", "design"),
        TabItem("Менеджмент", "management"),
        TabItem("QA", "qa"),
        TabItem("Бэк-офис", "back_office"),
        TabItem("Frontend", "frontend"),
        TabItem("HR", "hr"),
        TabItem("PR", "pr"),
        TabItem("Backend", "backend"),
        TabItem("Техподдержка", "support"),
        TabItem("Аналитика", "analytics"),
    )
    ScrollableTabRow(
        selectedTabIndex = viewModel.selectedTabIndex.collectAsState().value,
        edgePadding = 16.dp,
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selected = viewModel.selectedTabIndex.collectAsState().value == index,
                onClick = {
                    viewModel.changeSelectedTabIndex(index)
                    viewModel.getUsersByDepartment(tab.department)
                },
                modifier = Modifier.padding(12.dp, 8.dp)
            ) {
                Text(
                    text = tab.title,
                    fontSize = 15.sp,
                    color = if (viewModel.selectedTabIndex.collectAsState().value == index) TextPrimary else TextTertiary
                )
            }
        }
    }
}

data class TabItem(val title:String, val department: String?)
