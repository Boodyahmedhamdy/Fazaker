package com.jetpack.compose.emadprototype.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jetpack.compose.emadprototype.ui.components.PrayListItem
import com.jetpack.compose.emadprototype.ui.states.PraysScreenUiState

@Composable
fun PraysScreen(
    state: PraysScreenUiState,
    onPrayItemChecked: (prayId: Int, checked: Boolean) -> Unit ,
    onPrayItemWithPeopleChecked: (prayId: Int, checked: Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(state.prays) { prayUiState ->
            PrayListItem(
                state = prayUiState,
                onClickChecked = {
                    onPrayItemChecked(prayUiState.id, it)
                },
                onClickWithPeople = {
                    onPrayItemWithPeopleChecked(prayUiState.id, it)
                }
            )
        }
    }
}