package com.myt.orbitalanimation.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Each Orbit's characteristics
 *
 * @param offsetDegree the start of the revolving movement will be with an offset added to 0 degrees (it can be both positive or negative)
 * @param radius the radius of the orbit in which the components move around the center
 * @param border the border characteristics of the orbit
 * @param animationDuration duration of the orbital maneuver from 0 to 365 degrees for this orbit
 * @param components the composable components that should be placed in this orbit
 * @see com.myt.orbitalanimation.data.Border
 */
data class Orbit(
    val offsetDegree: Float = 0f,
    val radius: Dp,
    val border: Border? = null,
    val animationDuration: Int = 2500,
    val components: List<@Composable () -> Unit>,
)

/**
 * Each Orbit's border characteristics
 *
 * @param width the offset that adds up to the diameter (it can be both positive or negative)
 * @param offset the offset that adds up to the diameter (it can be both positive or negative)
 * @param brush the Brush type of the orbit's border
 */
data class Border(
    val width: Dp,
    val offset: Dp = 0.dp,
    val brush: Brush
)