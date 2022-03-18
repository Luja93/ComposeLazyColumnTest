package com.luja93.composelazycolumntest.squad.viewholder

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luja93.composelazycolumntest.theme.SquadTheme
import com.luja93.composelazycolumntest.squad.model.ui.SquadViewTopPlayersUiModel

@Composable
fun SquadViewTopPlayers(
    viewTopPlayersUiModel: SquadViewTopPlayersUiModel,
    onClicked: () -> Unit,
) {
    Surface(
        shape = SquadTheme.shapes.allRounded,
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onClicked() }
                .padding(horizontal = 12.dp, vertical = 14.dp)
        ) {
            CupIcon()
            Title(title = viewTopPlayersUiModel.title)
        }
    }
}

@Composable
private fun CupIcon(){
    Image(
        imageVector = ImageVector.vectorResource(id = SquadTheme.drawables.cupCircle),
        contentDescription = "Cup icon",
    )
}

@Composable
private fun Title(
    title: String
){
    Text(
        text = title.uppercase(),
        style = SquadTheme.typography.medium.s12,
        color = SquadTheme.colors.secondaryText,
        modifier = Modifier.padding(start = 12.dp)
    )
}

//region Preview
@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
private fun SoccerTeamDetailsSquadViewTopPlayersPreview() {
    SquadViewTopPlayers(
        viewTopPlayersUiModel = SquadViewTopPlayersUiModel(
            title = "VIEW TOP PLAYERS",
        ),
        onClicked = {}
    )
}
//endregion