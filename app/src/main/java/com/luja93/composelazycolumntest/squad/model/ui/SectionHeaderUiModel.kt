package com.luja93.composelazycolumntest.squad.model.ui

data class SectionHeaderUiModel(
    val title: String,
    val seeMoreUiModel: SeeMoreUiModel? = null
) {
    data class SeeMoreUiModel(
        val title: String,
        val argsData: Any? = null
    )
}
