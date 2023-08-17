package dev.jianastrero.qr_delivery.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.jianastrero.qr_delivery.ui.theme.TemplateAndroidAppTheme
import dev.jianastrero.qr_delivery.viewmodel.domain.IHomeViewModel
import dev.jianastrero.qr_delivery.viewmodel.implementation.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNextClick: (message: String, value: Float) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: IHomeViewModel = viewModel<HomeViewModel>()
) {
    val state by viewModel.state.collectAsState()
    val messageIsValid by remember(state.message) {
        derivedStateOf {
            viewModel.isMessageValid()
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(64.dp),
        modifier = Modifier
            .padding(
                horizontal = 12.dp,
                vertical = 64.dp
            )
            .then(modifier)
    ) {
        Text(
            text = "Home Screen",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge,
        )
        Spacer(modifier = Modifier.weight(1f))
        TextField(
            value = state.message,
            onValueChange = {
                viewModel.updateState(state.copy(message = it))
            },
            isError = state.message.isNotEmpty() && !messageIsValid,
            label = { Text("Message") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Slider(
            value = state.value,
            onValueChange = {
                viewModel.updateState(state.copy(value = it))
            },
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = {
                onNextClick(state.message, state.value)
            },
            enabled = state.message.isNotEmpty() && messageIsValid,
            modifier = Modifier.fillMaxWidth(0.8f)
        ) {
            Text(
                text = "View Details",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    TemplateAndroidAppTheme {
        HomeScreen(
            onNextClick = { _, _ -> },
            viewModel = IHomeViewModel.Preview
        )
    }
}
