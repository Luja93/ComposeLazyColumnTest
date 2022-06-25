package com.luja93.composelazycolumntest.common.adapter

import androidx.viewbinding.ViewBinding

/**
 * Base view holder class for all views with view binding in recycler view adapter.
 */
abstract class BaseViewBindingHolder<VB, T>(
    protected val binding: VB,
) : BaseViewHolder<T>(binding.root) where VB : ViewBinding {

    /**
     * Overrides bind fun without view binding to call one with view binding.
     */
    override fun bind(viewModel: T) {
        binding.bind(viewModel)
    }

    /**
     * Binds view binding with view model.
     */
    abstract fun VB.bind(viewModel: T)
}
