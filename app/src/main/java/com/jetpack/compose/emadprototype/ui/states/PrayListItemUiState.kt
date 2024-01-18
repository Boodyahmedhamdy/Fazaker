package com.jetpack.compose.emadprototype.ui.states



data class PrayListItemUiState(
    val title: String = "Fajr",
    var isDone: Boolean = false,
    val points: Int = 5,
    val isOptional: Boolean = false,
    var withPeople: Boolean = false
)
