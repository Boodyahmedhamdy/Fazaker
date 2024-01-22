package com.jetpack.compose.emadprototype.viewmodels

import androidx.lifecycle.ViewModel
import com.jetpack.compose.emadprototype.data.LocalDataProvider
import com.jetpack.compose.emadprototype.ui.states.PrayListItemUiState
import com.jetpack.compose.emadprototype.ui.states.PraysScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PraysScreenViewModel: ViewModel() {

    private val _state = MutableStateFlow(
        PraysScreenUiState(emptyList())
    )
    val state = _state.asStateFlow()

    init {
        loadPrays()
    }

    private fun loadPrays() {
        _state.update {
            it.copy(
                prays = LocalDataProvider.getMainPrays()
            )
        }
    }

    fun onClickCheckItem(id: Int, checked: Boolean) {
        val updatedList = _state.value.prays.map {
            if(it.id == id) it.copy(id = id, isDone = checked) else it
        }
        _state.update {
            it.copy(
                prays = updatedList,
                score = if(checked){ // means that you prayed
                    it.score + 5
                } else if(it.score >= 0) {
                    it.score - 5
                } else {
                    it.score + 0
                }
            )
        }
    }
    fun onClickWithPeopleItem(id: Int, withPeople: Boolean) {
        _state.update {
            it.copy(
                prays = it.prays.map {
                    if(it.id == id) it.copy(id = id, withPeople = withPeople) else it
                }
            )
        }
    }

    private fun findPrayById(id: Int): PrayListItemUiState? {
        return _state.value.prays.find {
            it.id == id
        }
    }


}