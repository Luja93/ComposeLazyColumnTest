package com.luja93.composelazycolumntest.common.utils

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.luja93.composelazycolumntest.theme.SquadTheme
import com.luja93.composelazycolumntest.common.model.TableRowColorUiModel

@Composable
fun resolveTableRowColor(
    uiModel: TableRowColorUiModel
): Color = when {
    uiModel.isHighlighted -> SquadTheme.colors.highlightedTableRow
    uiModel.hasDarkerBackground -> SquadTheme.colors.darkerTableRow
    else -> MaterialTheme.colors.surface
}
