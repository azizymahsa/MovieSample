package academy.nouri.s1_project.db

import androidx.room.*
import azizi.mahsa.movieSample.ui.utils.Constants
import retrofit2.http.DELETE

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(entity: MovieEntity)

    @Delete
    suspend fun deleteMovie(entity: MovieEntity)

    @Query("SELECT * FROM ${Constants.MOVIES_TABLE}")
    fun getAllMovies(): MutableList<MovieEntity>

    @Query("SELECT EXISTS (SELECT 1 FROM ${Constants.MOVIES_TABLE} WHERE id = :movieId)")
    suspend fun existsMovie(movieId: Int): Boolean
}