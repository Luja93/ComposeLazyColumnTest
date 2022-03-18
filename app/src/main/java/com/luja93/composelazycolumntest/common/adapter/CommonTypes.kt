package com.luja93.composelazycolumntest.common.adapter

import androidx.compose.runtime.Composable
import com.luja93.composelazycolumntest.common.ui.*

/**
 * Enumeration for common view types in a list.
 */
enum class CommonAdapterItemType(
    val composableLayout: @Composable () -> Unit
) : BaseAdapterItemType {
    SPACE_2({ CommonSpace2() }),
    SPACE_4({ CommonSpace4() }),
    SPACE_6({ CommonSpace6() }),
    SPACE_7({ CommonSpace6() }),
    SPACE_8({ CommonSpace8() }),
    SPACE_10({ CommonSpace10() }),
    SPACE_12({ CommonSpace12() }),
    SPACE_14({ CommonSpace14() }),
    SPACE_16({ CommonSpace16() }),
    SPACE_18({ CommonSpace18() }),
    SPACE_20({ CommonSpace20() }),
    SPACE_22({ CommonSpace22() }),
    SPACE_24({ CommonSpace24() }),
    SPACE_26({ CommonSpace26() }),
    SPACE_28({ CommonSpace28() }),
    SPACE_30({ CommonSpace30() }),
    SPACE_60({ CommonSpace60() }),
}