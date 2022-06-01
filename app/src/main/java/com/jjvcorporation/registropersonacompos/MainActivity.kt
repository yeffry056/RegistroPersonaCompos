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
import com.jjvcorporation.registropersonacompos.util.Screen

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
            RegistroOcupaciones()
        }
        composable(route = Screen.ConsultaOcupaciones.route){
            ConsultaOcupaciones(goOcupRegistro = {navHostController.navigate(Screen.RegistroOcupaciones.route)})
        }
    }

}

@Composable
fun RegistroPerson(){
    
    var persona by rememberSaveable() {
        mutableStateOf("")
    }
    
    Column(modifier = Modifier.padding(8.dp)) {
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
@Composable
fun ConsultaPerson(goRegistro : () -> Unit, goOcupacion : () -> Unit){

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Consulta Persona")})
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

        Column(modifier = Modifier.padding(8.dp)) {
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

@Composable
fun RowNombre(nombre: String) {
    Row() {
        Text("El nombre es: $nombre")
    }
}

@Composable
fun RegistroOcupaciones(){
    
    
    Column(modifier = Modifier.padding(8.dp)) {
        
        OutlinedTextField(
            label = {
                Text(text = "ID")
            },
            leadingIcon = {
                          Icon(imageVector = Icons.Default.PermIdentity, contentDescription = null)
            },
            value = "", 
            onValueChange = {},
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            label = {
                Text(text = "Ocupacion")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.PermIdentity, contentDescription = null)
            },
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth()
        )
        
        Row() {
            
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

                },
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
@Composable
fun ConsultaOcupaciones(goOcupRegistro : () -> Unit){

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Listado de Ocupaciones")})
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


        Column(modifier = Modifier.padding(8.dp)) {

            val ocup = listOf("Bombero","Dentista", "Enfermera","Medico")
            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(ocup){ocupaciones->
                    RowOcupaciones(ocupaciones)
                }
            }
        }
    }
    


}

@Composable
fun RowOcupaciones(ocupaciones: String){
    Row() {
        Text("La ocupacion es: $ocupaciones")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    RegistroPersonaComposTheme {
        MyApp()
    }
}