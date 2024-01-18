package com.jetpack.compose.emadprototype

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpack.compose.emadprototype.data.LocalDataProvider
import com.jetpack.compose.emadprototype.ui.states.PrayListItemUiState
import kotlinx.coroutines.flow.MutableStateFlow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FazakerApp(
    modifier: Modifier = Modifier
) {
    var currentScore by remember {
        mutableIntStateOf(0)
    }
    val prays = MutableStateFlow(LocalDataProvider.getMainPrays())
    val praysState = prays.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "Today's Record")
            })
        },
        floatingActionButton = {
            Text(
                text = "$currentScore/${LocalDataProvider.totalScore}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold
            )
        },
        modifier = modifier
    ) {
        LazyColumn(
            modifier = Modifier.padding(it)
        ) {
            items(praysState.value) {
                PrayListItem(
                    state = it,
                    onClickChecked = { isChecked ->
                        currentScore += it.points
                        it.isDone = isChecked
                    }
                )
            }
        }

    }

}

@Composable
fun PrayListItem(
    modifier: Modifier = Modifier,
    state: PrayListItemUiState = PrayListItemUiState(),
    onClickChecked: (Boolean) -> Unit = {}
) {

    /*
    * column of 2 rows
    * 1. row ==> checkbox, title, points, isOptional
    * 2. row ==> isSingle
    *
    * */



    Card(
        modifier.padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = state.isDone, onCheckedChange = {
                onClickChecked(it)
                println("isChecked? $it")
            })
            Text(text = state.title, style = MaterialTheme.typography.titleLarge)
            Text(
                text = "+${state.points}",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(3.dp)
                    .background(MaterialTheme.colorScheme.background))
            Spacer(modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier
            .height(16.dp)
            .fillMaxWidth())

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = state.withPeople, onCheckedChange = {
                state.withPeople = it
            })
            Text(text = "With People")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun FazakerAppPreview() {
    FazakerApp()
}