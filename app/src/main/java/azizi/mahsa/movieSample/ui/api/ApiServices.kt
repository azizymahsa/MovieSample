package azizi.mahsa.movieSample.ui.api

import azizi.mahsa.movieSample.ui.models.home.ResponseMoviesList
import azizi.mahsa.movieSample.ui.models.register.BodyRegister
import azizi.mahsa.movieSample.ui.models.register.ResponseRegister
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiServices {
    @POST("register")
    suspend fun registerUser(@Body body: BodyRegister): Response<ResponseRegister>

    @GET("genres/{genre_id}/movies")
    suspend fun moviesTopList(@Path("genre_id") id: Int): Response<ResponseMoviesList>
}