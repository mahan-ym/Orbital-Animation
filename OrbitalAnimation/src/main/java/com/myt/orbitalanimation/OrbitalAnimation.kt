package com.myt.orbitalanimation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.Color
import com.myt.orbitalanimation.data.Border
import com.myt.orbitalanimation.data.Orbit
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

/**
 * this composable function create a beautiful orbital animation of the components
 *
 * @param modifier default modifier of the parent component
 * @param orbits a list of orbits with Orbit class characteristics
 * @see com.myt.orbitalanimation.data.Orbit
 */
@Composable
fun OrbitalAnimatedComponents(
    modifier: Modifier,
    orbits: List<Orbit>,
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        orbits.forEach { orbit ->
            if (orbit.border != null)
                OrbitLine(orbit.border, orbit.radius)

            val positionState = rememberInfiniteTransition().animateFloat(
                initialValue = orbit.offsetDegree,
                targetValue = orbit.offsetDegree + (2 * PI).toFloat(),
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = orbit.animationDuration,
                        easing = LinearEasing
                    )
                )
            )

            val numOfComponents = orbit.components.size
            val degreeOffset = (2 * PI.toFloat() / numOfComponents)

            orbit.components.forEachIndexed { index, component ->
                val componentModifier = Modifier.offset(
                    x = -orbit.radius * cos(positionState.value + index * degreeOffset),
                    y = orbit.radius * sin(positionState.value + index * degreeOffset),
                )
                Box(modifier = componentModifier, content = { component.invoke() })
            }

        }
    }
}

@Composable
private fun OrbitLine(border: Border, radius:Dp) {
    Box(modifier = Modifier.size(radius.times(2).plus(border.offset)).clip(CircleShape).background(Color.Transparent).border(border.width, border.brush, CircleShape))
}