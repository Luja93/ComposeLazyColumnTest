package com.luja93.composelazycolumntest.common.adapter

import androidx.recyclerview.widget.DiffUtil

/**
 * Diff callback for [AdapterItemWrapper].
 */
class AdapterItemWrapperDiffCallback : DiffUtil.ItemCallback<AdapterItemWrapper>() {

    /**
     * Validates that items are the same base on item hash code.
     */
    override fun areItemsTheSame(oldItem: AdapterItemWrapper, newItem: AdapterItemWrapper): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    /**
     * Validates that items contents the same base on item id, type and data.
     */
    override fun areContentsTheSame(oldItem: AdapterItemWrapper, newItem: AdapterItemWrapper): Boolean {
        return oldItem == newItem
    }
}
