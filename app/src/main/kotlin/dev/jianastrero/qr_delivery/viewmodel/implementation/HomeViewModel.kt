package dev.jianastrero.qr_delivery.viewmodel.implementation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.jianastrero.qr_delivery.flow.SavableMutableSaveStateFlow
import dev.jianastrero.qr_delivery.state.home.HomeState
import dev.jianastrero.qr_delivery.util.checkStringLength
import dev.jianastrero.qr_delivery.viewmodel.domain.IHomeViewModel
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

    override fun isMessageValid(): Boolean =
        checkStringLength(state.value.message, 10)

}
