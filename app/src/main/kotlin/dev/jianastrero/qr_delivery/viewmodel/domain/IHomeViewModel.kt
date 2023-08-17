package dev.jianastrero.qr_delivery.viewmodel.domain

import dev.jianastrero.qr_delivery.state.home.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


interface IHomeViewModel {
    val state: StateFlow<HomeState>

    fun updateState(state: HomeState)
    fun isMessageValid(): Boolean

    companion object {
        val Preview = object : IHomeViewModel {
            override val state: StateFlow<HomeState> = MutableStateFlow(HomeState())
            override fun updateState(state: HomeState) {}
            override fun isMessageValid(): Boolean = true
        }
    }
}
