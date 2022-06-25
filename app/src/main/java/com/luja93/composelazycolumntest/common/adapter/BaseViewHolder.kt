package com.luja93.composelazycolumntest.common.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Base view holder class for all views in adapter.
 */
abstract class BaseViewHolder<T>(private val containerView: View) : RecyclerView.ViewHolder(containerView) {

    constructor(parent: ViewGroup, @LayoutRes layoutId: Int, attachToRoot: Boolean = false) : this(
        LayoutInflater.from(parent.context).inflate(layoutId, parent, attachToRoot))

    val context: Context = itemView.context

    /**
     * Binds view model to a view.
     */
    abstract fun bind(viewModel: T)

    /**
     * Called when view is attached to the window.
     */
    open fun onViewAttached(saveStateBundle: Bundle) {
    }

    /**
     * Called when view is detached from the window.
     */
    open fun onViewDetached(saveStateBundle: Bundle) {
    }
}
