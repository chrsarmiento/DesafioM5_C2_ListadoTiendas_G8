package com.desafiolatam.listadodetiendas.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafiolatam.listadodetiendas.data.StoreRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class StoreViewModel: ViewModel() {

    private val repository : StoreRepository = StoreRepository()

    suspend fun getStoreList(): StateFlow<List<Store>> = repository.getStoreList().stateIn(viewModelScope)

    suspend fun getStoreById(storeId: Int) : StateFlow<Store?> = repository.getStoreById(storeId).stateIn(viewModelScope)
}