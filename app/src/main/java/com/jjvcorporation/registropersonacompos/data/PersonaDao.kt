package com.jjvcorporation.registropersona.data

import androidx.room.*
import com.jjvcorporation.registropersonacompos.model.Persona
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertar(persona: Persona)

    @Delete
    suspend fun Eliminar(persona: Persona)

    @Query("SELECT * FROM Personas WHERE personaId = :personaId")
    fun buscar(personaId: Int): Flow<Persona>

    @Query("SELECT * FROM Personas ORDER BY PersonaId")
    fun GetLista(): Flow<List<Persona>>

    //@Query("SELECT * FROM Personas WHERE Int ID == PersonaId")
}