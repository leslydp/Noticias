package com.orlandev.noticias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.orlandev.noticias.ui.theme.NoticiasTheme
import com.orlandev.noticias.viewModel.NoticiasViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoticiasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NoticiasScreen()
                }
            }
        }
    }
}

@Composable
fun NoticiasScreen(noticiasViewModel: NoticiasViewModel = hiltViewModel()) {
   val stateData= noticiasViewModel.data.collectAsState(null)

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoticiasTheme {
        NoticiasScreen( )
    }
}