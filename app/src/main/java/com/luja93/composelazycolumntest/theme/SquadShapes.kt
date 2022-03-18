package com.luja93.composelazycolumntest.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
class SquadShapes(
    val allRounded: CornerBasedShape = RoundedCornerShape(6.dp),
    val topRounded: CornerBasedShape = RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp, bottomStart = 0.dp, bottomEnd = 0.dp),
    val bottomRounded: CornerBasedShape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 6.dp, bottomEnd = 6.dp),
    val leftRounded: CornerBasedShape = RoundedCornerShape(topStart = 6.dp, topEnd = 0.dp, bottomStart = 6.dp, bottomEnd = 0.dp),
    val rightRounded: CornerBasedShape = RoundedCornerShape(topStart = 0.dp, topEnd = 6.dp, bottomStart = 0.dp, bottomEnd = 6.dp),
) {
    fun copy(
        allRounded: CornerBasedShape = this.allRounded,
        topRounded: CornerBasedShape = this.topRounded,
        bottomRounded: CornerBasedShape = this.bottomRounded,
        leftRounded: CornerBasedShape = this.leftRounded,
        rightRounded: CornerBasedShape = this.rightRounded
    ): SquadShapes = SquadShapes(
        allRounded = allRounded,
        topRounded = topRounded,
        bottomRounded = bottomRounded,
        leftRounded = leftRounded,
        rightRounded = rightRounded
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SquadShapes) return false

        if (allRounded != other.allRounded) return false
        if (topRounded != other.topRounded) return false
        if (bottomRounded != other.bottomRounded) return false
        if (leftRounded != other.leftRounded) return false
        if (rightRounded != other.rightRounded) return false

        return true
    }

    override fun hashCode(): Int {
        var result = allRounded.hashCode()
        result = 31 * result + topRounded.hashCode()
        result = 31 * result + bottomRounded.hashCode()
        result = 31 * result + leftRounded.hashCode()
        result = 31 * result + rightRounded.hashCode()
        return result
    }
}

internal val LocalSquadShapes = staticCompositionLocalOf { SquadShapes() }
