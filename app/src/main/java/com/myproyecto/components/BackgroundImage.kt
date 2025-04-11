package com.myproyecto.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.myproyecto.R // Asegurate de reemplazar "tu_paquete" con el nombre real de tu paquete


@Composable
fun BackgroundImage(alpha: Float = 0.4f) {
    Image(
        painter = painterResource(id = R.drawable.login_background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .graphicsLayer { this.alpha = alpha  }
    )
}