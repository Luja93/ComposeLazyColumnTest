package com.luja93.composelazycolumntest.common.adapter

import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

/**
 * Base recycler view adapter with that will update data async with diff utils.
 */
abstract class BaseListAdapter<T>(values: Array<T>) : ListAdapter<
        AdapterItemWrapper,
        BaseViewHolder<*>>(AdapterItemWrapperDiffCallback())
        where T : BaseAdapterItemType, T : Enum<T> {

    protected val viewTypes: List<BaseAdapterItemType> = CommonAdapterItemType.values().toList().plus(values.toList())

    /**
     * Bundle to save child view holders states.
     */
    private val saveStateBundle = Bundle()

    @Suppress("UNCHECKED_CAST")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (val type = viewTypes[viewType]) {
            is CommonAdapterItemType -> onCreateCommonViewHolder(parent, type)
            else -> onCreateViewHolder(parent, type as T)
        }
    }

    /**
     * @return view holder for a adapter specific view type.
     */
    abstract fun onCreateViewHolder(parent: ViewGroup, viewType: T): BaseViewHolder<*>

    /**
     * Binds view holder with a data from AdapterItemWrapper (if any).
     */
    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val itemWrapper = getItem(position)
        // adding id to view as content description for QA team tests.
        holder.itemView.contentDescription = itemWrapper.id?.toString()
        holder.bindIt(itemWrapper.data, itemWrapper.hashCode())
    }

    /**
     * @return index of a item type in a viewTypes list.
     */
    override fun getItemViewType(position: Int) = viewTypes.indexOf(getItem(position).type)

    /**
     * @return hash code of a AdapterItemWrapper on given position.
     */
    override fun getItemId(position: Int): Long = getItem(position).hashCode().toLong()

    /**
     * Updates list data async. When list is updated, optional callback will be notified.
     */
    open fun updateItems(newItems: List<AdapterItemWrapper>, callback: (() -> Unit)? = null) {
        submitList(newItems, callback)
    }

    /**
     * Notifies item when it's is attached to recycler view.
     */
    override fun onViewAttachedToWindow(holder: BaseViewHolder<*>) {
        holder.onViewAttached(saveStateBundle)
    }

    /**
     * Notifies item when it's is detached to recycler view.
     */
    override fun onViewDetachedFromWindow(holder: BaseViewHolder<*>) {
        holder.onViewDetached(saveStateBundle)
    }

    /**
     * @return [CommonViewHolder] for [CommonAdapterItemType].
     */
    private fun onCreateCommonViewHolder(parent: ViewGroup, commonViewType: CommonAdapterItemType): BaseViewHolder<*> {
        return CommonViewHolder(parent, commonViewType)
    }

    /**
     * SKIP function to bind view holder with data from wrapper (if any).
     */
    @Suppress("UNCHECKED_CAST")
    private fun <T> BaseViewHolder<T>.bindIt(viewModel: Any?, hashCode: Int) = viewModel?.let {
        bind(it as T)
    }
}
