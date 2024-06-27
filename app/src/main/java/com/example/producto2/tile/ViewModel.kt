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

    //Función para eliminar un conatcto
    fun DeleteContact(){
        //contactos.remove(ContactViewModel())
    }
}
 clase de enumeración TimerState { EN EJECUCIÓN , EN PAUSA , RESET }

 clase StopWatchViewModel: VerModel() {

 valor privado _elapsedTime = MutableStateFlow ( 0L )
 valor privado _timerState = MutableStateFlow ( TimerState.RESET )
 val timerState = _timerState . como flujo de estado ()

 formateador de valor privado = DateTimeFormatter.ofPattern( "HH:mm:ss:SSS" )
 val stopWatchText = _tiempo transcurrido
        . mapa { milis ->
            LocalTime.ofNanoOfDay(millis * 1_000_000 ).format( formateador )
 }
        . estado en (
 verModelScope ,
 CompartiendoIniciado. Mientras está suscrito ( 5000 ),
 "00:00:00:000"
        )

 en eso {
 _timerState
            . flatMapLatest { estado del temporizador ->
                getTimerFlow( isRunning = timerState == TimerState. EJECUTANDO )
 }
            . en cada { diferenciatiempo ->
                _tiempo transcurrido . actualizar {it + timeDiff }
 }
            . lanzamiento en ( viewModelScope )
 }

 divertido toggleIsRunning () {
 cuando ( timerState . valor ) {
 Estado del temporizador. EN EJECUCIÓN -> _timerState . actualizar { TimerState. PAUSADO }
            Estado del temporizador. PAUSADO , Estado del temporizador. RESTABLECER -> _timerState . actualizar { TimerState. CORRER }
        }
 }

 divertido resetTimer () {
 _timerState . actualizar { TimerState. REINICIAR }
        _tiempo transcurrido . actualizar { 0L }
    }

 diversión privada getTimerFlow (isRunning: booleano): Flow<Long> {
 flujo de retorno {
            var startMillis = System.currentTimeMillis()
 mientras (está corriendo) {
 val currentMillis = System.currentTimeMillis()
 val timeDiff = if (currentMillis > startMillis) {
 actualMillis - inicioMillis
 } más 0L
                emitir (diferencia de tiempo)
 startMillis = System.currentTimeMillis()
 retraso ( 10L )
 }
 }
    }
 }
