package br.com.sam.raizes.capoeira.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import br.com.sam.raizes.capoeira.asynctask.BaseAsyncTask
import br.com.sam.raizes.capoeira.database.dao.RaizeiroDAO
import br.com.sam.raizes.capoeira.model.Raizeiro

class RaizeiroRepository(
    private val dao: RaizeiroDAO
) {

    private val mediator = MediatorLiveData<Resource<List<Raizeiro>?>>()

    fun getAll(): LiveData<Resource<List<Raizeiro>?>> {
        mediator.addSource(getAllLocal()) { raizeirosFound ->
            mediator.value = Resource(data = raizeirosFound)
        }
        return mediator
    }

    fun save(raizeiro: Raizeiro): LiveData<Resource<Void?>> {
        val liveData = MutableLiveData<Resource<Void?>>()
        saveLocal(raizeiro, whenSucess = {
            liveData.value = Resource(null)
        })
        return liveData
    }

    fun remove(raizeiro: Raizeiro): LiveData<Resource<Void?>> {
        val liveData = MutableLiveData<Resource<Void?>>()
        removeLocal(raizeiro, whenSucess = {
            liveData.value = Resource(null)
        })
        return liveData
    }

    fun getById(raizeiroId: Long): LiveData<Raizeiro?> {
        return dao.getById(raizeiroId)
    }

    private fun getAllLocal(): LiveData<List<Raizeiro>> {
        return dao.getAll()
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