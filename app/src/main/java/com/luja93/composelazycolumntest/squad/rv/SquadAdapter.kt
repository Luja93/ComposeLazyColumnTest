package com.luja93.composelazycolumntest.squad.rv

import android.view.ViewGroup
import com.luja93.composelazycolumntest.common.adapter.BaseListAdapter
import com.luja93.composelazycolumntest.common.adapter.BaseViewHolder
import com.luja93.composelazycolumntest.squad.viewholder.SquadViewType
import com.luja93.composelazycolumntest.squad.viewholder.SquadViewType.*

class SquadAdapter : BaseListAdapter<SquadViewType>(values()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: SquadViewType,
    ): BaseViewHolder<*> = when (viewType) {
        VIEW_TOP_PLAYERS -> SquadViewTopPlayersViewHolder(parent)
        POSITION_SECTION_HEADER -> SquadSectionHeaderViewHolder(parent)
        COACH -> SquadPlayerViewHolder(parent)
        PLAYER_ROW -> SquadPlayerViewHolder(parent)
    }

}
