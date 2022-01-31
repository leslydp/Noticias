package com.orlandev.noticias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val stateData = noticiasViewModel.data.collectAsState(null)

    stateData.value?.let { news ->
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(news.hits) { newsInfo ->

                NoticiasItem(newsInfo.title ?: "", newsInfo.created_at, newsInfo.author)
            }
        }
    }
}

@Composable
fun NoticiasItem(title: String = "titulo", fecha: String = "fecha", autor: String = "autor") {
    Card(
        elevation = 8.dp,
        shape = RoundedCornerShape(20),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = fecha)
            Text(text = autor)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoticiasTheme {
        NoticiasScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun NoticiasItemPreview() {
    NoticiasTheme {
        NoticiasItem()
    }
}