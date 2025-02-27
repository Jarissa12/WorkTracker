package edu.ucne.worktracker.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.ucne.worktracker.data.local.WorkTrackerDb
import javax.inject.Singleton


    @Module
    @InstallIn(SingletonComponent::class)
    object AppModule {

        @Singleton
        @Provides
        fun providesDatabase(@ApplicationContext context: Context): WorkTrackerDb {
            return Room.databaseBuilder(
                context,
                WorkTrackerDb::class.java,
                "WorkTrackerDb.db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        @Singleton
        @Provides
        fun providesMaterialDao(db: WorkTrackerDb) = db.materialDao
        @Singleton
        @Provides
        fun providesObraDao(db: WorkTrackerDb) = db.obraDao

        //  @Provides
        //   fun providesMoshi(): Moshi {
        //      return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        //  }

        //  @Singleton
        //  @Provides
        //  fun providesWorkTrackerApi(moshi: Moshi): WorkTickerApi {
        //       return Retrofit.Builder()
        //          .baseUrl("https://worktrackerapi1.azurewebsites.ne")
        //          .addConverterFactory(MoshiConverterFactory.create(moshi))
        //          .build()
        //          .create(WorkTickerApi::class.java)
        //  }


    }

