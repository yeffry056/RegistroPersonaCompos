package com.jjvcorporation.registropersonacompos.ui.persona

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RegistroPerson(){

    var persona by rememberSaveable() {
        mutableStateOf("")
    }
    Scaffold(
        topBar={
            TopAppBar(title = { Text(text = "Registro de personas") })
        }

    ) {
        Column(modifier = Modifier.padding(it).padding(8.dp)) {
            OutlinedTextField(
                label = {
                    Text(text = "ID")
                },
                leadingIcon={
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },


                value = persona,
                onValueChange = {persona = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Escribe tu nombre")
                },
                leadingIcon={
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                },


                value = persona,
                onValueChange = {persona = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Salario")
                },
                leadingIcon={
                    Icon(imageVector = Icons.Default.MonetizationOn, contentDescription = null)
                },


                value = persona,
                onValueChange = {persona = it},
                modifier = Modifier.fillMaxWidth()

            )

            Row() {

                OutlinedButton(
                    onClick = { /*TODO*/
                        //
                    },
                    modifier = Modifier.padding(5.dp)
                ) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription = null)
                    Text(text = " Nuevo")


                }

                OutlinedButton(
                    onClick = { /*TODO*/
                        //
                    },
                    modifier = Modifier.padding(5.dp)
                ) {
                    Icon(imageVector = Icons.Default.AddCircle, contentDescription = null)
                    Text(text = " Guardar")

                }

                OutlinedButton(
                    onClick = { /*TODO*/
                        //
                    },
                    modifier = Modifier.padding(5.dp)
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = null)
                    Text(text = " Eliminar")

                }


            }
        }

    }




}