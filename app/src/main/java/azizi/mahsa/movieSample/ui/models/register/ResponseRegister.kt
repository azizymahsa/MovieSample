package azizi.mahsa.movieSample.ui.models.register

import com.google.gson.annotations.SerializedName

data class ResponseRegister(
    @SerializedName("created_at")
    val created_at: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("updated_at")
    val updatedAt: String
)