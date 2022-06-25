package com.luja93.composelazycolumntest.squad.rv

import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.luja93.composelazycolumntest.R
import com.luja93.composelazycolumntest.common.adapter.BaseViewBindingHolder
import com.luja93.composelazycolumntest.common.ext.inflateBinding
import com.luja93.composelazycolumntest.databinding.ItemSquadPlayerBinding
import com.luja93.composelazycolumntest.squad.model.ui.SquadPlayerUiModel

class SquadPlayerViewHolder(
    parent: ViewGroup,
) : BaseViewBindingHolder<ItemSquadPlayerBinding, SquadPlayerUiModel>(
    parent.inflateBinding(ItemSquadPlayerBinding::inflate),
) {
    override fun ItemSquadPlayerBinding.bind(viewModel: SquadPlayerUiModel) = with(viewModel) {
        if (colorDefinition.hasDarkerBackground) {
            container.setBackgroundColor(ContextCompat.getColor(context, R.color.darkerTableRow))
        } else {
            container.setBackgroundColor(ContextCompat.getColor(context, R.color.surface))
        }

        playerShirtNumberContainer.isVisible = playerShirtNumber != null

        playerShirtNumberTextView.text = playerShirtNumber
        playerNameTextView.text = playerName
        playerAgeTextView.text = playerYears
    }
}
