package com.luja93.composelazycolumntest.common.adapter

class AdapterItemWrapper(
    val type: BaseAdapterItemType,
    val data: Any? = null,
    var id: Any? = null,
    val isSticky: Boolean = false
) {

    override fun hashCode(): Int {
        return if (id == null) {
            31 * type.hashCode() + (data?.hashCode() ?: 0)
        } else {
            31 * type.hashCode() + id.hashCode()
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AdapterItemWrapper

        if (type != other.type) return false
        if (id != other.id) return false
        if (data != other.data) return false
        if (isSticky != other.isSticky) return false

        return true
    }

    /**
     * Returns a copy of [AdapterItemWrapper].
     */
    fun copy(
        type: BaseAdapterItemType = this.type,
        data: Any? = this.data,
        id: Any? = this.id,
        isSticky: Boolean = this.isSticky
    ): AdapterItemWrapper = AdapterItemWrapper(
        type = type,
        data = data,
        id = id,
        isSticky = isSticky
    )
}
