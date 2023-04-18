package com.ramalxmangroup.practice_compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ramalxmangroup.practice_compose.ui.theme.Practice_composeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
/*            val painter = painterResource(id = R.drawable.img)
            val description = "Oh wow it's working"
            val title = "Thankful to God"
            Box(modifier = Modifier
                .fillMaxSize(0.8f)
                .padding(16.dp))
            { ImageCard(painter = painter, contentDescription = description, title = title) }*/
/*            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .padding(10.dp)
                    .border(1.dp, Color.Black, RectangleShape)
            ){
                Text(text = "Hello")
                Text(text = "Word", modifier = Modifier
                    .offset(10.dp, 20.dp)
                    .border(1.dp, Color.Black, RectangleShape)
                )
            }*/

           /* Column(Modifier.fillMaxSize()) {
                val color = remember{ mutableStateOf(Color.Yellow) }
                ColorBox(
                    Modifier
                        .weight(1f)
                        .fillMaxSize()

                ){
                    color.value=it
                }

                Box(modifier = Modifier
                    .background(color.value)
                    .weight(1f)
                    .fillMaxSize())
            }*/
            LazyColumn{
                items(500){
                    Text(text = "check $it")
                }
            }
        }
    }
}
@Composable
fun ImageCard(
    painter: Painter,
    contentDescription:String,
    title:String,
    modifier: Modifier=Modifier
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier=Modifier.height(300.dp)) {
            Image(painter = painter, contentDescription = contentDescription, contentScale = ContentScale.Crop)
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ), startY = 300f
                    )
                ))
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            contentAlignment = Alignment.BottomStart){
                Text(text = buildAnnotatedString {
                                                 withStyle(style = SpanStyle(
                                                     color=Color.Green,
                                                     fontStyle = FontStyle.Italic,
                                                     fontSize =50.sp)){
                                                     append("J")
                                                 }
                    append("etpack")
                    withStyle(style = SpanStyle(
                                                     color=Color.Green,                                                     fontStyle = FontStyle.Italic,

                        fontSize =50.sp)){
                                                     append("C")
                                                 }
                    append("compose")
                }, style = TextStyle(color = Color.White, fontSize = 30.sp))
            }
        }
    }
}
@Composable
fun ColorBox(modifier: Modifier=Modifier,updateColor: (Color)->Unit){
    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), Random.nextFloat(),
                )
            )
        })
}

