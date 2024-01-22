package com.jetpack.compose.emadprototype.ui.states



data class PrayListItemUiState(
    val id: Int,
    val title: String = "Fajr",
    val isDone: Boolean = false,
    val points: Int = 5,
    val isOptional: Boolean = false,
    val withPeople: Boolean = false
)
