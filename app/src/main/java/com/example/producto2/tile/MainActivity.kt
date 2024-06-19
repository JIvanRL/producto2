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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.wear.compose.material.Text
import com.example.producto2.R
import java.time.LocalDate
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

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
            .fillMaxSize()
            .size(50.dp)
            .padding(1.dp),
        contentScale = ContentScale.Crop
    )
}
@Composable
fun FondoConDegradadoRadial() {
    Box(modifier = Modifier.fillMaxSize()) {
        Imagen(R.drawable.austronauta)
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
        FondoConDegradadoRadial()
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Aplicando un degradado al texto "Hola Ivan"
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
    }
    Box (
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Mostrar la fecha del sistema
            Text(
                text = "Date: $day/$month/$year",
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontSize = (10.sp),
                textAlign = TextAlign.Right,
                modifier = Modifier.padding(20.dp)
            )
        }
    }

    Box (
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Mostrar la fecha del sistema
            Text(
                text = "$hour:$min",
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontSize = (50.sp),
                textAlign = TextAlign.Right,
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}
@Composable
fun ScreenApps(navController: NavController){

}
@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "RutaUno") {
        composable("RutaUno") { Portada(navController) }
        composable("RutaDos") { ScreenApps(navController) }
    }
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Navegacion()
}