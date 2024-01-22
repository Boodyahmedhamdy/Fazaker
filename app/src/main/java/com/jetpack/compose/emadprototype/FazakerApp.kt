package com.jetpack.compose.emadprototype

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.jetpack.compose.emadprototype.data.LocalDataProvider
import com.jetpack.compose.emadprototype.ui.screens.PraysScreen
import com.jetpack.compose.emadprototype.viewmodels.PraysScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FazakerApp(
    modifier: Modifier = Modifier
) {
    val praysScreenViewModel: PraysScreenViewModel = viewModel()
    val state = praysScreenViewModel.state.collectAsState()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(text = "Today's Record")
            })
        },
        floatingActionButton = {
            Text(
                text = "${state.value.score}/${LocalDataProvider.totalScore}",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold
            )
        },
        modifier = modifier
    ) {
        PraysScreen(
            state = state.value,
            onPrayItemChecked = { id, checked ->
                praysScreenViewModel.onClickCheckItem(id, checked)
            },
            onPrayItemWithPeopleChecked = { prayId, checked ->
                praysScreenViewModel.onClickWithPeopleItem(prayId, checked)
            },
            modifier = Modifier.padding(it)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun FazakerAppPreview() {
    FazakerApp()
}