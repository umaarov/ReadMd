package uz.umarov.readmd.data.remote

import retrofit2.http.GET

interface GitHubApiService {
    @GET("umaarov/markdowns/master/demo.md")
    suspend fun getMarkdown(): String
}