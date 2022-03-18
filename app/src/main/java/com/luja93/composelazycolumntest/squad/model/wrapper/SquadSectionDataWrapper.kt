package com.luja93.composelazycolumntest.squad.model.wrapper

import com.luja93.composelazycolumntest.squad.model.ui.SectionHeaderUiModel
import com.luja93.composelazycolumntest.squad.model.ui.SquadPlayerUiModel

/**
 * Wraps [SectionHeaderUiModel] and list of [SquadPlayerUiModel].
 * Represents list of players by their positions with section header.
 */
data class SquadSectionDataWrapper(
    val sectionHeader: SectionHeaderUiModel,
    val playersList: List<SquadPlayerUiModel>
)