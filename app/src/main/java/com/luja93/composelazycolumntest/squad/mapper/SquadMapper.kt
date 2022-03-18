package com.luja93.composelazycolumntest.squad.mapper

import com.luja93.composelazycolumntest.common.adapter.*
import com.luja93.composelazycolumntest.squad.model.ui.SectionHeaderUiModel
import com.luja93.composelazycolumntest.squad.model.ui.SquadPlayerUiModel
import com.luja93.composelazycolumntest.squad.model.ui.SquadViewTopPlayersUiModel
import com.luja93.composelazycolumntest.common.model.TableRowColorUiModel
import com.luja93.composelazycolumntest.squad.model.wrapper.SquadSectionDataWrapper
import com.luja93.composelazycolumntest.common.adapter.CommonAdapterItemType
import com.luja93.composelazycolumntest.squad.viewholder.SquadViewType.*

class SquadMapper {

    fun map() = arrayListOf<AdapterItemWrapper>().apply {
        add(CommonAdapterItemType.SPACE_12.withId("top_spacing"))
        add(VIEW_TOP_PLAYERS with viewTopPlayers and "view_top_players")
        add(CommonAdapterItemType.SPACE_24.withId("manager_section_top_spacing"))
        add(POSITION_SECTION_HEADER with coachSection.sectionHeader and "manager_section_header" sticky (true))
        coachSection.playersList.forEach { player ->
            add(COACH with player and "coach_${player.playerId}")
        }
        add(CommonAdapterItemType.SPACE_24.withId("attackers_section_top_spacing"))
        add(POSITION_SECTION_HEADER with attackersSection.sectionHeader and "attack_section_header" sticky (true))
        attackersSection.playersList.forEachIndexed { index, player ->
            add(PLAYER_ROW with player and "attacker_${player.playerId}_$index")
        }
        add(CommonAdapterItemType.SPACE_24.withId("midfielders_section_top_spacing"))
        add(POSITION_SECTION_HEADER with midfieldersSection.sectionHeader and "midfielders_section_header" sticky (true))
        midfieldersSection.playersList.forEachIndexed { index, player ->
            add(PLAYER_ROW with player and "midfielder_${player.playerId}_$index")
        }
        add(CommonAdapterItemType.SPACE_24.withId("defenders_section_top_spacing"))
        add(POSITION_SECTION_HEADER with defendersSection.sectionHeader and "defence_section_header" sticky (true))
        defendersSection.playersList.forEachIndexed { index, player ->
            add(PLAYER_ROW with player and "defender_${player.playerId}_$index")
        }
        add(CommonAdapterItemType.SPACE_24.withId("goalkeepers_section_top_spacing"))
        add(POSITION_SECTION_HEADER with goalkeepersSection.sectionHeader and "goalkeepers_section_header" sticky (true))
        goalkeepersSection.playersList.forEachIndexed { index, player ->
            add(PLAYER_ROW with player and "goalkeeper_${player.playerId}_$index")
        }
        add(CommonAdapterItemType.SPACE_60.withId("bottomSpacing"))
        add(CommonAdapterItemType.SPACE_60.withId("bottomSpacing_2"))
    }

    private val viewTopPlayers = SquadViewTopPlayersUiModel(
        title = "VIEW TOP PLAYERS"
    )

    private val coachSection = SquadSectionDataWrapper(
        sectionHeader = SectionHeaderUiModel(title = "Coach"),
        playersList = listOf(SquadPlayerUiModel(
            playerId = "coach",
            playerName = "John Doe",
            playerShirtNumber = null,
            playerYears = null,
            isFirstInTable = true,
            isLastInTable = true,
            colorDefinition = TableRowColorUiModel(),
            isClickable = false
        )),
    )

    private val attackersSection = SquadSectionDataWrapper(
        sectionHeader = SectionHeaderUiModel(title = "Attackers"),
        playersList = List(10) { index ->
            SquadPlayerUiModel(
                playerId = "attacker_${index}",
                playerName = "John Doe $index",
                playerYears = (20 + index).toString(),
                playerShirtNumber = "$index",
                isFirstInTable = index == 0,
                isLastInTable = index == 9,
                colorDefinition = TableRowColorUiModel(
                    hasDarkerBackground = index % 2 != 0
                ),
                isClickable = true
            )
        }
    )

    private val midfieldersSection = SquadSectionDataWrapper(
        sectionHeader = SectionHeaderUiModel(title = "Midfielders"),
        playersList = List(10) { index ->
            SquadPlayerUiModel(
                playerId = "midfielder${index}",
                playerName = "John Doe $index",
                playerYears = (20 + index).toString(),
                playerShirtNumber = "$index",
                isFirstInTable = index == 0,
                isLastInTable = index == 9,
                colorDefinition = TableRowColorUiModel(
                    hasDarkerBackground = index % 2 != 0
                ),
                isClickable = true
            )
        }
    )

    private val defendersSection = SquadSectionDataWrapper(
        sectionHeader = SectionHeaderUiModel(title = "Defenders"),
        playersList = List(10) { index ->
            SquadPlayerUiModel(
                playerId = "defender${index}",
                playerName = "John Doe $index",
                playerYears = (20 + index).toString(),
                playerShirtNumber = "$index",
                isFirstInTable = index == 0,
                isLastInTable = index == 9,
                colorDefinition = TableRowColorUiModel(
                    hasDarkerBackground = index % 2 != 0
                ),
                isClickable = true
            )
        }
    )

    private val goalkeepersSection = SquadSectionDataWrapper(
        sectionHeader = SectionHeaderUiModel(title = "Goalkeepers"),
        playersList = List(3) { index ->
            SquadPlayerUiModel(
                playerId = "goalkeepers${index}",
                playerName = "John Doe $index",
                playerYears = (20 + index).toString(),
                playerShirtNumber = "$index",
                isFirstInTable = index == 0,
                isLastInTable = index == 9,
                colorDefinition = TableRowColorUiModel(
                    hasDarkerBackground = index % 2 != 0
                ),
                isClickable = true
            )
        }
    )
}