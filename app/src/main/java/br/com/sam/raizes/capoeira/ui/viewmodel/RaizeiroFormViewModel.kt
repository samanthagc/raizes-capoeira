package br.com.sam.raizes.capoeira.ui.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.sam.raizes.capoeira.R
import br.com.sam.raizes.capoeira.model.Raizeiro
import br.com.sam.raizes.capoeira.repository.RaizeiroRepository

class RaizeiroFormViewModel(
    private val repository: RaizeiroRepository
) : ViewModel() {

    fun save(raizeiro: Raizeiro): LiveData<Void?> {
        return repository.save(raizeiro)
    }

}