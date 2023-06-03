package com.myt.orbitalanimationtestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.myt.orbitalanimation.OrbitalAnimatedComponents
import com.myt.orbitalanimation.data.Border
import com.myt.orbitalanimation.data.Orbit

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Black
            ) {
                OrbitalAnimatedComponents(
                    modifier = Modifier,
                    orbits = listOf(

                        Orbit(radius = 30.dp,
                            offsetDegree = 10f,
                            animationDuration = 2000,
                            components = listOf(
                                { ColoredCircle(Color.DarkGray) },
                                { ColoredCircle(Color.Red) },
                                { ColoredCircle(Color.Blue) }
                            )
                        ),

                        Orbit(radius = 70.dp,
                            animationDuration = 5000,
                            components = listOf(
                                { ColoredCircle(Color.Gray) },
                                { ColoredCircle(Color.Green) },
                                { ColoredCircle(Color.Magenta) },
                                { ColoredCircle(Color.Cyan) }
                            )
                        ),

                        Orbit(radius = 150.dp,
                            animationDuration = 10000,
                            border = Border(
                                width = 2.dp,
                                brush = Brush.horizontalGradient(
                                    listOf(
                                        Color.Green,
                                        Color.Blue,
                                        Color.Red
                                    )
                                )
                            ),
                            components = listOf(
                                { ColoredCircle(Color.Gray) },
                                { ColoredCircle(Color.Green) },
                                { ColoredCircle(Color.Magenta) },
                                { ColoredCircle(Color.Cyan) },
                                { ColoredCircle(Color.DarkGray) },
                                { ColoredCircle(Color.Red) }
                            )
                        ),

                        Orbit(radius = 180.dp,
                            animationDuration = 10000,
                            border = Border(width = 2.dp, brush = SolidColor(Color.Black)),
                            components =
                            (0..30).map {
                                { ColoredCircle(Color.Black) }
                            }
                        )

                    )
                )
            }
        }
    }
}


@Composable
fun ColoredCircle(color: Color = Color.Black) {
    Box(
        modifier = Modifier
            .size(20.dp)
            .shadow(2.dp, CircleShape)
            .clip(CircleShape)
            .background(color)
    )
}