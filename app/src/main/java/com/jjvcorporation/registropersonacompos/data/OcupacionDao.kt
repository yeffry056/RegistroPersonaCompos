package com.jjvcorporation.registropersonacompos.data

import androidx.room.*

import com.jjvcorporation.registropersonacompos.model.Ocupacion
import kotlinx.coroutines.flow.Flow

@Dao
interface OcupacionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(ocupacion: Ocupacion)


    @Delete
    suspend fun Eliminar(ocupacion: Ocupacion)

    //@Query("SELECT * FROM Ocupaciones WHERE ocupacionId = :ocupacionId")

    @Query(
        """
        SELECT * 
        FROM Ocupaciones
        WHERE ocupacionId=:ocupacionId
    """
    )
    fun buscar(ocupacionId: Int): Flow<Ocupacion>

    //@Query("SELECT * FROM Ocupaciones ORDER BY ocupacionId")

    @Query(
        """
        SELECT * 
        FROM Ocupaciones
        ORDER BY ocupacionId    
    """
    )
    fun GetLista(): Flow<List<Ocupacion>>
}