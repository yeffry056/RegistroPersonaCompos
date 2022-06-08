package com.jjvcorporation.registropersonacompos.ui.persona

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jjvcorporation.registropersonacompos.RowNombre

@Composable
fun ConsultaPerson(goRegistro : () -> Unit, goOcupacion : () -> Unit){

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Consulta Persona") })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    goRegistro()
                },
                backgroundColor = MaterialTheme.colors.primary


            ) {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)

            }
        },
        scaffoldState = scaffoldState
    ) {

        Column(modifier = Modifier.padding(it).padding(8.dp)) {
            OutlinedButton(
                onClick = {
                    goOcupacion()
                }) {
                Text(text = "Ocupaciones")
            }
            val lis = listOf("juan", "miguel")

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(lis){ nombre->
                    RowNombre(nombre)
                }
            }
        }
    }
}