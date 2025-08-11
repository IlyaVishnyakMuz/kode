package com.example.kode.screens.main.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kode.screens.common.theme.BgSecondary
import com.example.kode.screens.common.theme.Secondary

@Composable
fun CustomSearchBar() {
    val message = remember{mutableStateOf("")}
    OutlinedTextField(
        textStyle = TextStyle(fontSize =  15.sp),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 6.dp, 16.dp, 8.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BgSecondary,
            unfocusedBorderColor = BgSecondary,
            unfocusedContainerColor = BgSecondary,
            focusedContainerColor = BgSecondary,
            unfocusedPlaceholderColor = Secondary,
            focusedPlaceholderColor = Secondary,
            unfocusedLeadingIconColor = Secondary,
            focusedLeadingIconColor = Secondary,
            unfocusedTrailingIconColor = Secondary,
            focusedTrailingIconColor = Secondary
        ),
        value = message.value,
        onValueChange = {message.value = it},
        placeholder = {
            Text("Введи имя, тег, почту...", fontSize = 15.sp)
        },
        leadingIcon = {
            Icon(Icons.Filled.Search, contentDescription = "")
        },
        trailingIcon = {
            Icon(Icons.Default.Menu, contentDescription = "")
        },
    )
}
