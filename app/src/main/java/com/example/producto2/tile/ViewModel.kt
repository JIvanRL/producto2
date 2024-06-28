package com.example.producto2.tile

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import java.time.LocalTime
import java.time.format.DateTimeFormatter

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
    fun DeleteContact(contacto: Contacto){
        contactos.remove(contacto)
    }
}
enum class TimerState { RUNNING, PAUSED, RESET }

class StopWatchViewModel : ViewModel() {

    private val _elapsedTime = MutableStateFlow(0L)
    private val _timerState = MutableStateFlow(TimerState.RESET)
    val timerState = _timerState.asStateFlow()

    private val formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SSS")
    val stopWatchText = _elapsedTime
        .map { millis ->
            LocalTime.ofNanoOfDay(millis * 1_000_000).format(formatter)
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            "00:00:00:000"
        )

    init {
        _timerState
            .flatMapLatest { timerState ->
                getTimerFlow(isRunning = timerState == TimerState.RUNNING)
            }
            .onEach { timeDiff ->
                _elapsedTime.update { it + timeDiff }
            }
            .launchIn(viewModelScope)
    }

    fun toggleIsRunning() {
        when (timerState.value) {
            TimerState.RUNNING -> _timerState.update { TimerState.PAUSED }
            TimerState.PAUSED, TimerState.RESET -> _timerState.update { TimerState.RUNNING }
        }
    }

    fun resetTimer() {
        _timerState.update { TimerState.RESET }
        _elapsedTime.update { 0L }
    }

    private fun getTimerFlow(isRunning: Boolean): Flow<Long> {
        return flow {
            var startMillis = System.currentTimeMillis()
            while (isRunning) {
                val currentMillis = System.currentTimeMillis()
                val timeDiff = if (currentMillis > startMillis) {
                    currentMillis - startMillis
                } else 0L
                emit(timeDiff)
                startMillis = System.currentTimeMillis()
                delay(10L)
            }
        }
    }
}
