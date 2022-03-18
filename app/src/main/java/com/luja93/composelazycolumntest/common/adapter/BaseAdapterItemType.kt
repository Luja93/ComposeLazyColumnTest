package com.luja93.composelazycolumntest.common.adapter

interface BaseAdapterItemType

infix fun BaseAdapterItemType.with(data: Any): AdapterItemWrapper =
    AdapterItemWrapper(type = this, data = data)

infix fun BaseAdapterItemType.withId(id: Any): AdapterItemWrapper =
    AdapterItemWrapper(type = this, data = null, id = id)

infix fun AdapterItemWrapper.and(newId: Any?): AdapterItemWrapper = copy(
    id = newId
)

infix fun AdapterItemWrapper.sticky(sticky: Boolean): AdapterItemWrapper = copy(
    isSticky = sticky
)
