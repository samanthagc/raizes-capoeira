package br.com.sam.raizes.capoeira.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.sam.raizes.capoeira.asynctask.BaseAsyncTask
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

    fun save(raizeiro: Raizeiro): LiveData<Void?> {
        val liveData = MutableLiveData<Void?>()
        saveLocal(raizeiro, whenSucess = {
            liveData.value = null
        })
        return liveData
    }

    private fun saveLocal(
        raizeiro: Raizeiro,
        whenSucess: () -> Unit
    ) {
        BaseAsyncTask(whenPerforms = {
            dao.save(raizeiro)
        }, whenEnds = {
            whenSucess()
        }).execute()
    }

    private fun saveLocal(raizeiros: List<Raizeiro>, whenSucess: () -> Unit) {
        BaseAsyncTask(whenPerforms = {
            dao.save(raizeiros)
        }, whenEnds = {
            whenSucess()
        }).execute()
    }

    private fun removeLocal(raizeiro: Raizeiro, whenSucess: () -> Unit) {
        BaseAsyncTask(whenPerforms = {
            dao.remove(raizeiro)
        }, whenEnds = {
            whenSucess()
        }).execute()
    }

}