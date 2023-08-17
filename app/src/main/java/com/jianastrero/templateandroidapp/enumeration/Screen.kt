package com.jianastrero.templateandroidapp.enumeration

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import com.jianastrero.templateandroidapp.type.screen.Argument
import com.jianastrero.templateandroidapp.type.screen.Parameter
import com.jianastrero.templateandroidapp.type.screen.argument
import com.jianastrero.templateandroidapp.type.screen.fromNavArgument
import com.jianastrero.templateandroidapp.type.screen.toNavArgument

sealed class Screen(route: String) {

    private val _route = route

    open val arguments: List<Argument<*>> = emptyList()
    open val parameters: List<Parameter<*>> = emptyList()

    val route: String
        get() {
            var completeRoute = _route

            if (arguments.isNotEmpty()) {
                completeRoute += "/${arguments.joinToString("/") { "{${it.key}}" }}"
            }

            if (parameters.isNotEmpty()) {
                completeRoute += "?${parameters.joinToString("&") { "${it.key}={${it.key}}" }}"
            }

            return completeRoute
        }

    val namedNavArguments: List<NamedNavArgument>
        get() = (arguments + parameters).map {
            it.toNavArgument()
        }

    fun getRoute(
        arguments: Map<Argument<*>, Any> = emptyMap(),
        parameters: Map<Parameter<*>, Any> = emptyMap()
    ): String {
        var navRoute = _route

        if (arguments.entries.size != this.arguments.size || arguments.keys != this.arguments.toSet()) {
            throw Exception("Arguments size mismatch")
        }

        val unknownParameters = parameters.keys.filterNot { it in this.parameters }
        if (unknownParameters.isNotEmpty()) {
            throw Exception("Unknown parameters: ${unknownParameters.joinToString(", ")}")
        }

        if (this.arguments.isNotEmpty()) {
            navRoute += "/"

            this.arguments.forEachIndexed { index, argument ->
                navRoute += arguments[argument].toString()

                if (index != this.arguments.size - 1) {
                    navRoute += "/"
                }
            }
        }

        if (parameters.isNotEmpty()) {
            navRoute += "?${parameters.entries.joinToString("&") {
                "${it.key}=${it.value}"
            }}"
        }

        return navRoute
    }

    inline fun <reified T> getValues(backStackEntry: NavBackStackEntry, defaultValue: T): T {
        val navArguments = backStackEntry.arguments ?: return defaultValue

        val constructor = T::class.constructors.firstOrNull() ?: return defaultValue

        val values = (arguments + parameters).map {
            it.fromNavArgument(navArguments)
        }

        return constructor.call(*values.toTypedArray())
    }

    object Home : Screen("home")

    object Detail : Screen("route") {
        val TITLE = argument<String>("title")
        val VALUE = argument<Float>("value")

        override val arguments: List<Argument<*>> = listOf(TITLE, VALUE)
    }
}
