package com.jjvcorporation.registropersona.di

import android.content.Context
import androidx.room.Room
import com.jjvcorporation.registropersona.data.PersonaDao
import com.jjvcorporation.registropersonacompos.data.OcupacionDao
import com.jjvcorporation.registropersonacompos.data.PrestamosDb
import com.jjvcorporation.registropersonacompos.data.repository.OcupacionRepositiry
import com.jjvcorporation.registropersonacompos.data.repository.PersonaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun ProviePersonasDb(@ApplicationContext appContext: Context):PrestamosDb
    {
        return Room.databaseBuilder(
            appContext,
            PrestamosDb::class.java,
            "PrestamosDb")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun ProvidePersonaDao(prestamosDb: PrestamosDb): PersonaDao{
        return  prestamosDb.personaDao
    }

    @Provides
    fun ProvideOcupacionDao(prestamosDb: PrestamosDb): OcupacionDao{
        return  prestamosDb.ocupacionDao
    }

    @Provides
    fun ProvidesOcupacionRepository(ocupacionDao: OcupacionDao) : OcupacionRepositiry{
        return OcupacionRepositiry(ocupacionDao)
    }

    @Provides
    fun ProvidesPersonaRepository(personaDao: PersonaDao) : PersonaRepository{
        return PersonaRepository(personaDao)
    }
}