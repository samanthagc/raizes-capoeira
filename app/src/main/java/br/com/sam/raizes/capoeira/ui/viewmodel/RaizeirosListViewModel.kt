package br.com.sam.raizes.capoeira.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.sam.raizes.capoeira.model.Raizeiro
import br.com.sam.raizes.capoeira.repository.RaizeiroRepository
import br.com.sam.raizes.capoeira.repository.Resource

class RaizeirosListViewModel(private val repository: RaizeiroRepository) : ViewModel() {

    fun getAll(): LiveData<Resource<List<Raizeiro>?>> {
        return repository.getAll()
    }

}