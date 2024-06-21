package com.example.producto2.tile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Text


@Composable
fun Galeria(
    icon: Painter,
    contentDescription: String,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .size(200.dp, 40.dp)
            .padding(vertical = 1.dp), // Ajusta el padding según necesidades
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Gray.copy(alpha = 0.4f), // Transparencia aplicada al fondo del botón
            contentColor = Color.White // Color del texto del botón
        ),
        shape = CircleShape,
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start, // Alinea la imagen a la izquierda
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = icon,
                    contentDescription = contentDescription,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(1.dp))

            }
            Text(text = text)
        }
    )
}
@Composable
fun Agenda(
    icon: Painter,
    contentDescription: String,
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .size(200.dp, 40.dp)
            .padding(vertical = 1.dp), // Ajusta el padding según necesidades
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Gray.copy(alpha = 0.4f), // Transparencia aplicada al fondo del botón
            contentColor = Color.White // Color del texto del botón
        ),
        shape = CircleShape,
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start, // Alinea la imagen a la izquierda
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = icon,
                    contentDescription = contentDescription,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(1.dp))

            }
            Text(text = text)
        }
    )
}
