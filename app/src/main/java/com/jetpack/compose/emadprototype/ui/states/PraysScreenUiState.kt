package com.jetpack.compose.emadprototype.ui.states

data class PraysScreenUiState(
    val prays: List<PrayListItemUiState>,
    val score: Int = 0
)
