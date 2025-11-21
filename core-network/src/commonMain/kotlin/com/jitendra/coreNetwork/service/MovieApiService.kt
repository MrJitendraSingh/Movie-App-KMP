package com.jitendra.coreNetwork.service

import com.jitendra.coreNetwork.model.MovieDTO
import com.jitendra.coreNetwork.model.MovieDetailsResponse
import com.jitendra.coreNetwork.model.SearchResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MovieApiService (private val client: HttpClient) {

    suspend fun searchMovies(query: String): Result<List<MovieDTO>> {
        return try {
            val searchResponse = client.get("3/search/movie"){
                parameter("query", query)
            }.body<SearchResponse>()
            Result.success(searchResponse.results)
        }catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getMovieDetails(movieId: String): Result<MovieDetailsResponse> {
        return try {
            val movie = client.get("3/movie/${movieId}").body<MovieDetailsResponse>()
            Result.success(movie)
        }catch (e: Exception) {
            Result.failure(e)
        }
    }
}