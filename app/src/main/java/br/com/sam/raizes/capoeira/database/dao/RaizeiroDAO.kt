package br.com.sam.raizes.capoeira.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.com.sam.raizes.capoeira.model.Raizeiro

@Dao
interface RaizeiroDAO {

    @Query("SELECT * FROM Raizeiro ORDER BY id DESC")
    fun getAll(): LiveData<List<Raizeiro>>

    @Insert(onConflict = REPLACE)
    fun save(raizeiro: Raizeiro)

    @Insert(onConflict = REPLACE)
    fun save(raizeiros: List<Raizeiro>)

    @Delete
    fun remove(raizeiro: Raizeiro)

    @Query("SELECT * FROM Raizeiro WHERE id = :id")
    fun getById(id: Long): LiveData<Raizeiro?>

}