package net.simplifiedcoding.data.repository

import net.simplifiedcoding.data.network.UsersApi
import net.simplifiedcoding.data.network.UsersResponse

class UserRepositoryImpl(
    private val api: UsersApi
) : UserRepository {

    override suspend fun getUsers(page: Int, limit: Int): UsersResponse {
        return api.getUsers(page, limit)
    }
}