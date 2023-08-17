package dev.jianastrero.qr_delivery.type.screen

import kotlin.reflect.KClass

data class Argument<T : Any>(override val key: String, override val type: KClass<T>) : NavKeyType<T>

inline fun <reified T : Any> argument(key: String): Argument<T> = Argument(key, T::class)
