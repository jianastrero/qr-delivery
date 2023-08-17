package dev.jianastrero.qr_delivery.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jianastrero.qr_delivery.ui.theme.TemplateAndroidAppTheme

@Composable
fun <T> DetailItem(
    title: String,
    value: T,
    modifier: Modifier = Modifier
) {
    Surface(
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline
        ),
        shape = MaterialTheme.shapes.small,
        shadowElevation = 8.dp,
        modifier = modifier
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = value.toString(),
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
            )
        }
    }
}

@Preview
@Composable
private fun DetailItemPreview() {
    TemplateAndroidAppTheme {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            DetailItem(
                title = "Message",
                value = "Hello World",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
