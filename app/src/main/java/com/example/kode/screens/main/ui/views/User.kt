package com.example.kode.screens.main.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.kode.screens.common.theme.TextPrimary
import com.example.kode.screens.common.theme.TextSecondary
import com.example.kode.screens.common.theme.TextTertiary

@Composable
fun User(
    avatarUrl: String,
    firstName: String,
    lastName: String,
    userTag: String,
    position: String,
    onItemClick: () -> Unit
) {
    Row(
        modifier = Modifier.padding(0.dp, 6.dp)
            .clickable(onClick = onItemClick),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = rememberAsyncImagePainter(avatarUrl),
            modifier = Modifier
                .size(72.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
            contentDescription = "",
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "$firstName $lastName",
                    fontSize = 16.sp,
                    color = TextPrimary,
                    fontWeight = FontWeight.W500,
                    lineHeight = 20.sp
                )
                Text(
                    text = userTag,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W500,
                    color = TextTertiary,
                    lineHeight = 18.sp
                )
            }
            Text(
                text = position,
                fontSize = 13.sp,
                color = TextSecondary,
                lineHeight = 16.sp
            )
        }
    }
}
