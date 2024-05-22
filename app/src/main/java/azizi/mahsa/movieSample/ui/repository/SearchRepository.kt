package azizi.mahsa.movieSample.ui.repository

import azizi.mahsa.movieSample.ui.api.ApiServices
import javax.inject.Inject

class SearchRepository @Inject constructor(private val api: ApiServices){
    suspend fun searchMovie(name:String) = api.searchMovie(name)
}