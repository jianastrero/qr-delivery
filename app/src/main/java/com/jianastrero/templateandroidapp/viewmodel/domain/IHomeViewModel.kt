package com.jianastrero.templateandroidapp.viewmodel.domain

import com.jianastrero.templateandroidapp.state.home.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


interface IHomeViewModel {
    val state: StateFlow<HomeState>

    fun updateState(state: HomeState)

    companion object {
        val Preview = object : IHomeViewModel {
            override val state: StateFlow<HomeState> = MutableStateFlow(HomeState())
            override fun updateState(state: HomeState) {}
        }
    }
}
