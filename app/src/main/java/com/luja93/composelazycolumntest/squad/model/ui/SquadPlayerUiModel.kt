package com.luja93.composelazycolumntest.squad.model.ui

import com.luja93.composelazycolumntest.common.model.TableRowColorUiModel

data class SquadPlayerUiModel(
    val playerId: String,
    val playerName: String,
    val playerShirtNumber: String?,
    val playerYears: String? = null,
    val isFirstInTable: Boolean = false,
    val isLastInTable: Boolean = false,
    val colorDefinition: TableRowColorUiModel,
    val isClickable: Boolean,
)