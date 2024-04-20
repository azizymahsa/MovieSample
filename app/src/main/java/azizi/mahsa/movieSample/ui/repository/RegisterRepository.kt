package azizi.mahsa.movieSample.ui.repository

import azizi.mahsa.movieSample.ui.api.ApiServices
import azizi.mahsa.movieSample.ui.models.register.BodyRegister
import javax.inject.Inject

class RegisterRepository @Inject constructor(private val api:ApiServices) {
suspend fun registerUser(body: BodyRegister)=api.registerUser(body)
}