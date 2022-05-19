package com.example.learningpaging3.di.module

import android.app.Application
import com.example.learningpaging3.data.local.AppDbDao
import com.example.learningpaging3.data.local.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesAppDatabase(context: Application): AppDatabase {
        return AppDatabase.getAppDbInstance(context)
    }

    @Singleton
    @Provides
    fun providesAppDao(appDatabase: AppDatabase): AppDbDao {
        return appDatabase.getAppDao()
    }
}
