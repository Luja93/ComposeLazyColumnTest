package com.luja93.composelazycolumntest.squad.rv

import android.view.ViewGroup
import com.luja93.composelazycolumntest.common.adapter.BaseViewBindingHolder
import com.luja93.composelazycolumntest.common.ext.inflateBinding
import com.luja93.composelazycolumntest.databinding.ItemSquadSectionHeaderBinding
import com.luja93.composelazycolumntest.squad.model.ui.SectionHeaderUiModel

class SquadSectionHeaderViewHolder(
    parent: ViewGroup,
) : BaseViewBindingHolder<ItemSquadSectionHeaderBinding, SectionHeaderUiModel>(
    parent.inflateBinding(ItemSquadSectionHeaderBinding::inflate)
) {
    override fun ItemSquadSectionHeaderBinding.bind(viewModel: SectionHeaderUiModel) {
        titleTextView.text = viewModel.title
    }
}
