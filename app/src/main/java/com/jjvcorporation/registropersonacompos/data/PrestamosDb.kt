package com.jjvcorporation.registropersonacompos.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jjvcorporation.registropersona.data.PersonaDao
import com.jjvcorporation.registropersonacompos.model.Ocupacion
import com.jjvcorporation.registropersonacompos.model.Persona

@Database(
    entities = [
        Ocupacion::class,
        Persona::class
    ],
    exportSchema = false,
    version = 1
)
abstract class PrestamosDb: RoomDatabase() {
    abstract val ocupacionDao: OcupacionDao
    abstract val personaDao: PersonaDao
}