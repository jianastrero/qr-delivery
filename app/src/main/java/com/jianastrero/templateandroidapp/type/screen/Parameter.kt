package com.jianastrero.templateandroidapp.type.screen

import kotlin.reflect.KClass

data class Parameter<T : Any>(override val key: String, override val type: KClass<T>) : NavKeyType<T>

inline fun <reified T : Any> parameter(key: String): Parameter<T> = Parameter(key, T::class)
