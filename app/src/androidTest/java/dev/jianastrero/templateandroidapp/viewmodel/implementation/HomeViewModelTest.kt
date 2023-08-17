package dev.jianastrero.templateandroidapp.viewmodel.implementation

import androidx.lifecycle.SavedStateHandle
import dev.jianastrero.qr_delivery.state.home.HomeState
import dev.jianastrero.qr_delivery.viewmodel.domain.IHomeViewModel
import dev.jianastrero.qr_delivery.viewmodel.implementation.HomeViewModel
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {

    lateinit var viewmodel: IHomeViewModel

    @Before
    @Test
    fun setup() {
        val savedState = SavedStateHandle(mapOf("state" to HomeState()))
        viewmodel = HomeViewModel(savedState)
        assert(viewmodel.state.value == HomeState())
    }

    @Test
    fun checkIfStateIsUpdatedTest() {
        val newState = HomeState("Hello World", 0.5f)
        viewmodel.updateState(newState)
        assert(viewmodel.state.value == newState)
    }

    @Test
    fun invalidMessageTest() {
        val newState = HomeState("abc")
        viewmodel.updateState(newState)
        assert(!viewmodel.isMessageValid())
    }

    @Test
    fun validMessageTest() {
        val newState = HomeState("Hello World!")
        viewmodel.updateState(newState)
        assert(viewmodel.isMessageValid())
    }
}
