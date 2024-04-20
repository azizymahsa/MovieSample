package azizi.mahsa.movieSample.ui.api

import azizi.mahsa.movieSample.ui.models.register.BodyRegister
import azizi.mahsa.movieSample.ui.models.register.ResponseRegister
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServices {
    @POST("register")
    suspend fun registerUser(@Body body: BodyRegister): Response<ResponseRegister>
}