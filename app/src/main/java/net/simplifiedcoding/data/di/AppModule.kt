package net.simplifiedcoding.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.simplifiedcoding.data.network.UsersApi
import net.simplifiedcoding.data.repository.UserRepository
import net.simplifiedcoding.data.repository.UserRepositoryImpl

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideUsersApi(): UsersApi = UsersApi()

    @Provides
    fun provideUserRepository(api: UsersApi): UserRepository = UserRepositoryImpl(api)
}