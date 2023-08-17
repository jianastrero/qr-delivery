package com.jianastrero.templateandroidapp.viewmodel.implementation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.jianastrero.templateandroidapp.flow.SavableMutableSaveStateFlow
import com.jianastrero.templateandroidapp.state.home.HomeState
import com.jianastrero.templateandroidapp.viewmodel.domain.IHomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class HomeViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel(), IHomeViewModel {

    private val _state = SavableMutableSaveStateFlow(savedStateHandle, "state", HomeState())
    override val state: StateFlow<HomeState>
        get() = _state.asStateFlow()

    override fun updateState(state: HomeState) {
        _state.value = state
    }

}
