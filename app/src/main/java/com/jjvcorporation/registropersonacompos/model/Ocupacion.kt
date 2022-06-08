package com.jjvcorporation.registropersonacompos.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.security.interfaces.DSAKeyPairGenerator

@Entity(tableName = "Ocupaciones")
data class Ocupacion(
   @PrimaryKey(autoGenerate = true)
   val ocupacionId: Int ,
   val ocupaciones: String

)




