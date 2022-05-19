package com.example.learningpaging3.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.learningpaging3.data.Repository
import com.example.learningpaging3.model.CharacterData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getAllRecords(): Flow<PagingData<CharacterData>> {
        return Pager(
            config = PagingConfig(20, 200),
            pagingSourceFactory = { repository.getAllRecords() }
        ).flow.cachedIn(viewModelScope)
    }

    fun insertDummyRecords() {
        (1..500).forEach {
            repository.insertRecords(CharacterData(0, "Dummy Data ==> $it"))
        }
    }
}
