package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.GreenDark
import com.example.myapplication.ui.theme.GreenDeep
import com.example.myapplication.ui.theme.GreenLight
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Pink40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PresentationCard(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PresentationCard(modifier: Modifier = Modifier) {
    // contenedor principal
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(GreenLight) // Color de fondo general
    ) {
        // sección con imagen y nombre, centrada
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // logo
            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = stringResource(R.string.description_logo),
                modifier = Modifier
                    .size(100.dp)
                    .background(GreenDark)
                    .padding(10.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // nombre
            Text(
                text = stringResource(R.string.name),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = GreenDark,
                textAlign = TextAlign.Center
            )

            //descripción de profecion
            Text(
                text = stringResource(R.string.profetion_text),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = GreenDeep,
                textAlign = TextAlign.Center
            )
        }

        // footer fijo: datos de contacto
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter) // Posiciona el bloque al fondo de la pantalla
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally // Centra el bloque completo
        ) {
            // Cada fila está alineada a la izquierda dentro de un bloque centrado y cada bloque tiene un tamano predeterminado igual
            ContactRowLeftAligned(Icons.Default.Phone, text = stringResource(R.string.number_phone_txt))
            ContactRowLeftAligned(Icons.Default.Share, text = stringResource(R.string.social_media_text))
            ContactRowLeftAligned(Icons.Default.Email, text = stringResource(R.string.email_text))
        }
    }
}

@Composable
fun ContactRowLeftAligned(icon: ImageVector, text: String) {
    // Fila con ancho fijo para lograr que el contenido se vea centrado como bloque,
    // pero alineado a la izquierda dentro de ese bloque
    Row(
        modifier = Modifier.width(180.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text, // Mejora accesibilidad
            tint = GreenDark,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            color = GreenDark
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PresentationCardPreview() {
    MyApplicationTheme {
        PresentationCard()
    }
}