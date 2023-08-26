package com.android.app.textcomparer

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Test
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: Comparer

    @Before
    fun setup() {
        viewModel = Comparer()
    }

    @Test
    fun compareSameTexts() {
        val texto1 = "Hola"
        val texto2 = "Hola"

        viewModel.textComparer(texto1, texto2)

        assert(viewModel.resultado.value == "Los textos son iguales")
    }

    @Test
    fun compareDifferentTexts() {
        val texto1 = "Hola"
        val texto2 = "ola"

        viewModel.textComparer(texto1, texto2)

        assert(viewModel.resultado.value == "Los textos son diferentes")
    }
}