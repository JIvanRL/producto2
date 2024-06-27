/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

@file:Suppress("DEPRECATION")

package com.example.producto2.tile

import android.annotation.SuppressLint
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
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
import androidx.wear.compose.foundation.lazy.items
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import com.example.producto2.R
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
                        center = Offset(0.5f, 0.5f),
                        radius = 600f
                    )
                )
        )
    }
}


@SuppressLint("DefaultLocale")
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
                Info(
                    icon = painterResource(id = R.drawable.info),
                    contentDescription = "Icono botón 3",
                    text = "Info",
                    onClick = { navController.navigate("InfoRute") }
                )}
            item { // Usar ButtonItem aquí
                Contacto(
                    icon = painterResource(id = R.drawable.contacto),
                    contentDescription = "Icono botón 3",
                    text = "Contacto",
                    onClick = { navController.navigate("ViewContacto") }
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
// Función para agregar un nuevo contacto
@Composable
fun ViewContacto(navController: NavController, contactViewModel: ContactViewModel = viewModel()) {
    // Obtener la lista de contactos desde el ViewModel
    val contactos = contactViewModel.contactos

    // Imágenes por defecto para los iconos
    val defaultImage = R.drawable.baseline_person_24
    val defaultEdit = R.drawable.baseline_edit_24
    val defaulDelete = R.drawable.baseline_delete_24
    FondoConDegradadoRadial(showImage = true) // No muestra la imagen en ScreenApps

    // Crear una columna que ocupa todo el tamaño disponible
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Título de la pantalla
        Text("Contactos", style = MaterialTheme.typography.title1)

        // Botón para navegar a la pantalla de agregar contacto
        IconButton(onClick = { navController.navigate("RutaAgregarContacto") }) {
            Icon(
                painter = painterResource(R.drawable.baseline_add_circle_outline_24),
                contentDescription = "Add Contact",
                tint = Color.White // Ajusta el color del icono si es necesario
            )
        }

        // Lista de contactos usando ScalingLazyColumn
        ScalingLazyColumn {
            // Iterar sobre la lista de contactos y crear una fila para cada uno
            items(contactos) { contacto ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Imagen del contacto por defecto
                    Image(
                        painter = painterResource(id = defaultImage),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(end = 8.dp)
                    )
                    // Column para mostrar el nombre y número del contacto
                    Column(modifier = Modifier.weight(1f)
                        ) {
                        Text(
                            contacto.nombre,
                            style = MaterialTheme.typography.body1
                        )
                        Column {
                            Text(
                                contacto.numero,
                                style = MaterialTheme.typography.caption1,
                            )
                        }

                    }
                    // Botón de edición para cada contacto (aún no implementado)
                    IconButton(onClick = { /*TODO*/ },
                        modifier = Modifier.size(20.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = defaultEdit),
                            contentDescription = "Edit Contact",
                            tint = Color.White
                        )
                    }
                    IconButton(onClick = {
                       // if(contacto > 0) {
                           // contactViewModel.DeleteContact(nombre, numero)
                       // }
                    },
                        modifier = Modifier.size(20.dp)) {
                        Icon(
                            painter = painterResource(id = defaulDelete),
                            contentDescription = "Delete Contact",
                            tint = Color.White
                        )
                    }
                }
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
// Pantalla para agregar un contacto
@Composable
fun AddContactScreen(navController: NavController, contactViewModel: ContactViewModel = viewModel()) {
    // Variables de estado para almacenar los valores del nombre y el número
    var nombre by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }

    // Estado para controlar la visibilidad del AlertDialog
    var showDialog by remember { mutableStateOf(false) }
    FondoConDegradadoRadial(showImage = true) // No muestra la imagen en ScreenApps
    // Columna principal que contiene el formulario para agregar contactos
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el tamaño disponible
            .padding(horizontal = 16.dp, vertical = 32.dp), // Padding para separar del borde y centrar verticalmente
        verticalArrangement = Arrangement.Center, // Centrar verticalmente el contenido
        horizontalAlignment = Alignment.CenterHorizontally // Centrar horizontalmente el contenido
    ) {
        // Título de la pantalla
        Text("Agregar Contacto", style = MaterialTheme.typography.title1, color = Color.White)
        Spacer(modifier = Modifier.height(16.dp)) // Espacio adicional debajo del título

        // Columna que contiene el formulario para agregar un contacto
        Column(
            modifier = Modifier
                .fillMaxWidth() // Ajusta al ancho máximo disponible
                .verticalScroll(rememberScrollState()), // Agrega scroll vertical si es necesario
            verticalArrangement = Arrangement.spacedBy(8.dp), // Espaciado vertical entre los elementos
            horizontalAlignment = Alignment.CenterHorizontally // Centrar horizontalmente los elementos
        ) {
            // Campo de entrada para el nombre del contacto
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it }, // Actualiza el estado con el valor ingresado
                label = { Text("Nombre") },
                textStyle = MaterialTheme.typography.body1.copy(color = Color.White),
                modifier = Modifier.fillMaxWidth(), // Ajusta al ancho máximo disponible
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Magenta, // Color del borde cuando no está enfocado
                    //focusedBorderColor = Color.Blue, // Color del borde cuando está enfocado
                    backgroundColor = Color.Transparent // Color de fondo del contenedor
                )
            )

            // Campo de entrada para el número del contacto
            OutlinedTextField(
                value = numero,
                onValueChange = { numero = it }, // Actualiza el estado con el valor ingresado
                label = { Text("Número") },
                textStyle = MaterialTheme.typography.body1.copy(color = Color.White),
                modifier = Modifier.fillMaxWidth(), // Ajusta al ancho máximo disponible
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color.Magenta, // Color del borde cuando no está enfocado
                    focusedBorderColor = Color.Blue, // Color del borde cuando está enfocado
                    backgroundColor = Color.Transparent // Color de fondo del contenedor
                )
            )

            // Espacio adicional para separación visual
            Spacer(modifier = Modifier.height(16.dp))

            // Botón para guardar el contacto
            Button(
                onClick = {
                    // Verifica si los campos no están vacíos
                    if (nombre.isNotBlank() && numero.isNotBlank()) {
                        // Agrega el contacto usando el ViewModel
                        contactViewModel.addContact(nombre, numero)
                        // Limpia los campos de entrada
                        nombre = ""
                        numero = ""
                        // Navega de regreso a la pantalla anterior (ViewContacto)
                        navController.popBackStack()
                    } else {
                        // Muestra el AlertDialog si los campos están vacíos
                        showDialog = true
                    }
                },
                modifier = Modifier.fillMaxWidth() // Ajusta al ancho máximo disponible
            ) {
                Text("Guardar", color = Color.White)
            }

            // Botón para regresar a la pantalla anterior sin guardar
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.size(20.dp), // Tamaño del botón ajustable
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent), // Color del botón
                shape = CircleShape // Forma del botón
            ) {
                // Imagen dentro del botón de regreso
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = "Icono botón 1",
                    modifier = Modifier.size(20.dp) // Tamaño de la imagen ajustable
                )
            }
        }
    }

    // AlertDialog para mostrar mensaje de error cuando los campos están vacíos
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false }, // Dismiss el diálogo cuando se hace clic fuera de él
            title = {
                Text(text = "Error", color = Color.Black)
            },
            text = {
                Text(text = "Por favor ingresa nombre y número", color = Color.Black)
            },
            confirmButton = {
                Button(
                    onClick = { showDialog = false } // Cierra el diálogo al hacer clic en OK
                ) {
                    Text("OK")
                }
            },
            backgroundColor = Color.White, // Color de fondo del diálogo
            contentColor = Color.Black // Color del contenido del diálogo
        )
    }
}

//Info de la app
@Composable
fun Info(navController: NavController) {
    FondoConDegradadoRadial(showImage = true) // No muestra la imagen en ScreenApps
    // Datos de ejemplo sobre Wear OS
    val wearOSInfo = listOf(
        "Versión del sistema operativo: Wear OS 3.0",
        "Desarrollador: Tec.Developer",
        "Lanzamiento inicial: 18 de Junio de 2014",
        "Última actualización: 2 de junio de 2023",
        "Idiomas compatibles: Varios idiomas",
        "Disponibilidad: Dispositivos compatibles con Wear OS"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Información sobre Wear OS",
            style = MaterialTheme.typography.title1,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Lista de información sobre Wear OS
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            items(wearOSInfo) { info ->
                Text(
                    text = info,
                    style = MaterialTheme.typography.body1,
                    color = Color.White,
                    fontSize = 15.sp
                )
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
//Revisar si funciona por separado
@Composable
fun PaginaOcho(navController: NavController) {
    val viewModel: StopWatchViewModel = viewModel()
    val timerState by viewModel.timerState.collectAsState()
    val stopWatchText by viewModel.stopWatchText.collectAsState()

    Scaffold(
        timeText = {
            TimeText(
                timeTextStyle = TimeTextDefaults.timeTextStyle(
                    fontSize = 17.sp,
                    color = Color.Black // Color del texto del tiempo
                )
            )
        },
        vignette = {
            Vignette(vignettePosition = VignettePosition.TopAndBottom)
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.fondo),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                StopWatch(
                    state = timerState,
                    text = stopWatchText,
                    onToggleRunning = viewModel::toggleIsRunning,
                    onReset = viewModel::resetTimer,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Button(
                        onClick = { navController.navigate("RutaSiete") },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                    ) {
                        Text("<", color = Color.Black)
                    }
                    Button(
                        onClick = { navController.navigate("RutaNueve") },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                    ) {
                        Text(">", color = Color.Black)
                    }
                }
            }
        }
    }
}
@Composable
private fun StopWatch(
    state: TimerState,
    text: String,
    onToggleRunning: () -> Unit,
    onReset: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onToggleRunning,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Magenta,
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    imageVector = if (state == TimerState.RUNNING) {
                        Icons.Default.Add
                    } else {
                        Icons.Default.PlayArrow
                    },
                    contentDescription = null,
                    tint = Color.Black
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = onReset,
                enabled = state != TimerState.RESET,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Magenta,
                    contentColor = Color.Black
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}

//Navegacion de rutas
@Composable
fun Navegacion() {
    val navController = rememberNavController()
    val contactViewModel: ContactViewModel = viewModel()

    NavHost(navController, startDestination = "RutaUno") {
        composable("RutaUno") { Portada(navController) }
        composable("RutaDos") { ScreenApps(navController) }
        composable("RutaTres") { Golback(navController) }
        composable("RutaCuatro") { Menu(navController) }
        composable("RutaCinco") { Calculadora(navController) }
        composable("RutaSeis") { QuickSettingsScreen(navController) }
        composable("ViewContacto") { ViewContacto(navController, contactViewModel) }
        composable("RutaAgregarContacto") { AddContactScreen(navController, contactViewModel) }
        composable("InfoRute") { Info(navController) }
    }
}
@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Navegacion()
}
