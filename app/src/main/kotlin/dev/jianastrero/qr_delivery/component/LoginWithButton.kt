package dev.jianastrero.qr_delivery.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jianastrero.qr_delivery.R
import dev.jianastrero.qr_delivery.extension.primaryShadow
import dev.jianastrero.qr_delivery.ui.theme.QRDeliveryAppTheme

@Composable
fun LoginWithButton(
    @DrawableRes iconId: Int,
    loginWith: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black
) {
    val painter = painterResource(id = iconId)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .primaryShadow(RoundedCornerShape(50))
            .clip(RoundedCornerShape(50))
            .then(modifier)
            .padding(12.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = loginWith,
            modifier = Modifier.size(32.dp)
        )
        Text(
            text = "Login with $loginWith",
            color = textColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
                .padding(
                    start = 12.dp,
                    end = 12.dp + 32.dp
                )
        )
    }
}

@Composable
fun LoginWithGoogle(
    modifier: Modifier = Modifier
) {
    LoginWithButton(
        iconId = R.drawable.google_logo,
        loginWith = "Google",
        textColor = Color.Black,
        modifier = Modifier
            .background(Color.White)
            .then(modifier)
    )
}

@Composable
fun LoginWithApple(
    modifier: Modifier = Modifier
) {
    LoginWithButton(
        iconId = R.drawable.apple_logo,
        loginWith = "Apple",
        textColor = Color.White,
        modifier = Modifier
            .background(Color.Black)
            .then(modifier)
    )
}

@Preview
@Composable
private fun LoginWithButtonPreview() {
    QRDeliveryAppTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(12.dp)
        ) {
            LoginWithGoogle(modifier = Modifier.fillMaxWidth())
            LoginWithApple(modifier = Modifier.fillMaxWidth())
        }
    }
}
