package com.example.interfacegrafica

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MinhaViewBemSimples : ViewModel() {
    private val _contadorDaViewModel = MutableStateFlow(0)
    val contadorDaViewPublico: StateFlow<Int> get() = _contadorDaViewModel

    fun incrementaContador(){
        _contadorDaViewModel.value += 1
    }

    fun subtraiContador(){
        _contadorDaViewModel.value -= 1
    }

}