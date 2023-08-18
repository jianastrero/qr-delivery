package dev.jianastrero.qr_delivery.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.jianastrero.qr_delivery.ui.theme.Accent
import dev.jianastrero.qr_delivery.ui.theme.QRDeliveryAppTheme
import dev.jianastrero.qr_delivery.enumeration.BottomNav as BottomNavEnum


private val TOOLBAR_HEIGHT = 56.dp

@Composable
fun BottomNav(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    Row(
        modifier = Modifier
            .height(TOOLBAR_HEIGHT)
            .then(modifier)
    ) {
        BottomNavEnum.entries.forEach {
            BottomNavItem(
                isSelected = currentBackStackEntry?.destination?.route == it.route,
                bottomNav = it,
                isCircle = it == BottomNavEnum.Track,
                onClick = {

                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
        }
    }
}

@Composable
private fun BottomNavItem(
    isSelected: Boolean,
    bottomNav: BottomNavEnum,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isCircle: Boolean = false
) {
    Box(
        modifier = Modifier
            .let {
                if (isCircle) {
                    it
                } else {
                    it.clickable(onClick = onClick)
                }
            }
            .then(modifier)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .clip(if (isCircle) CircleShape else RectangleShape)
                .let {
                    if (isCircle) {
                        it.clickable(onClick = onClick)
                    } else {
                        it
                    }
                }
                .background(if (isCircle) Accent else Color.Transparent)
                .size(TOOLBAR_HEIGHT)
                .padding(6.dp)
                .align(Alignment.BottomCenter)
        ) {
            Icon(
                imageVector = bottomNav.icon,
                contentDescription = bottomNav.text,
                tint = MaterialTheme.colorScheme.primary.copy(alpha = if (isSelected || isCircle) 1f else 0.3f)
            )
            if (!isCircle) {
                Text(
                    text = bottomNav.text,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = if (isSelected) 1f else 0.3f),
                    fontSize = 12.sp,
                    fontWeight = if (isSelected) FontWeight.Normal else FontWeight.Light
                )
            }
        }
    }
}

@Preview
@Composable
fun BottomNavPreview() {
    QRDeliveryAppTheme {
        val navController = rememberNavController()

        Column {
            BottomNav(
                navController = navController,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
