package azizi.mahsa.movieSample.ui.di

import academy.nouri.s1_project.db.MovieEntity
import academy.nouri.s1_project.db.MoviesDatabase
import android.content.Context
import androidx.room.Room
import azizi.mahsa.movieSample.ui.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, MoviesDatabase::class.java, Constants.MOVIES_DATABASE
    ).allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(db: MoviesDatabase) = db.movieDao()

    @Provides
    @Singleton
    fun provideEntity() = MovieEntity()
}