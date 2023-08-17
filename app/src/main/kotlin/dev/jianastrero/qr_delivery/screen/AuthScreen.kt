package dev.jianastrero.qr_delivery.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.qr_delivery.R
import dev.jianastrero.qr_delivery.component.LoginWithApple
import dev.jianastrero.qr_delivery.component.LoginWithGoogle
import dev.jianastrero.qr_delivery.ui.theme.Primary
import dev.jianastrero.qr_delivery.ui.theme.QRDeliveryAppTheme

@Composable
fun AuthScreen(
    onLoginClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundPainter = painterResource(id = R.drawable.design_one)

    Box(modifier = modifier) {
        Image(
            painter = backgroundPainter,
            contentDescription = "Auth Screen",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .background(
                    Brush.verticalGradient(listOf(Color.Transparent, Primary))
                )
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    bottom = 32.dp,
                    top = 256.dp
                )
        ) {
            LoginWithGoogle(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                         onLoginClicked()
                    }
            )
            LoginWithApple(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onLoginClicked()
                    }
            )
        }
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(32.dp)
        ) {
            Text(
                text = "QR\nDelivery",
                color = Color.White,
                fontWeight = FontWeight.Black,
                fontSize = 64.sp,
                lineHeight = 64.sp
            )
            Text(
                text = "\"Delivering Confidence, One Code at a Time.\"",
                color = Color.White,
                fontWeight = FontWeight.Black,
                fontSize = 14.sp
            )
        }
    }
}

@Preview
@Composable
private fun AuthScreenPreview() {
    QRDeliveryAppTheme {
        AuthScreen(onLoginClicked = {})
    }
}
