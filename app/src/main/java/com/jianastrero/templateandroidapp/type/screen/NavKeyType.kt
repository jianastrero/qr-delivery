package com.jianastrero.templateandroidapp.type.screen

import android.os.Bundle
import androidx.navigation.NavType
import androidx.navigation.navArgument
import kotlin.reflect.KClass

/**
 * Interface representing a navigation key type.
 *
 * @param T the type of value associated with the navigation key
 */
interface NavKeyType<T : Any> {
    val key: String
    val type: KClass<T>
}

/**
 * Converts the [NavKeyType] to a [NavArgument] with the appropriate type.
 *
 * @return the converted [NavArgument]
 */
fun NavKeyType<*>.toNavArgument() = navArgument(key) {
    type = when (this@toNavArgument.type) {
        Boolean::class -> NavType.BoolType
        Int::class -> NavType.IntType
        Long::class -> NavType.LongType
        Float::class -> NavType.FloatType
        Array<Boolean>::class -> NavType.BoolArrayType
        Array<Int>::class -> NavType.IntArrayType
        Array<Long>::class -> NavType.LongArrayType
        Array<Float>::class -> NavType.FloatArrayType
        Array<String>::class -> NavType.StringArrayType
        else -> NavType.StringType
    }
}

/**
 * Converts a value stored in a [Bundle] to the appropriate type specified by [NavKeyType].
 *
 * @param navArguments The [Bundle] that contains the navigation arguments.
 *
 * @return The value retrieved from [navArguments] converted to the appropriate type specified by [NavKeyType].
 * If the specified type is not supported, it will return an empty [String].
 */
fun NavKeyType<*>.fromNavArgument(navArguments: Bundle): Any {
    return when (type) {
        Boolean::class -> navArguments.getBoolean(key)
        Int::class -> navArguments.getInt(key)
        Long::class -> navArguments.getLong(key)
        Float::class -> navArguments.getFloat(key)
        Array<Boolean>::class -> navArguments.getBooleanArray(key)
        Array<Int>::class -> navArguments.getIntArray(key)
        Array<Long>::class -> navArguments.getLongArray(key)
        Array<Float>::class -> navArguments.getFloat(key)
        Array<String>::class -> navArguments.getStringArray(key)
        else -> navArguments.getString(key, "")
    } as Any
}
