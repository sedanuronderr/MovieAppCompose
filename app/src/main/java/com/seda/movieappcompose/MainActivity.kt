package com.seda.movieappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.seda.movieappcompose.presentation.movie_detail.views.MovieDetailScreen
import com.seda.movieappcompose.presentation.movie_list.views.MovieScreen
import com.seda.movieappcompose.presentation.ui.theme.MovieAppComposeTheme
import com.seda.movieappcompose.util.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
SayfaGecisleri()
                }
            }
        }
    }
}
@Composable
fun SayfaGecisleri(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "movie_screen"){
        composable("movie_screen"){
           MovieScreen(navController = navController)
        }
        composable("movie_detail_screen"+ "/{${Constants.IMDB_ID}}")
           {

            MovieDetailScreen(navController = navController)
        }


    }



}

