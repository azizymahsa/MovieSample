package azizi.mahsa.movieSample.ui.repository

import azizi.mahsa.movieSample.ui.models.register.BodyRegister
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RegisterModule {
    @Provides
    @Singleton
    fun provideUserBody()=BodyRegister()
}