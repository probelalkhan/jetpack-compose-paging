package net.simplifiedcoding.data.repository

import net.simplifiedcoding.data.network.UsersResponse

interface UserRepository {

    suspend fun getUsers(page: Int, limit: Int): UsersResponse

}