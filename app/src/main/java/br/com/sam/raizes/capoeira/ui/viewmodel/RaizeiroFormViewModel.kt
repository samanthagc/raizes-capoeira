package br.com.sam.raizes.capoeira.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.sam.raizes.capoeira.model.Raizeiro
import br.com.sam.raizes.capoeira.repository.RaizeiroRepository
import br.com.sam.raizes.capoeira.repository.Resource

class RaizeiroFormViewModel(
    private val repository: RaizeiroRepository
) : ViewModel() {

    fun save(raizeiro: Raizeiro): LiveData<Resource<Void?>> {
        return repository.save(raizeiro)
    }

    fun getById(id: Long) = repository.getById(id)

}