package br.com.sam.raizes.capoeira.repository

class Resource<T>(
    val data: T?,
    val error: String? = null
)