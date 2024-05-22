package azizi.mahsa.movieSample.ui.ui.home.adapter

import academy.nouri.s1_project.models.home.ResponseMoviesList
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import azizi.mahsa.movieSample.databinding.ItemHomeMoviesTopBinding
import coil.load
import javax.inject.Inject

class TopMovieAdapter @Inject constructor() : RecyclerView.Adapter<TopMovieAdapter.ViewHolder>() {
    private lateinit var binding: ItemHomeMoviesTopBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding =
            ItemHomeMoviesTopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(differ.currentList[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount() = 5

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun setData(item: ResponseMoviesList.Data) {
            binding.apply {
                movieNameTxt.text = item.title
                movieInfoTxt.text = "${item.imdbRating} | ${item.country}| ${item.year}"
                moviePosterImg.load(item.poster) {
                    crossfade(true)
                    crossfade(800)
                }
            }
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<ResponseMoviesList.Data>() {
        override fun areItemsTheSame(oldItem: ResponseMoviesList.Data, newItem: ResponseMoviesList.Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResponseMoviesList.Data, newItem: ResponseMoviesList.Data): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)
}