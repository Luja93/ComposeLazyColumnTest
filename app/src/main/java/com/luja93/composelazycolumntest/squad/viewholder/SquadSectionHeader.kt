package com.luja93.composelazycolumntest.squad.viewholder

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luja93.composelazycolumntest.common.ui.HorizontalFadingEdge
import com.luja93.composelazycolumntest.common.ui.SectionHeader
import com.luja93.composelazycolumntest.squad.model.ui.SectionHeaderUiModel

@Composable
fun SquadSectionHeader(
    uiModel: SectionHeaderUiModel,
) {
    Column {
        Surface(color = MaterialTheme.colors.background) {
            SectionHeader(uiModel = uiModel)
        }
        HorizontalFadingEdge(
            height = 6.dp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

//region Preview
@Preview("Section header", showBackground = true)
@Composable
private fun SoccerTeamDetailsSquadSectionHeaderPreview() {
    SectionHeader(
        uiModel = SectionHeaderUiModel(
            title = "Attack"
        )
    )
}
//endregion