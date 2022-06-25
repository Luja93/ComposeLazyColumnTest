package com.luja93.composelazycolumntest.squad.viewholder

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.luja93.composelazycolumntest.common.ui.SectionHeader
import com.luja93.composelazycolumntest.squad.model.ui.SectionHeaderUiModel

@Composable
fun SquadSectionHeader(
    uiModel: SectionHeaderUiModel,
) {
    Surface(color = MaterialTheme.colors.background) {
        SectionHeader(uiModel = uiModel)
    }
}

//region Preview
@Preview("Section header", showBackground = true)
@Composable
private fun SoccerTeamDetailsSquadSectionHeaderPreview() {
    SectionHeader(
        uiModel = SectionHeaderUiModel(
            title = "Attack",
        ),
    )
}
//endregion
