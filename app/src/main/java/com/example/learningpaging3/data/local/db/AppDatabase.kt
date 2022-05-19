package com.example.learningpaging3.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.learningpaging3.data.local.AppDbDao
import com.example.learningpaging3.model.CharacterData
import com.example.learningpaging3.util.AppConstants.APP_DB

@Database(entities = [CharacterData::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getAppDao(): AppDbDao
    companion object {
        private var DB_INSTANCE: AppDatabase? = null
        fun getAppDbInstance(context: Context): AppDatabase {
            if (DB_INSTANCE == null) {
                DB_INSTANCE = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, APP_DB
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return DB_INSTANCE!!
        }
    }
}
