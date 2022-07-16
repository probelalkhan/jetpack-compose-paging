package net.simplifiedcoding.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import net.simplifiedcoding.data.network.User
import net.simplifiedcoding.data.repository.UserRepository

class UsersDataSource(
    private val repo: UserRepository
) : PagingSource<Int, User>() {

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return try {
            val page = params.key ?: 1
            val response = repo.getUsers(page, 10)
            LoadResult.Page(
                data = response.users,
                prevKey = null,
                nextKey = if(response.users.isNotEmpty()) response.page + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}