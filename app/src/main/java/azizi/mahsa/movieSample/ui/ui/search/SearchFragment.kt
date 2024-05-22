package azizi.mahsa.movieSample.ui.ui.search

import academy.nouri.s1_project.ui.home.adapters.LastMoviesAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import azizi.mahsa.movieSample.databinding.FragmentSearchBinding
import azizi.mahsa.movieSample.ui.ui.detail.initRecycler
import azizi.mahsa.movieSample.ui.utils.showInvisible
import azizi.mahsa.movieSample.ui.viewModel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment() {
    //Binding
    private lateinit var binding: FragmentSearchBinding

    @Inject
    lateinit var searchAdapter: LastMoviesAdapter

    //Other
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //InitViews
        binding.apply {
            //Search
            searchEdt.addTextChangedListener {
                val search = it.toString()
                if (search.isNotEmpty()) {
                    viewModel.loadSearchMovies(search)
                }
            }
            //Get movies list
            viewModel.moviesList.observe(viewLifecycleOwner) {
                searchAdapter.setData(it.data)
                moviesRecycler.initRecycler(LinearLayoutManager(requireContext()), searchAdapter)
            }
            //Click
            searchAdapter.setOnItemClickListener {
                val direction = SearchFragmentDirections.actionToDetail(it.id!!.toInt())
                findNavController().navigate(direction)
            }
            //Loading
            viewModel.loading.observe(viewLifecycleOwner) {
                if (it) {
                    searchLoading.showInvisible(true)
                } else {
                    searchLoading.showInvisible(false)
                }
            }
            //Empty items
            viewModel.empty.observe(viewLifecycleOwner) {
                if (it) {
                    emptyItemsLay.showInvisible(true)
                    moviesRecycler.showInvisible(false)
                } else {
                    emptyItemsLay.showInvisible(false)
                    moviesRecycler.showInvisible(true)
                }
            }
        }
    }
}