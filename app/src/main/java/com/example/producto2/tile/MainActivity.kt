/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

@file:Suppress("DEPRECATION")

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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyListState
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import com.example.producto2.R
import com.example.tuapp.ContactosViewModel
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.TextStyle
import java.util.Locale
import kotlin.math.sqrt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {
            val contactosViewModel: ContactosViewModel = viewModel() // Obtener instancia del ViewModel

            // Pasar el ViewModel a la navegación o pantalla principal
            Navegacion(contactosViewModel)
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
                        center = Offset(0.5f, 0.5f),
                        radius = 600f
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
    val dayOfWeek = currentDate.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("es", "ES"))

    val currentTime = LocalDateTime.now()
    val hour = currentTime.hour
    val minute = currentTime.minute
    val amPm = if (hour < 12) "AM" else "PM"
    val hour12 = if (hour > 12) hour - 12 else if (hour == 0) 12 else hour

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
            // Mostrar la fecha con nombre del día de la semana en español
            Text(
                text = "$dayOfWeek, $day/$month/$year",
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
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
                        onClick = { navController.navigate("RutaCuatro") },
                modifier = Modifier.size(25.dp), // Tamaño del botón ajustable
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
                shape = CircleShape,
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "Icono botón 3",
                        modifier = Modifier.size(20.dp) // Tamaño de la imagen ajustable
                    )
                }
                )
                Button(
                    onClick = { navController.navigate("RutaSeis") },
                    modifier = Modifier.size(25.dp), // Tamaño del botón ajustable
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    shape = CircleShape,
                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_expand_more_24),
                            contentDescription = "Icono botón 3",
                            modifier = Modifier.size(20.dp) // Tamaño de la imagen ajustable
                        )
                    }
                )
            }
// Mostrar la hora con formato de 12 horas y AM/PM en español
            Text(
                text = String.format("%02d:%02d %s", hour12, minute, amPm),
                color = Color.White,
                fontWeight = FontWeight.Light,
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(5.dp)
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
        FondoConDegradadoRadial(showImage = true) // No muestra la imagen en ScreenApps
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.radialGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.10f),
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
//golback
@Composable
fun Golback(navController: NavController) {

    Box(

        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        FondoConDegradadoRadial(showImage = true) // No muestra la imagen en ScreenApps
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)

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
fun Menu(navController: NavController) {
    FondoConDegradadoRadial(showImage = true) // No muestra la imagen en ScreenApps
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ScalingLazyColumn {
            item { // Usar ButtonItem aquí
                Regresar(
                    icon = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = "Icono botón 3",
                    onClick = { navController.popBackStack()}
                ) }
            item { // Usar ButtonItem aquí
                Galeria(
                    icon = painterResource(id = R.drawable.galeria),
                    contentDescription = "Icono botón 3",
                    text = "Galeria",
                    onClick = { /* Handle button click */ }
                ) }
            item {
// Usar ButtonItem aquí
                Agenda(
                    icon = painterResource(id = R.drawable.agenda),
                    contentDescription = "Icono botón 3",
                    text = "Agenda",
                    onClick = { /* Handle button click */ }
                )
            }
            item {
// Usar ButtonItem aquí
                Correr(
                    icon = painterResource(id = R.drawable.corriendo),
                    contentDescription = "Icono botón 3",
                    text = "Correr",
                    onClick = { /* Handle button click */ }
                )
            }
            item {
// Usar ButtonItem aquí
                Calculadora(
                    icon = painterResource(id = R.drawable.calculadora),
                    contentDescription = "Icono botón 3",
                    text = "Calculadora",
                    onClick = { navController.navigate("RutaCinco") }
                )
            }
            item {
// Usar ButtonItem aquí
                Linterna(
                    icon = painterResource(id = R.drawable.foco),
                    contentDescription = "Icono botón 3",
                    text = "Linterna",
                    onClick = { /* Handle button click */ }
                )
            }
            item {
// Usar ButtonItem aquí
                Pasos(
                    icon = painterResource(id = R.drawable.paso),
                    contentDescription = "Icono botón 3",
                    text = "Pasos",
                    onClick = { /* Handle button click */ }
                )
            }
            item {
// Usar ButtonItem aquí
                Configuracion(
                    icon = painterResource(id = R.drawable.configuracion),
                    contentDescription = "Icono botón 3",
                    text = "Configuración",
                    onClick = { /* Handle button click */ }
                )
            }
            item {
// Usar ButtonItem aquí
                Facebook(
                    icon = painterResource(id = R.drawable.facebook),
                    contentDescription = "Icono botón 3",
                    text = "Facebook",
                    onClick = { /* Handle button click */ }
                )
            }
            item {
// Usar ButtonItem aquí
                Whatsapp(
                    icon = painterResource(id = R.drawable.whats),
                    contentDescription = "Icono botón 3",
                    text = "WhatsApp",
                    onClick = { /* Handle button click */ }
                )
            }
            item {
// Usar ButtonItem aquí
                Perfil(
                    icon = painterResource(id = R.drawable.perfil),
                    contentDescription = "Icono botón 3",
                    text = "Perfil",
                    onClick = { /* Handle button click */ }
                )
            }
            item { // Usar ButtonItem aquí
                Contacto(
                    icon = painterResource(id = R.drawable.contacto),
                    contentDescription = "Icono botón 3",
                    text = "Contacto",
                    onClick = { navController.navigate("RutaAgregarContacto") }
                )}
            item { // Usar ButtonItem aquí
                Regresar(
                    icon = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = "Icono botón 3",
                    onClick = { navController.popBackStack()}
                ) }
        }
    }
}
@Composable
fun Calculadora(navController: NavController) {
    FondoConDegradadoRadial(showImage = true) // No muestra la imagen en ScreenApps
    var caja by remember { mutableStateOf("0") }
    var resultado by remember { mutableStateOf(0.0) }
    var operador by remember { mutableStateOf("") }
    var dato1 by remember { mutableStateOf(0.0) }
    fun Presionarboton(button: String) {
        when (button) {
            in "0".."9", "." -> {
                if (caja == "0") caja = button else caja += button
            }

            in listOf("/", "*", "-", "+") -> {
                operador = button
                dato1 = caja.toDouble()
                caja = "0"
            }

            "=" -> {
                resultado = when (operador) {
                    "/" -> dato1 / caja.toDouble()
                    "*" -> dato1 * caja.toDouble()
                    "-" -> dato1 - caja.toDouble()
                    "+" -> dato1 + caja.toDouble()
                    else -> 0.0
                }
                caja = resultado.toString()
            }

            "C" -> {
                resultado = 0.0
                caja = "0"
            }

            "+/-" -> {
                resultado = -1.0 * caja.toDouble()
                caja = resultado.toString()
            }

            "χ²" -> {
                resultado = caja.toDouble() * caja.toDouble()
                caja = resultado.toString()
            }

            "√" -> {
                resultado = sqrt(caja.toDouble())
                caja = resultado.toString()
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Calculadora")
        LazyColumn {
            item { Text(text = caja, style = MaterialTheme.typography.display3) }
            item { Renglones("7", "8", "9", "/", "C") { Presionarboton(it) } }
            item { Renglones("4", "5", "6", "*", "+/-") { Presionarboton(it) } }
            item { Renglones("1", "2", "3", "-", "χ²") { Presionarboton(it) } }
            item { Renglones("0", ".", "=", "+", "√") { Presionarboton(it) } }

        }
        ScalingLazyColumn {
            item { // Usar ButtonItem aquí
                Regresar(
                    icon = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = "Icono botón 3",
                    onClick = { navController.popBackStack()}
                ) }
        }
    }

}
@Composable
fun Renglones(vararg buttons: String, onClick: (String) -> Unit){
    Row {
        buttons.forEach { button ->
            Button(
                modifier = Modifier
                    .padding(all = 1.dp)
                    .size(width = 28.dp, height = 25.dp),
                onClick = {onClick(button)},
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Gray.copy(alpha = 0.4f), // Transparencia aplicada al fondo del botón
                    contentColor = Color.White // Color del texto del botón
                )){
                Text(text = button)
            }
        }
    }
}
//Funtion para el notificador
@Composable
fun QuickSettingsScreen(navController: NavController) {
    val isWifiEnabled = remember { mutableStateOf(false) }
    val isBluetoothEnabled = remember { mutableStateOf(false) }
    val isGpsEnabled = remember { mutableStateOf(false) }
    val isAirplaneModeEnabled = remember { mutableStateOf(false) }
    val isSoundEnabled = remember { mutableStateOf(true) }

    Scaffold(

        timeText = { TimeText() }
    ) {
        FondoConDegradadoRadial(showImage = true) // No muestra la imagen en ScreenApps
        ScalingLazyColumn(
            state = ScalingLazyListState(),
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    "Ajustes Rápidos",
                    style = MaterialTheme.typography.title2,
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    SettingButton(
                        iconRes = if (isWifiEnabled.value) R.drawable.baseline_wifi_24 else R.drawable.baseline_wifi_off_24,
                        description = "WiFi",
                        isEnabled = isWifiEnabled.value,
                        onClick = { isWifiEnabled.value = !isWifiEnabled.value }
                    )
                    SettingButton(
                        iconRes = if (isBluetoothEnabled.value) R.drawable.baseline_bluetooth_24 else R.drawable.baseline_bluetooth_disabled_24,
                        description = "Bluetooth",
                        isEnabled = isBluetoothEnabled.value,
                        onClick = { isBluetoothEnabled.value = !isBluetoothEnabled.value }
                    )
                    SettingButton(
                        iconRes = if (isGpsEnabled.value) R.drawable.baseline_fmd_good_24 else R.drawable.baseline_gps_off_24,
                        description = "GPS",
                        isEnabled = isGpsEnabled.value,
                        onClick = { isGpsEnabled.value = !isGpsEnabled.value }
                    )
                }
            }

            item {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    SettingButton(
                        iconRes = if (isAirplaneModeEnabled.value) R.drawable.baseline_airplanemode_active_24 else R.drawable.baseline_airplanemode_inactive_24,
                        description = "Modo Avión",
                        isEnabled = isAirplaneModeEnabled.value,
                        onClick = { isAirplaneModeEnabled.value = !isAirplaneModeEnabled.value }
                    )
                    SettingButton(
                        iconRes = if (isSoundEnabled.value) R.drawable.baseline_notifications_24 else R.drawable.baseline_notifications_off_24,
                        description = "Sonido",
                        isEnabled = isSoundEnabled.value,
                        onClick = { isSoundEnabled.value = !isSoundEnabled.value }
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(32.dp))
                NotificationPreview()
            }
            item { // Usar ButtonItem aquí
                Regresar(
                    icon = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = "Icono botón 3",
                    onClick = { navController.popBackStack()}
                ) }
        }
    }
}
//Agregar contactos
@Composable
fun AddContactScreen(navController: NavController, ContactosViewModel: Any?) {
    var nombre by remember { mutableStateOf("") }

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre del Contacto") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if (nombre.isNotEmpty()) {
                            // Aquí se maneja el guardado del contacto
                            // Puedes pasar el contacto a la vista anterior o a un ViewModel
                            navController.popBackStack() // Volver a la pantalla anterior
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text("Guardar")
                }
            }
        }
    )
}
@Composable
fun ScreenApps(navController: NavController, contactosViewModel: ContactosViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Botón para navegar a la pantalla "RutaAgregarContacto"
        Button(onClick = {
            navController.navigate("RutaAgregarContacto")
        }) {
            Text("Agregar Contacto")
        }

        // Espacio entre el botón y la lista de contactos
        Spacer(modifier = Modifier.height(16.dp))

        // LazyColumn para mostrar la lista de contactos
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Mostrar items de la lista de contactos desde ContactosViewModel
            items(contactosViewModel.contactos) { contacto ->
                Text(text = contacto.nombre) // Mostrar el nombre del contacto
            }
        }
    }
}

//Navegacion de rutas
@Composable
fun Navegacion(ContactosViewModel: Any?) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "RutaUno") {
        composable("RutaUno") { Portada(navController) }
        composable("RutaDos") { ScreenApps(navController) }
        composable("RutaTres") { Golback(navController) }
        composable("RutaCuatro") { Menu(navController) }
        composable("RutaCinco") { Calculadora(navController) }
        composable("RutaSeis") { QuickSettingsScreen(navController) }
        composable("RutaAgregarContacto") { AddContactScreen(navController, ContactosViewModel) }
    }
}



@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    val contactosViewModel: ContactosViewModel = viewModel() // Obtener instancia del ViewModel

    // Pasar el ViewModel a la navegación o pantalla principal
    Navegacion(contactosViewModel)
}
