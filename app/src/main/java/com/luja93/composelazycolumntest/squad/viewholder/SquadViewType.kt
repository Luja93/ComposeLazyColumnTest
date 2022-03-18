package com.luja93.composelazycolumntest.squad.viewholder

import com.luja93.composelazycolumntest.common.adapter.BaseAdapterItemType


/**
 * Possible view types for soccer team details squad screen.
 */
enum class SquadViewType: BaseAdapterItemType {
    VIEW_TOP_PLAYERS,
    POSITION_SECTION_HEADER,
    COACH,
    PLAYER_ROW
}