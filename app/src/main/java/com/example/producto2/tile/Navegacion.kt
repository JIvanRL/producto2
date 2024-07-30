package com.example.producto2.tile

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

// Función que define la navegación de la aplicación
@Composable
fun Navegacion() {
    val navController = rememberNavController() // Recordar el controlador de navegación
    val contactViewModel: ContactViewModel = viewModel() // Instancia del ViewModel de contactos

    // Definir el host de navegación con las rutas
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
        composable("Cronometro") { PaginaOcho(navController) }
        composable("Musica") { MusicScreen(navController) }
        // Ruta para la pantalla de edición de contacto con argumento contactName
        composable(
            route = "EditContacto?contactName={contactName}", // Define la ruta para la pantalla de edición de contacto, con un argumento de consulta llamado 'contactName'
            arguments = listOf(navArgument("contactName") { type = NavType.StringType }) // Declara que 'contactName' es un argumento de tipo String que se pasa a la pantalla
        ) { backStackEntry ->  // 'backStackEntry' es un objeto que representa la entrada actual en la pila de navegación
            // Obtener el nombre del contacto desde los argumentos de la ruta actual
            val contactName = backStackEntry.arguments?.getString("contactName") ?: ""
            // La función getString("contactName") extrae el valor del argumento 'contactName' que se pasó a la ruta.
            // Si no hay un argumento 'contactName', el operador Elvis (?:) proporciona una cadena vacía como valor predeterminado.

            // Buscar el contacto en la lista de contactos del ViewModel usando el nombre extraído de los argumentos
            val contact = contactViewModel.contactos.find { it.nombre == contactName }
            // La función find busca en la lista de contactos del ViewModel el primer contacto cuyo nombre coincida con 'contactName'.
            // La condición es que 'it.nombre' (el nombre del contacto actual en la lista) debe ser igual a 'contactName'.

            if (contact != null) {
                // Si se encuentra un contacto con el nombre especificado, navega a la pantalla de edición del contacto
                EditContactScreen(navController, contactViewModel, contact)
                // Llama a la pantalla de edición y pasa el contacto encontrado a esta pantalla para que pueda ser editado.
            } else {
                // Manejo del caso en que el contacto no es encontrado
                // Puedes agregar lógica para manejar el caso en que no se encuentra el contacto, como mostrar un mensaje de error.
                // Ejemplo: mostrar un mensaje de error o redirigir al usuario a una pantalla diferente.
            }
        }
        composable("Galeria") { PaginaDoce(navController) }
        composable("Task"){ TODOList(navController)}
    }
}