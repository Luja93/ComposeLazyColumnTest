package com.luja93.composelazycolumntest.common.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.luja93.composelazycolumntest.R
import com.luja93.composelazycolumntest.theme.SquadTheme
import com.luja93.composelazycolumntest.squad.model.ui.SectionHeaderUiModel

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    uiModel: SectionHeaderUiModel,
    onSeeMoreClicked: (uiModel: SectionHeaderUiModel) -> Unit = {},
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
        SeeMoreButton(
            uiModel = uiModel.seeMoreUiModel,
            shape = SquadTheme.shapes.allRounded,
            modifier = Modifier
                .clip(shape = SquadTheme.shapes.allRounded)
                .clickable { onSeeMoreClicked(uiModel) }
                .padding(8.dp)
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

@Composable
private fun SeeMoreButton(
    uiModel: SectionHeaderUiModel.SeeMoreUiModel?,
    shape: Shape,
    modifier: Modifier
) {
    uiModel?.let {
        Surface(
            color = MaterialTheme.colors.background,
            shape = shape,
            modifier = modifier
        ) {
            ConstraintLayout {
                val (seeMoreTitle, seeMoreIcon) = createRefs()

                SeeMoreButtonTitle(
                    title = uiModel.title,
                    modifier = Modifier
                        .constrainAs(seeMoreTitle) {
                            centerVerticallyTo(parent)
                            start.linkTo(parent.start)
                        }
                )
                SeeMoreButtonIcon(
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .constrainAs(seeMoreIcon) {
                            centerVerticallyTo(seeMoreTitle)
                            start.linkTo(seeMoreTitle.end)
                        }
                )
            }
        }
    }
}

@Composable
private fun SeeMoreButtonTitle(
    title: String,
    modifier: Modifier
) {
    Text(
        text = title.uppercase(),
        style = SquadTheme.typography.medium.s12,
        color = SquadTheme.colors.secondaryText,
        modifier = modifier
    )
}

@Composable
private fun SeeMoreButtonIcon(
    modifier: Modifier
) {
    Icon(
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_small_right_vector),
        contentDescription = "See more button icon",
        tint = SquadTheme.colors.secondaryText,
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
