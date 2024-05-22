package azizi.mahsa.movieSample.ui.repository

import academy.nouri.s1_project.db.MoviesDao
import javax.inject.Inject

class FavoriteRepository @Inject constructor(private val dao: MoviesDao) {

    fun allFavoriteList() = dao.getAllMovies()
}