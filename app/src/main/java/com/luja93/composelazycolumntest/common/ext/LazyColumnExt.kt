package com.luja93.composelazycolumntest.common.ext

import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.luja93.composelazycolumntest.common.adapter.AdapterItemWrapper
import com.luja93.composelazycolumntest.common.adapter.BaseAdapterItemType
import com.luja93.composelazycolumntest.common.adapter.CommonAdapterItemType

fun <T> LazyListScope.populate(
    listData: List<AdapterItemWrapper>,
    factory: @Composable LazyItemScope.(viewType: T, data: Any?, id: Any?) -> Unit
) where T : BaseAdapterItemType, T : Enum<T> {
    items(
        items = listData,
        key = { it.id!! },
        contentType = { it.type },
        itemContent = { item ->
            @Suppress("UNCHECKED_CAST")
            when (item.type) {
                is CommonAdapterItemType -> item.type.composableLayout.invoke()
                else -> factory(item.type as T, item.data, item.id)
            }
        }
    )
}
