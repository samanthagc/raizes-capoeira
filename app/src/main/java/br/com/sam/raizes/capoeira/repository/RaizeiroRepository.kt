package br.com.sam.raizes.capoeira.repository

import androidx.lifecycle.LiveData
import br.com.sam.raizes.capoeira.database.dao.RaizeiroDAO
import br.com.sam.raizes.capoeira.model.Raizeiro

class RaizeiroRepository(
    private val dao: RaizeiroDAO
) {

    fun getById(raizeiroId: Long): LiveData<Raizeiro?> {
        return dao.getById(raizeiroId)
    }

    fun getAll(): LiveData<List<Raizeiro>> {
        return dao.getAll()
    }

    fun save(raizeiro: Raizeiro) {
        return dao.save(raizeiro)
    }

    fun save(raizeiros: List<Raizeiro>) {
        return dao.save(raizeiros)
    }

    fun remove(raizeiro: Raizeiro) {
        dao.remove(raizeiro)
    }

}