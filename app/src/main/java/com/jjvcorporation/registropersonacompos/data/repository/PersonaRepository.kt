package com.jjvcorporation.registropersonacompos.data.repository


import com.jjvcorporation.registropersona.data.PersonaDao
import com.jjvcorporation.registropersonacompos.model.Persona
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PersonaRepository @Inject constructor(
    val personaDao: PersonaDao
){

    suspend fun Insertar(persona: Persona){
        personaDao.Insertar(persona)
    }


    suspend fun Eliminar(persona: Persona){
        personaDao.Eliminar(persona)
    }

    fun buscar(personaId: Int): Flow<Persona>{
        return personaDao.buscar(personaId)
    }

    fun GetLista(): Flow<List<Persona>>{
       return personaDao.GetLista()
    }
}