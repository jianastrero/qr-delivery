package dev.jianastrero.qr_delivery.enumeration

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBalanceWallet
import androidx.compose.material.icons.outlined.DirectionsCar
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.QrCode
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNav(
    val route: String,
    val icon: ImageVector,
    val text: String
) {
    Home("home", Icons.Outlined.Home, "Home"),
    Parcels("parcels", Icons.Outlined.DirectionsCar, "Parcels"),
    Track("track", Icons.Outlined.QrCode, "Track"),
    Wallet("Wallet", Icons.Outlined.AccountBalanceWallet, "Wallet"),
    Profile("profile", Icons.Outlined.Person, "Profile")
}
