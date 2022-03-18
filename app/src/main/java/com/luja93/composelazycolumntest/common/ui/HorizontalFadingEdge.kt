package com.luja93.composelazycolumntest.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalFadingEdge(
    color: Color = MaterialTheme.colors.background,
    height: Dp = 20.dp,
    position: HorizontalFadingEdgePosition = HorizontalFadingEdgePosition.BOTTOM,
    modifier: Modifier
) {
    Spacer(
        modifier = modifier
            .height(height)
            .background(
                brush = Brush.verticalGradient(
                    colors = when (position) {
                        HorizontalFadingEdgePosition.TOP -> listOf(
                            Color.Transparent,
                            color
                        )
                        HorizontalFadingEdgePosition.BOTTOM -> listOf(
                            color,
                            Color.Transparent
                        )
                    },
                )
            ),
    )
}

enum class HorizontalFadingEdgePosition {
    TOP,
    BOTTOM
}
