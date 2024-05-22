package azizi.mahsa.movieSample.ui.api

import academy.nouri.s1_project.models.home.ResponseGenresList
import academy.nouri.s1_project.models.home.ResponseMoviesList
import azizi.mahsa.movieSample.ui.models.detail.ResponseDetail
import azizi.mahsa.movieSample.ui.models.register.BodyRegister
import azizi.mahsa.movieSample.ui.models.register.ResponseRegister
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServices {
    @POST("register")
    suspend fun registerUser(@Body body: BodyRegister): Response<ResponseRegister>

    @GET("genres/{genre_id}/movies")
    suspend fun moviesTopList(@Path("genre_id") id: Int): Response<ResponseMoviesList>

    @GET("genres")
    suspend fun genresList(): Response<ResponseGenresList>

    @GET("movies")
    suspend fun moviesLastList(): Response<ResponseMoviesList>

    @GET("movies")
    suspend fun searchMovie(@Query("q") name: String): Response<ResponseMoviesList>

    @GET("movies/{movie_id}")
    suspend fun detailMovie(@Path("movie_id") id: Int): Response<ResponseDetail>
}