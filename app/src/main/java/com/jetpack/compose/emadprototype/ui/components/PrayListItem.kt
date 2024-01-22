package com.jetpack.compose.emadprototype.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpack.compose.emadprototype.R
import com.jetpack.compose.emadprototype.ui.states.PrayListItemUiState

@Composable
fun PrayListItem(
    modifier: Modifier = Modifier,
    state: PrayListItemUiState = PrayListItemUiState(id = 0),
    onClickChecked: (Boolean) -> Unit = {},
    onClickWithPeople: (Boolean) -> Unit = {}
) {
    Card(
        modifier.padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = spacedBy(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // checkbox
                Checkbox(
                    checked = state.isDone,
                    onCheckedChange = { onClickChecked(it) }
                )
                // pray name
                Text(text = state.title, style = MaterialTheme.typography.titleLarge)
                // points for pray
                Text(
                    text = "+${state.points}",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(5.dp)
                        .background(MaterialTheme.colorScheme.background)
                )
            }

            // with people row
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = state.withPeople,
                    onCheckedChange = {
                        onClickWithPeople(it)
                    }
                )
                Text(text = stringResource(R.string.with_people))
            }

        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PrayListItemPreview() {
    PrayListItem()
}