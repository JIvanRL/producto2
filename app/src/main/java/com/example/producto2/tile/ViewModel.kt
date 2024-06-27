package com.example.producto2.tile

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

// Definición del modelo de datos para un contacto
data class Contacto(val nombre: String, val numero: String)

// Definición del ViewModel para manejar los contactos
class ContactViewModel : ViewModel() {
    // Lista mutable de contactos que será observada por las composables
    val contactos: SnapshotStateList<Contacto> = mutableStateListOf()

    // Función para agregar un nuevo contacto a la lista
    fun addContact(nombre: String, numero: String) {
        contactos.add(Contacto(nombre, numero))
    }
}
