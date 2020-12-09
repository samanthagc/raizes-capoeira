package br.com.sam.raizes.capoeira.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Raizeiro(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val nickname: String = "",
    val name: String = "",
    val graduation: String = "Iniciante"
)