package net.simplifiedcoding.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import net.simplifiedcoding.data.UsersDataSource
import net.simplifiedcoding.data.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: UserRepository
) : ViewModel() {

    val usersPager = Pager(
        PagingConfig(pageSize = 10)
    ) {
        UsersDataSource(repo)
    }.flow.cachedIn(viewModelScope)

}