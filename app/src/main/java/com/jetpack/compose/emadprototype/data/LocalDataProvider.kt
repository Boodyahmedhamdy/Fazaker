package com.jetpack.compose.emadprototype.data

import com.jetpack.compose.emadprototype.ui.states.PrayListItemUiState

object LocalDataProvider {
    val totalScore = 25


    fun getMainPrays(): List<PrayListItemUiState> {
        return listOf(
            PrayListItemUiState(
                1,
                title = "Fajr"
            ),
            PrayListItemUiState(
                2,
                title = "Dohr"
            ),
            PrayListItemUiState(
                3,
                title = "Asr"
            ),
            PrayListItemUiState(
                4,
                title = "Maghreb"
            ),
            PrayListItemUiState(
                5,
                title = "Eshaa"
            ),
        )
    }
}