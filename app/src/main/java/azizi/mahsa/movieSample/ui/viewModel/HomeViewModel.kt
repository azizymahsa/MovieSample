package azizi.mahsa.movieSample.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import azizi.mahsa.movieSample.ui.models.home.ResponseMoviesList
import azizi.mahsa.movieSample.ui.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val topMoviesListLiveData = MutableLiveData<ResponseMoviesList>()

    fun loadTopMoviesList(id:Int) = viewModelScope.launch {
        val response = repository.topMoviesList(id)
        if (response.isSuccessfull){
            topMoviesListLiveData.postValue(response.body())
        }
    }

}