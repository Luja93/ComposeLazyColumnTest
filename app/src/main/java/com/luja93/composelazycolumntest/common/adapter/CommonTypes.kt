package com.luja93.composelazycolumntest.common.adapter

import android.view.ViewGroup
import androidx.compose.runtime.Composable
import com.luja93.composelazycolumntest.R
import com.luja93.composelazycolumntest.common.ui.*

/**
 * Enumeration for common view types in a list.
 */
enum class CommonAdapterItemType(
    val layoutResId: Int,
    val composableLayout: @Composable () -> Unit,
) : BaseAdapterItemType {
    SPACE_2(R.layout.item_space_2, { CommonSpace2() }),
    SPACE_4(R.layout.item_space_4, { CommonSpace4() }),
    SPACE_6(R.layout.item_space_6, { CommonSpace6() }),
    SPACE_7(R.layout.item_space_7, { CommonSpace6() }),
    SPACE_8(R.layout.item_space_8, { CommonSpace8() }),
    SPACE_10(R.layout.item_space_10, { CommonSpace10() }),
    SPACE_12(R.layout.item_space_12, { CommonSpace12() }),
    SPACE_14(R.layout.item_space_14, { CommonSpace14() }),
    SPACE_16(R.layout.item_space_16, { CommonSpace16() }),
    SPACE_18(R.layout.item_space_18, { CommonSpace18() }),
    SPACE_20(R.layout.item_space_20, { CommonSpace20() }),
    SPACE_22(R.layout.item_space_22, { CommonSpace22() }),
    SPACE_24(R.layout.item_space_24, { CommonSpace24() }),
    SPACE_26(R.layout.item_space_26, { CommonSpace26() }),
    SPACE_28(R.layout.item_space_28, { CommonSpace28() }),
    SPACE_30(R.layout.item_space_30, { CommonSpace30() }),
    SPACE_60(R.layout.item_space_60, { CommonSpace60() }),
}

/**
 * Simple view holder for common type items that does nothing on bind.
 */
class CommonViewHolder(
    parent: ViewGroup,
    type: CommonAdapterItemType,
) : BaseViewHolder<Any>(parent, type.layoutResId) {
    override fun bind(viewModel: Any) {}
}
