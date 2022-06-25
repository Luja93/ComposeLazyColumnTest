package com.luja93.composelazycolumntest.squad.viewholder

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luja93.composelazycolumntest.theme.SquadTheme
import com.luja93.composelazycolumntest.squad.model.ui.SquadPlayerUiModel
import com.luja93.composelazycolumntest.common.model.TableRowColorUiModel
import com.luja93.composelazycolumntest.common.utils.resolveTableRowColor

@Composable
fun SquadPlayer(
    uiModel: SquadPlayerUiModel,
    onPlayerClicked: () -> Unit,
) {
    Surface(
        color = resolveTableRowColor(uiModel = uiModel.colorDefinition),
        modifier = Modifier.padding(horizontal = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    onClick = { onPlayerClicked() },
                    enabled = uiModel.isClickable
                )
                .padding(horizontal = 8.dp, vertical = 6.dp)
        ) {
            uiModel.playerShirtNumber?.let {
                PlayerShirtNumber(shirtNumber = uiModel.playerShirtNumber)
                Spacer(modifier = Modifier.width(8.dp))
            }
            Spacer(modifier = Modifier.width(4.dp))
            Flag()
            Spacer(modifier = Modifier.width(12.dp))
            PlayerName(name = uiModel.playerName, Modifier.weight(1f))
            Spacer(modifier = Modifier.width(12.dp))
            PlayerYears(years = uiModel.playerYears)
        }
    }
}

@Composable
private fun PlayerShirtNumber(
    shirtNumber: String
) {
    Surface(
        shape = CircleShape,
        border = BorderStroke(width = 1.dp, color = SquadTheme.colors.shirtNumberBorder),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.sizeIn(minWidth = 24.dp, minHeight = 24.dp)
        ) {
            Text(
                text = shirtNumber,
                style = SquadTheme.typography.medium.s11,
                color = SquadTheme.colors.shirtNumber,
            )
        }
    }
}

@Composable
private fun Flag() {
    Icon(
        imageVector = ImageVector.vectorResource(id = SquadTheme.drawables.emptyFlag),
        contentDescription = "Empty flag",
        modifier = Modifier.size(width = 12.dp, height = 12.dp)
    )
}

@Composable
private fun PlayerName(
    name: String,
    modifier: Modifier
) {
    Text(
        text = name,
        color = SquadTheme.colors.primaryText,
        style = SquadTheme.typography.regular.s13,
        modifier = modifier,
    )
}

@Composable
private fun PlayerYears(
    years: String?
) {
    years?.let {
        Text(
            text = it,
            color = SquadTheme.colors.secondaryText,
            style = SquadTheme.typography.regular.s11,
        )
    }
}

//region Preview
@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
private fun SoccerTeamDetailsSquadPlayerPreview() {
    SquadPlayer(
        uiModel = SquadPlayerUiModel(
            playerId = "123",
            playerName = "Luka Modric",
            playerShirtNumber = "19",
            playerYears = "31 years",
            colorDefinition = TableRowColorUiModel(),
            isClickable = true,
        ),
        onPlayerClicked = {},
    )
}
//endregion
