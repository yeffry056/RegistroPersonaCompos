package com.jjvcorporation.registropersonacompos.util

sealed class Screen(val route: String) {
    object RegistroPerson : Screen("RegistroPersona")
    object ConsultaPerson : Screen("ConsultaPersona")
    object ConsultaOcupaciones : Screen("ConsultaOcupaciones")
    object RegistroOcupaciones : Screen("RegistroOcupaciones")
}