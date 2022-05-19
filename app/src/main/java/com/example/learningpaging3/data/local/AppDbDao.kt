package com.example.learningpaging3.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learningpaging3.model.CharacterData

@Dao
interface AppDbDao {
    @Query("SELECT * FROM character ORDER BY id DESC")
    fun getAllRecords(): PagingSource<Int, CharacterData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insetRecord(characterData: CharacterData)
}
