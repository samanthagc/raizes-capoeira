package br.com.sam.raizes.capoeira.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.sam.raizes.capoeira.database.dao.RaizeiroDAO
import br.com.sam.raizes.capoeira.model.Raizeiro

private const val DATABASE_NAME = "raizeiros.db"

@Database(entities = [Raizeiro::class], version = 1, exportSchema = false)
abstract class AppDatabase :RoomDatabase() {

    abstract val raizeiroDAO: RaizeiroDAO

    companion object {

        private lateinit var db: AppDatabase

        fun getInstance(context: Context): AppDatabase {

            if(::db.isInitialized) return db

            db = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DATABASE_NAME
            ).build()

            return db
        }

    }

}