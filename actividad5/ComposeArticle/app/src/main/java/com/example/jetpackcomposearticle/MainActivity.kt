package com.example.jetpackcomposearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposearticle.ui.theme.JetpackComposeArticleTheme
import com.example.jetpackcomposearticle.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticleScreen()
                }
            }
        }
    }
}


@Composable
fun ComposeArticleScreen(modifier: Modifier = Modifier){
    Column {
        // Imagen: ocupa todo el ancho
        Image(
            painterResource(R.drawable.bg_compose_background),
            contentDescription = null
        )
        // Título: 24sp, padding 16dp
        Text(
            stringResource(R.string.title_text),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        // Primer párrafo: tamaño predeterminado, padding inicio y fin, justificado
        Text(
            stringResource(R.string.paragraph1_text),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 8.dp, bottom = 8.dp),
            textAlign = TextAlign.Justify
        )
        // Segundo párrafo: padding 16dp, justificado
        Text(
            stringResource(R.string.paragraph2_text),
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
        // autor
        Text(
            stringResource(R.string.autor_text),
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End),
            color = Red80,

        )
    }

}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    JetpackComposeArticleTheme {
        ComposeArticleScreen()
    }
}