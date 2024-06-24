package com.example.producto2.tile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import com.example.producto2.R


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
@Composable
fun Correr(
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
fun Calculadora(
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
fun Linterna(
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
fun Pasos(
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
fun Configuracion(
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
fun Perfil(
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
fun Facebook(
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
fun Whatsapp(
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
fun Contacto(
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
fun Regresar(
    icon: Painter,
    contentDescription: String,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(48.dp) // Tamaño del botón, puedes ajustarlo según tus necesidades
    ) {
        Image(
            painter = icon,
            contentDescription = contentDescription,
            modifier = Modifier.size(24.dp) // Tamaño del ícono, puedes ajustarlo según tus necesidades
        )
    }
}
@Composable
fun SettingButton(iconRes: Int, description: String, isEnabled: Boolean, onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = description,
                modifier = Modifier
                    .size(48.dp)
                    .background(
                        color = if (isEnabled) Color.Green else Color.Gray.copy(alpha = 0.3f),
                        shape = CircleShape
                    )
                    .padding(8.dp)
            )
            Text(description, style = MaterialTheme.typography.caption)
        }
    }
}
@Composable
fun NotificationPreview() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = Color.DarkGray.copy(alpha = 0.5f),
        contentColor = Color.White
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_message_24),
                contentDescription = "Notification Icon",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text("Mensaje nuevo", style = MaterialTheme.typography.body1)
                Text("Tienes un nuevo mensaje de Ana.", style = MaterialTheme.typography.body2)
            }
        }
    }
}


