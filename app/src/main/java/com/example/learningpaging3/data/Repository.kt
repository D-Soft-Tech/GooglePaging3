package com.example.learningpaging3.data

import androidx.paging.PagingSource
import com.example.learningpaging3.data.local.AppDbDao
import com.example.learningpaging3.model.CharacterData
import javax.inject.Inject

class Repository @Inject constructor(private val appDbDao: AppDbDao) {
    fun getAllRecords(): PagingSource<Int, CharacterData> {
        return appDbDao.getAllRecords()
    }

    fun insertRecords(characterData: CharacterData) {
        appDbDao.insetRecord(characterData)
    }
}