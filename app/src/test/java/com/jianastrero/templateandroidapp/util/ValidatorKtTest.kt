package com.jianastrero.templateandroidapp.util

import org.junit.Test

class ValidatorKtTest {

    @Test
    fun checkStringLengthValidTest() {
        assert(checkStringLength("Hello World!", 10))
    }

    @Test
    fun checkStringLengthInvalidTest() {
        assert(!checkStringLength("Hello World!", 20))
    }

}
