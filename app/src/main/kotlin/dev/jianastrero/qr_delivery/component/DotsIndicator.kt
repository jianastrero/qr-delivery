package dev.jianastrero.qr_delivery.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.jianastrero.qr_delivery.ui.theme.Accent
import dev.jianastrero.qr_delivery.ui.theme.Primary
import dev.jianastrero.qr_delivery.ui.theme.QRDeliveryAppTheme


/**
 * Represents colors for dots.
 *
 * @property default The default color for dots. If not specified, it defaults to [Color.White].
 * @property done The color for dots when they are marked as done. If not specified, it defaults to [Accent].
 */
data class DotColor(
    val default: Color = Color.White,
    val done: Color = Accent,
)

/**
 * Represents the color scheme for a line.
 *
 * @property default The default color of the line. Default value is [Color.White] with alpha of 0.5.
 * @property done The color to be used when the line is marked as done. Default value is [Accent] with alpha of 0.5.
 */
data class LineColor(
    val default: Color = Color.White.copy(alpha = 0.5f),
    val done: Color = Accent.copy(0.5f),
)

/**
 * Displays a row of dots with an indicator line.
 *
 * @param currentDot The index of the currently selected dot.
 * @param modifier The modifier to be applied to the row of dots.
 * @param dotCount The total number of dots to display.
 * @param dotRadius The radius of each dot.
 * @param dotColors The colors for the dots.
 * @param lineWidth The width of the indicator line.
 * @param lineColors The colors for the indicator line.
 */
@Composable
fun DotsIndicator(
    currentDot: Int,
    modifier: Modifier = Modifier,
    dotCount: Int = 4,
    dotRadius: Dp = 8.dp,
    dotColors: DotColor = DotColor(),
    lineWidth: Dp = 6.dp,
    lineColors: LineColor = LineColor()
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        repeat(dotCount * 2 - 1) { index ->
            if (index % 2 == 0) {
                Dot(
                    radius = dotRadius,
                    dotColors = dotColors,
                    passed = (index / 2) < currentDot,
                    active = (index / 2) == currentDot
                )
            } else {
                Line(
                    lineWidth = lineWidth,
                    lineColors = lineColors,
                    passed = (index / 2) < currentDot - 1,
                    active = (index / 2) == currentDot - 1
                )
            }
        }
    }
}

@Composable
fun RowScope.Dot(
    radius: Dp,
    dotColors: DotColor,
    passed: Boolean,
    active: Boolean
) {
    Spacer(
        modifier = Modifier
            .size(radius * 2)
            .clip(CircleShape)
            .background(
                if (passed) dotColors.done else dotColors.default
            )
            .border(
                width = if (active) radius / 2 else 0.dp,
                color = dotColors.done,
                shape = CircleShape
            )
    )
}

@Composable
fun RowScope.Line(
    lineWidth: Dp,
    lineColors: LineColor,
    passed: Boolean,
    active: Boolean
) {
    Spacer(
        modifier = Modifier
            .height(lineWidth)
            .weight(1f)
            .clip(RoundedCornerShape(50))
            .let {
                if (active) {
                    it.background(
                        Brush.horizontalGradient(listOf(lineColors.done, lineColors.default))
                    )
                } else {
                    it.background(if (passed) lineColors.done else lineColors.default)
                }
            }
    )
}

@Preview
@Composable
fun DotsIndicatorPreview() {
    QRDeliveryAppTheme {
        Column {
            DotsIndicator(
                currentDot = 2,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Primary)
                    .padding(12.dp)
            )
        }
    }
}
