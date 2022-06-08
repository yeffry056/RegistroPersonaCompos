package com.jjvcorporation.registropersonacompos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jjvcorporation.registropersonacompos.ui.theme.RegistroPersonaComposTheme
import java.io.File
import androidx.compose.material.Icon
import com.jjvcorporation.registropersonacompos.model.Ocupacion
import com.jjvcorporation.registropersonacompos.ui.ocupacion.ConsultaOcupaciones
import com.jjvcorporation.registropersonacompos.ui.ocupacion.RegistroOcupaciones
import com.jjvcorporation.registropersonacompos.ui.persona.ConsultaPerson
import com.jjvcorporation.registropersonacompos.ui.persona.RegistroPerson
import com.jjvcorporation.registropersonacompos.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistroPersonaComposTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Screen.ConsultaPerson.route){
        composable(route = Screen.ConsultaPerson.route){
            ConsultaPerson(goRegistro = {navHostController.navigate(Screen.RegistroPerson.route)}, goOcupacion = {navHostController.navigate(Screen.ConsultaOcupaciones.route)})
        }
        composable(route = Screen.RegistroPerson.route){
            RegistroPerson()
        }
        composable(route = Screen.RegistroOcupaciones.route){
            RegistroOcupaciones()//OJo
        }
        composable(route = Screen.ConsultaOcupaciones.route){
            ConsultaOcupaciones(goOcupRegistro = { navHostController.navigate(Screen.RegistroOcupaciones.route) })
        }
    }

}




@Composable
fun RowNombre(nombre: String) {
    Row() {
        Text("El nombre es: $nombre")
    }
}




@Composable
fun RowOcupaciones(ocupacion: Ocupacion){
    Row() {
        Text(ocupacion.ocupaciones)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    RegistroPersonaComposTheme {
        MyApp()
    }
}