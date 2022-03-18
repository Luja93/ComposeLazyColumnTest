package com.luja93.composelazycolumntest.theme

import com.luja93.composelazycolumntest.R

sealed interface SquadDrawablePalette {
    val emptyFlag: Int
    val cupCircle: Int
}

class SquadLightDrawablesPalette : SquadDrawablePalette {
    override val emptyFlag: Int = R.drawable.ic_flag_empty
    override val cupCircle = R.drawable.ic_cup_circle
}

class SquadDarkDrawablesPalette : SquadDrawablePalette {
    override val emptyFlag: Int = R.drawable.ic_flag_empty
    override val cupCircle = R.drawable.ic_cup_circle
}

data class SoccerTeamDetailsDrawables(
    val cupCircle: Int
)

