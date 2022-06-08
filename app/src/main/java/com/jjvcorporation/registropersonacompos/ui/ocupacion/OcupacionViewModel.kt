package com.jjvcorporation.registropersonacompos.ui.ocupacion

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Delete
import com.jjvcorporation.registropersonacompos.data.repository.OcupacionRepositiry
import com.jjvcorporation.registropersonacompos.model.Ocupacion
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OcupacionViewModel @Inject constructor(
    val ocupacionRepositiry: OcupacionRepositiry
): ViewModel() {

    var nombre by mutableStateOf("")
    var id by mutableStateOf("")
    var limpiar by mutableStateOf("")

    var ocupaciones = ocupacionRepositiry.GetLista()
    private set

    fun Guardar(){
        viewModelScope.launch{
            ocupacionRepositiry.insertar(
                Ocupacion(
                    ocupacionId = id.toInt(),
                    ocupaciones = nombre

                )
            )
        }
    }


}