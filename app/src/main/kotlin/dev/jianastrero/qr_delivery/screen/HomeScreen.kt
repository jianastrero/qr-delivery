package dev.jianastrero.qr_delivery.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.jianastrero.qr_delivery.ui.theme.QRDeliveryAppTheme
import dev.jianastrero.qr_delivery.viewmodel.domain.IHomeViewModel
import dev.jianastrero.qr_delivery.viewmodel.implementation.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: IHomeViewModel = viewModel<HomeViewModel>()
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            LocationComponent(modifier = Modifier.weight(1f))
            NotifyButton(
                modifier = Modifier
                    .padding(start = 24.dp)
            )
        }
    }
}

@Composable
private fun LocationComponent(modifier: Modifier = Modifier) {
    val shape by remember { mutableStateOf(RoundedCornerShape(50)) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .shadow(4.dp, shape)
            .background(Color.White, shape)
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Icon(
            imageVector = Icons.Outlined.LocationOn,
            contentDescription = "Location",
            tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "1211, Hibiscus Tower, Tivoli Garden Residences, Coronado St, Hulo, Mandaluyong City, 1550",
            fontWeight = FontWeight.Light,
            fontSize = 12.sp,
            maxLines = 1,
            lineHeight = 12.sp,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .weight(1f)
        )
        Icon(
            imageVector = Icons.Outlined.KeyboardArrowDown,
            contentDescription = "Location",
            tint = MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
            modifier = Modifier.size(20.dp)
        )
    }
}

@Composable
private fun NotifyButton(modifier: Modifier = Modifier) {
    val shape by remember { mutableStateOf(RoundedCornerShape(50)) }

    Box(
        modifier = modifier
            .shadow(4.dp, shape)
            .clip(shape)
            .background(Color.White)
            .padding(8.dp)
    ) {
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "Location",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(20.dp)
                .align(Alignment.Center)
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFFF)
@Composable
private fun HomeScreenPreview() {
    QRDeliveryAppTheme {
        HomeScreen(viewModel = IHomeViewModel.Preview)
    }
}
