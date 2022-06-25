package com.luja93.composelazycolumntest.common.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luja93.composelazycolumntest.squad.model.ui.SectionHeaderUiModel
import com.luja93.composelazycolumntest.theme.SquadTheme

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    uiModel: SectionHeaderUiModel,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(start = 16.dp, end = 12.dp)
    ) {
        Title(
            title = uiModel.title,
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp, bottom = 8.dp, end = 8.dp)
        )
    }
}

@Composable
private fun Title(
    title: String,
    modifier: Modifier
) {
    Text(
        text = title,
        style = SquadTheme.typography.medium.s14,
        color = SquadTheme.colors.sectionHeaderTitle,
        modifier = modifier
    )
}

//region Preview
@Preview(showBackground = true)
@Composable
private fun SoccerPlayerDetailsSectionHeaderFullPreview() {
    SectionHeader(
        uiModel = SectionHeaderUiModel(
            title = "Player form",
            seeMoreUiModel = SectionHeaderUiModel.SeeMoreUiModel(
                title = "See all stats"
            )
        )
    )
}
//endregion
