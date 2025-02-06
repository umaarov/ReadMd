package uz.umarov.readmd.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.umarov.readmd.data.remote.GitHubApiService

class GitHubRepository(private val api: GitHubApiService) {
    fun fetchMarkdown(): Flow<String> = flow {
        emit(api.getMarkdown())
    }
}