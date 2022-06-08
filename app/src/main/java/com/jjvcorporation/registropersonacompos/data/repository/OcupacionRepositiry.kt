package com.jjvcorporation.registropersonacompos.data.repository

import com.jjvcorporation.registropersonacompos.data.OcupacionDao
import com.jjvcorporation.registropersonacompos.model.Ocupacion
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OcupacionRepositiry @Inject constructor(
    val ocupacionDao: OcupacionDao
){

    suspend fun insertar(ocupacion: Ocupacion){
        ocupacionDao.insertar(ocupacion)
    }




    suspend fun Eliminar(ocupacion: Ocupacion){
        ocupacionDao.Eliminar(ocupacion)
    }

    fun buscar(ocupacionId: Int): Flow<Ocupacion>{
        return  ocupacionDao.buscar(ocupacionId)
    }

   fun GetLista(): Flow<List<Ocupacion>>{
       return ocupacionDao.GetLista()
   }
}