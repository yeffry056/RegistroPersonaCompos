package com.jjvcorporation.registropersonacompos.ui.ocupacion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jjvcorporation.registropersonacompos.RowOcupaciones
import com.jjvcorporation.registropersonacompos.data.repository.OcupacionRepositiry
import com.jjvcorporation.registropersonacompos.util.Screen

@Composable
fun ConsultaOcupaciones(
    goOcupRegistro : () -> Unit,
    viewModel: OcupacionViewModel = hiltViewModel()
){

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Listado de Ocupaciones") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    goOcupRegistro()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        scaffoldState = scaffoldState
    ) {


        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)) {

           // val ocup = listOf("Bombero","Dentista", "Enfermera","Medico")
            val ocup = viewModel.ocupaciones.collectAsState(initial = emptyList()).value
            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(ocup){ocupaciones->
                    RowOcupaciones(ocupaciones)
                }
            }
        }
    }



}

