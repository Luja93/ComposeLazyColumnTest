package com.luja93.composelazycolumntest.common.ext

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.util.fastForEach
import com.luja93.composelazycolumntest.common.adapter.AdapterItemWrapper
import com.luja93.composelazycolumntest.common.adapter.BaseAdapterItemType
import com.luja93.composelazycolumntest.common.adapter.CommonAdapterItemType

/**
 * Populates the [LazyColumn] with the given [listData].
 *
 * The items passed in the [listData] must be of the [T] type (your enumeration
 * representing the possible view types for the list).
 *
 * This function also takes the [CommonAdapterItemType]s into account.
 *
 * @param listData List of [AdapterItemWrapper].
 * @param values Possible view types for this list.
 * @param factory Use this lambda block to pass the composables (view-holders) for the
 * given [viewType].
 *
 * @throws [IllegalStateException] if the [values] contain a foreign view type, which is
 * neither part of the original view-type enumeration or the [CommonAdapterItemType].
 */
@ExperimentalFoundationApi
fun <T> LazyListScope.populate(
    listData: List<AdapterItemWrapper>,
    values: Array<T>,
    factory: @Composable (viewType: T, data: Any?, id: Any?) -> Unit
) where T : BaseAdapterItemType, T : Enum<T> {
    val viewTypes: List<BaseAdapterItemType> = CommonAdapterItemType.values().toList().plus(values.toList())
    val viewTypesInListData = listData.map { it.type }

    if (viewTypes.containsAll(viewTypesInListData).not()) {
        throw IllegalStateException("View type(s) not supported by this screen.")
    }

    listData.fastForEach { adapterItem ->
        when (adapterItem.type) {
            is CommonAdapterItemType -> CommonItem(item = adapterItem)
            else -> ViewTypeItem(item = adapterItem, factory = factory)
        }
    }
}

@ExperimentalFoundationApi
private fun LazyListScope.CommonItem(item: AdapterItemWrapper) {
    if (item.isSticky) {
        stickyHeader (key = item.id, contentType = item.type) { (item.type as CommonAdapterItemType).composableLayout.invoke() }
    } else {
        item (key = item.id, contentType = item.type) { (item.type as CommonAdapterItemType).composableLayout.invoke() }
    }
}

@ExperimentalFoundationApi
private fun <T> LazyListScope.ViewTypeItem(
    item: AdapterItemWrapper,
    factory: @Composable (viewType: T, data: Any?, id: Any?) -> Unit
) where T : BaseAdapterItemType, T : Enum<T> {
    if (item.isSticky) {
        stickyHeader(key = item.id, contentType = item.type) { factory(item.type as T, item.data, item.id) }
    } else {
        item(key = item.id, contentType = item.type) { factory(item.type as T, item.data, item.id) }
    }
}
