package azizi.mahsa.movieSample.ui.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import azizi.mahsa.movieSample.R
import azizi.mahsa.movieSample.databinding.ActivityMainBinding
import azizi.mahsa.movieSample.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    //Binding
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}