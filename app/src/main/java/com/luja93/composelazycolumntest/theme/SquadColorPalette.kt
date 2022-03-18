package com.luja93.composelazycolumntest.theme

import androidx.compose.ui.graphics.Color

sealed interface SquadColorPalette {
    val primaryText: Color
    val secondaryText: Color
    val darkerTableRow: Color
    val highlightedTableRow: Color
    val sectionHeaderTitle: Color
    val shirtNumber: Color
    val shirtNumberBorder: Color
}

class SquadLightColorPalette : SquadColorPalette {
    override val primaryText: Color = SquadColors.greyishBrownTwo
    override val secondaryText: Color = SquadColors.brownGreyTwo
    override val darkerTableRow: Color = SquadColors.whiteTwo
    override val highlightedTableRow: Color = SquadColors.eggshell
    override val sectionHeaderTitle: Color = SquadColors.greyishBrownTwo
    override val shirtNumber: Color = SquadColors.greyishBrown
    override val shirtNumberBorder: Color = SquadColors.veryLightPinkThree
}

class SquadDarkColorPalette : SquadColorPalette {
    override val primaryText: Color = SquadColors.lightPeriwinkle
    override val secondaryText: Color = SquadColors.steelGrey
    override val darkerTableRow: Color = SquadColors.darkSeven
    override val highlightedTableRow: Color = SquadColors.tePapaGreen
    override val sectionHeaderTitle: Color = SquadColors.white
    override val shirtNumber: Color = SquadColors.white
    override val shirtNumberBorder: Color = SquadColors.charcoalGreyThree
}