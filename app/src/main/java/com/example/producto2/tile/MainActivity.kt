/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.producto2.tile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.example.producto2.R
import java.time.LocalDate
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {
            Navegacion()
        }
    }
}

@Composable
fun Imagen(id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = null,
        modifier = Modifier
            .size(200.dp)
            .padding(1.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun FondoConDegradadoRadial(showImage: Boolean = true) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (showImage) {
            Imagen(R.drawable.austronauta)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.5f),
                            Color.Black
                        ),
                        center = androidx.compose.ui.geometry.Offset(0.5f, 0.5f),
                        radius = 450f
                    )
                )
        )
    }
}

@Composable
fun Portada(navController: NavController) {
    val currentDate = LocalDate.now()
    val year = currentDate.year
    val month = currentDate.monthValue
    val day = currentDate.dayOfMonth
    val currentTime = LocalTime.now()
    val min = currentTime.minute
    val hour = currentTime.hour

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        FondoConDegradadoRadial(showImage = true)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Aplicando un degradado al texto
            Text(
                text = "Ivan",
                color = Color.White,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Right,
                modifier = Modifier
                    .padding(16.dp)
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.10f),
                                Color.Black.copy(alpha = 0.10f),
                                Color.Transparent
                            )
                        )
                    )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))


        // Mostrar la fecha del sistema
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Date: $day/$month/$year",
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontSize = 10.sp,
                textAlign = TextAlign.Right,
                modifier = Modifier.padding(20.dp)
            )
            Row (
                modifier = Modifier
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Button(
                    onClick = { navController.navigate("RutaDos") },
                    modifier = Modifier.size(25.dp), // Tamaño del botón ajustable
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
                    shape = CircleShape,
                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.musica),
                            contentDescription = "Icono botón 1",
                            modifier = Modifier.size(20.dp) // Tamaño de la imagen ajustable
                        )
                    }
                )
                Button(
                    onClick = { navController.navigate("RutaTres") },
                    modifier = Modifier.size(25.dp), // Tamaño del botón ajustable
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
                    shape = CircleShape,
                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.yoga),
                            contentDescription = "Icono botón 2",
                            modifier = Modifier.size(20.dp) // Tamaño de la imagen ajustable
                        )
                    }
                )
                Button(
                    onClick = { navController.navigate("RutaDos") },
                    modifier = Modifier.size(25.dp), // Tamaño del botón ajustable
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
                    shape = CircleShape,
                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.musica),
                            contentDescription = "Icono botón 1",
                            modifier = Modifier.size(20.dp) // Tamaño de la imagen ajustable
                        )
                    }
                )
            }

            // Mostrar la hora del sistema
            Text(
                text = "$hour:$min",
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontSize = 60.sp,
                textAlign = TextAlign.Right,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
fun ScreenApps(navController: NavController) {
    val currentTime = LocalTime.now()
    val hour = currentTime.hour
    val min = currentTime.minute

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        FondoConDegradadoRadial(showImage = false) // No muestra la imagen en ScreenApps
        Column(
            modifier = Modifier.fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Magenta.copy(alpha = 0.10f),
                            Color.Black
                        ),
                        center = Offset(0.5f, 0.5f), // Coordenadas del centro del degradado
                        radius = 500f // Radio del degradado
                    )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "$hour:$min",
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "Chef Table Radio",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "Eli Kulp",
                color = Color.White,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(4.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_previous),
                    contentDescription = "Previous",
                    tint = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { /* Acción de botón anterior */ }
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_play_pause),
                    contentDescription = "Play/Pause",
                    tint = Color.White,
                    modifier = Modifier
                        .size(72.dp)
                        .clickable { navController.navigate("Reproductor") }
                        .padding(horizontal = 16.dp)
                        .clip(CircleShape)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_next),
                    contentDescription = "Next",
                    tint = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { /* Acción de botón siguiente */ }
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_favorite_border_24),
                    contentDescription = "Favorite",
                    tint = Color.White,
                    modifier = Modifier
                        .size(35.dp)
                        .clickable { /* Acción de botón favorito */ }
                )
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.size(20.dp), // Tamaño del botón ajustable
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
                    shape = CircleShape,
                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.regreso),
                            contentDescription = "Icono botón 1",
                            modifier = Modifier.size(20.dp) // Tamaño de la imagen ajustable
                        )
                    }
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_volume),
                    contentDescription = "Volume",
                    tint = Color.White,
                    modifier = Modifier
                        .size(35.dp)
                        .clickable { /* Acción de botón volumen */ }
                )
            }
        }
    }
}
@Composable
fun Golback(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(Color.Black)
        ) {
            Text(
                text = "Power Yoga",
                color = Color.Yellow,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 20.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow),
                modifier = Modifier
                    .width(130.dp)
                    .clip(CircleShape)
                    .padding(10.dp)
            ) {
                Text(
                    text = "Go back",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Last session 45m",
                color = Color.Yellow,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 20.dp)
            )
        }
    }
}

@Composable
fun Menu(navController: NavController){

}

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "RutaUno") {
        composable("RutaUno") { Portada(navController) }
        composable("RutaDos") { ScreenApps(navController) }
        composable("RutaTres") { Golback(navController) }
        composable("RutaTre4") { Menu(navController) }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Navegacion()
}
