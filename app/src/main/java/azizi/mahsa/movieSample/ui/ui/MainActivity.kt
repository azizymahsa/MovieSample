package azizi.mahsa.movieSample.ui.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import azizi.mahsa.movieSample.R
import azizi.mahsa.movieSample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    //Binding
    private lateinit var binding: ActivityMainBinding

    //Other
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //InitViews
        binding.apply {
            //Navigation
            navController = findNavController(R.id.navHost)
            bottomNav.setupWithNavController(navController)
            //show bottom navigation
            navController.addOnDestinationChangedListener { _, destination, _ ->
                if(destination.id==R.id.splashFragment || destination.id == R.id.registerFragment){
                    bottomNav.visibility = View.GONE
                }else{
                    bottomNav .visibility=View.VISIBLE
                }
            }
        }
    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp() || super.onNavigateUp()
    }
}