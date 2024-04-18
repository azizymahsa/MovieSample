package azizi.mahsa.movieSample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import azizi.mahsa.movieSample.databinding.ActivityMainBinding


import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity() {
    //Binding
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //InitViews
        binding.apply {

        }
    }
}