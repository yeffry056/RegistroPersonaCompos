package com.jjvcorporation.registropersonacompos.ui.ocupacion

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PermIdentity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jjvcorporation.registropersonacompos.ui.componentes.Utilidades

@Composable
fun Clear() {


}


@Composable
fun RegistroOcupaciones(

    viewModel: OcupacionViewModel = hiltViewModel()
){
    val mContext = LocalContext.current



    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de ocupaciones") })
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .padding(8.dp)) {

            OutlinedTextField(
                label = {
                    Text(text = "ID")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.PermIdentity, contentDescription = null)
                },
                value = viewModel.id,
                onValueChange = {viewModel.id = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Ocupacion")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.PermIdentity, contentDescription = null)
                },
                value = viewModel.nombre,
                onValueChange = {viewModel.nombre = it},
                modifier = Modifier.fillMaxWidth()

            )

            Row() {
                val tag = "Row"
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(5.dp)
                ) {
                    Icon(imageVector = Icons.Default.Clear, contentDescription =null )
                    Text(text = "Nuevo")
                }

                OutlinedButton(

                    onClick = {
                        viewModel.Guardar()
                        viewModel.nombre = viewModel.limpiar
                        Mensagge(mContext)



                    }
                    ,
                    modifier = Modifier.padding(5.dp)
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription =null )
                    Text(text = "Guardar")
                }

                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(5.dp)
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription =null )
                    Text(text = "Eliminar")
                }
            }
        }
    }

}


private fun Mensagge(context: Context){
    Toast.makeText(context, "Guardado", Toast.LENGTH_SHORT).show()
}