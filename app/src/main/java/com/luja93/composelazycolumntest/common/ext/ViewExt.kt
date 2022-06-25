package com.luja93.composelazycolumntest.common.ext

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

val View.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(context)


fun <VB> ViewGroup.inflateBinding(
    inflateAction: (LayoutInflater, ViewGroup?, Boolean) -> VB,
    attachToParent: Boolean = false,
): VB = inflateAction.invoke(layoutInflater, this, attachToParent)
