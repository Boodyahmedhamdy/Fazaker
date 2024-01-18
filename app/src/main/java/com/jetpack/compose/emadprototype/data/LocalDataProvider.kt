package com.jetpack.compose.emadprototype.data

import com.jetpack.compose.emadprototype.ui.states.PrayListItemUiState

object LocalDataProvider {
    val totalScore = 25


    fun getMainPrays(): List<PrayListItemUiState> {
        return listOf(
            PrayListItemUiState(
                title = "Fajr"
            ),
            PrayListItemUiState(
                title = "Dohr"
            ),
            PrayListItemUiState(
                title = "Asr"
            ),
            PrayListItemUiState(
                title = "Maghreb"
            ),
            PrayListItemUiState(
                title = "Eshaa"
            ),
        )
    }
}