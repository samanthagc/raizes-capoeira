package br.com.sam.raizes.capoeira.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.sam.raizes.capoeira.repository.RaizeiroRepository
import br.com.sam.raizes.capoeira.ui.viewmodel.RaizeirosListViewModel

class RaizeirosListViewModelFactory(private val repository: RaizeiroRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = RaizeirosListViewModel(repository) as T

}