// ContactosViewModel.kt
package com.example.tuapp

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateListOf

data class Contacto(val nombre: String)

class ContactosViewModel : ViewModel() {
    private val _contactos = mutableStateListOf<Contacto>()
    val contactos: List<Contacto> get() = _contactos

    fun agregarContacto(contacto: Contacto) {
        _contactos.add(contacto)
    }
}
