package dev.jianastrero.qr_delivery.extension

import androidx.navigation.NavController
import dev.jianastrero.qr_delivery.enumeration.Screen
import dev.jianastrero.qr_delivery.type.screen.Argument
import dev.jianastrero.qr_delivery.type.screen.Parameter

fun NavController.navigate(
    screen: Screen,
    arguments: Map<Argument<*>, Any> = emptyMap(),
    parameters: Map<Parameter<*>, Any> = emptyMap()
) {
    navigate(screen.getRoute(arguments, parameters))
}
