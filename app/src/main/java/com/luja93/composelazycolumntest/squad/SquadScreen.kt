package com.luja93.composelazycolumntest.squad

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.luja93.composelazycolumntest.common.adapter.AdapterItemWrapper
import com.luja93.composelazycolumntest.common.ext.populate
import com.luja93.composelazycolumntest.squad.model.ui.SectionHeaderUiModel
import com.luja93.composelazycolumntest.squad.model.ui.SquadPlayerUiModel
import com.luja93.composelazycolumntest.squad.model.ui.SquadViewTopPlayersUiModel
import com.luja93.composelazycolumntest.squad.viewholder.SquadPlayer
import com.luja93.composelazycolumntest.squad.viewholder.SquadSectionHeader
import com.luja93.composelazycolumntest.squad.viewholder.SquadViewTopPlayers
import com.luja93.composelazycolumntest.squad.viewholder.SquadViewType


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SquadScreen(items: List<AdapterItemWrapper>) {
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = rememberLazyListState(),
            modifier = Modifier.fillMaxSize(),
        ) {
            populate(
                listData = items,
                values = SquadViewType.values(),
                factory = { viewType, data, _ ->
                    when (viewType) {
                        SquadViewType.VIEW_TOP_PLAYERS -> SquadViewTopPlayers(
                            viewTopPlayersUiModel = data as SquadViewTopPlayersUiModel,
                            onClicked = { /*No-op.*/ }
                        )
                        SquadViewType.POSITION_SECTION_HEADER -> SquadSectionHeader(
                            uiModel = data as SectionHeaderUiModel,
                        )
                        SquadViewType.COACH -> SquadPlayer(
                            uiModel = data as SquadPlayerUiModel,
                            onPlayerClicked = { /* No-op. */ },
                        )
                        SquadViewType.PLAYER_ROW -> SquadPlayer(
                            uiModel = data as SquadPlayerUiModel,
                            onPlayerClicked = { /*No-op.*/ },
                        )
                    }
                }
            )
        }
    }
}