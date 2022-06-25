package com.luja93.composelazycolumntest.squad.rv

import android.view.ViewGroup
import com.luja93.composelazycolumntest.common.adapter.BaseViewBindingHolder
import com.luja93.composelazycolumntest.common.ext.inflateBinding
import com.luja93.composelazycolumntest.databinding.ItemSquadViewTopPlayersBinding
import com.luja93.composelazycolumntest.squad.model.ui.SquadViewTopPlayersUiModel

class SquadViewTopPlayersViewHolder(
    parent: ViewGroup,
) : BaseViewBindingHolder<ItemSquadViewTopPlayersBinding, SquadViewTopPlayersUiModel>(
    parent.inflateBinding(ItemSquadViewTopPlayersBinding::inflate)
) {
    override fun ItemSquadViewTopPlayersBinding.bind(viewModel: SquadViewTopPlayersUiModel) {
        viewTopPlayersTextView.text = viewModel.title
    }
}
