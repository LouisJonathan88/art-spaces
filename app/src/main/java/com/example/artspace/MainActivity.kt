package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF87CEEB)
                ) {
                    ArtSpaceMain()
                }
            }
        }
    }
}

@Composable
fun ArtWithTitle(ArtPicture: Int, ArtTitle: String, ArtistName: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = ArtPicture),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 100.dp)
                .height(300.dp)
                .width(300.dp)
                .border(border = BorderStroke(2.dp, Color.Gray), shape = RectangleShape)
                .shadow(elevation = 4.dp)
                .padding(10.dp)
        )

        Card(
            modifier = Modifier
                .padding(horizontal = 45.dp, vertical = 90.dp)
                .width(300.dp)
                .height(120.dp),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Color.LightGray)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = ArtTitle,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = ArtistName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun ArtSpaceMain(){
    var result by remember {
        mutableStateOf(1)
    }
    when (result) {
        1-> ArtWithTitle(
            ArtPicture = R.drawable.hashirama,
            ArtTitle = stringResource(R.string.hokage1),
            ArtistName = stringResource(id = R.string.hashirama)
        )
        2-> ArtWithTitle(
            ArtPicture = R.drawable.tobirama,
            ArtTitle = stringResource(R.string.hokage2),
            ArtistName = stringResource(id = R.string.tobirama)
        )
        3-> ArtWithTitle(
            ArtPicture = R.drawable.hiruzen,
            ArtTitle = stringResource(R.string.hokage3),
            ArtistName = stringResource(id = R.string.hiruzen)
        )
        4-> ArtWithTitle(
            ArtPicture = R.drawable.minato,
            ArtTitle = stringResource(R.string.hokage4),
            ArtistName = stringResource(id = R.string.minato)
        )
        else -> ArtWithTitle(
            ArtPicture = R.drawable.narutoo,
            ArtTitle = stringResource(R.string.hokage7),
            ArtistName = stringResource(id = R.string.naruto)
        )
    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 635.dp)
    ) {
        Button(
            onClick = {
                if (result >1) result--},
            shape = RoundedCornerShape(50.dp),
            border = BorderStroke(2.dp, Color.Gray),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp,
            )
        ) {
            Text(text = "Previous")
        }
        Button(
            onClick = { if (result<5) result++ },
            shape = RoundedCornerShape(50.dp),
            border = BorderStroke(2.dp, Color.Gray),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp
            )
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceMain()
    }
}