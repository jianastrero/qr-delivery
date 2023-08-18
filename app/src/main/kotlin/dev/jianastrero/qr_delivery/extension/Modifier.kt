package dev.jianastrero.qr_delivery.extension

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import dev.jianastrero.qr_delivery.ui.theme.Primary


fun Modifier.primaryShadow(shape: Shape) = then(
    Modifier.shadow(
        elevation = 4.dp,
        shape = shape,
        ambientColor = Primary,
        spotColor = Primary
    )
)
