package dev.jianastrero.qr_delivery.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.jianastrero.qr_delivery.component.DotsIndicator
import dev.jianastrero.qr_delivery.ui.theme.Primary
import dev.jianastrero.qr_delivery.ui.theme.QRDeliveryAppTheme
import dev.jianastrero.qr_delivery.viewmodel.domain.IHomeViewModel
import dev.jianastrero.qr_delivery.viewmodel.implementation.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: IHomeViewModel = viewModel<HomeViewModel>()
) {
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(256.dp)
                .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                .background(Primary)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Info",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "On going delivery",
                    color = Color.White,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 4.dp)
                )
            }
            DotsIndicator(
                currentDot = 2,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
        }
//        Text(
//            text = "Book a Delivery",
//            color = Color.White,
//            textAlign = TextAlign.Center,
//            modifier = Modifier
//                .fillMaxWidth()
//                .clip(RoundedCornerShape(50))
//                .background(Primary)
//                .padding(12.dp)
//        )
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    QRDeliveryAppTheme {
        HomeScreen(viewModel = IHomeViewModel.Preview)
    }
}
