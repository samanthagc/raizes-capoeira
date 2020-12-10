package br.com.sam.raizes.capoeira.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.sam.raizes.capoeira.repository.RaizeiroRepository
import br.com.sam.raizes.capoeira.ui.viewmodel.RaizeiroFormViewModel

class RaizeiroFormViewModelFactory(private val repository: RaizeiroRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = RaizeiroFormViewModel(repository) as T

}