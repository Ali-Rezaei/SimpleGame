package com.android.sample.game

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.sample.game.model.DataResponse
import com.android.sample.game.model.Images
import com.android.sample.game.model.Original
import com.android.sample.game.model.WrapperResponse
import com.android.sample.game.repository.InGameRepository
import com.android.sample.game.usecase.GetGifsUseCase
import com.android.sample.game.util.Resource
import com.android.sample.game.util.scheduler.TestSchedulerProvider
import com.android.sample.game.viewmodel.InGameViewModel
import io.reactivex.Single
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.util.concurrent.TimeUnit

class InGameViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: InGameRepository

    private lateinit var schedulerProvider: TestSchedulerProvider

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        schedulerProvider = TestSchedulerProvider()
    }

    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess() {
        val wrapperResponse = WrapperResponse(listOf(DataResponse(Images(Original("")))))
        `when`(repository.getGifs(anyString())).thenReturn(Single.just(wrapperResponse))
        val viewModel = InGameViewModel(schedulerProvider, GetGifsUseCase(repository), anyString())

        viewModel.liveData.value.let {
            assertThat(it, `is`(Resource.Loading))
        }
        schedulerProvider.testScheduler.advanceTimeBy(1, TimeUnit.MILLISECONDS)

        viewModel.liveData.value.let {
            assertThat(it, `is`(notNullValue()))
            if (it is Resource.Success) {
                it.data?.let { data ->
                    assertTrue(data.wrapper.isNotEmpty())
                }
            } else {
                Assert.fail("Wrong type $it")
            }
        }
    }

    @Test
    fun givenServerResponseError_whenFetch_specie_shouldReturnError() {
        `when`(repository.getGifs(anyString())).thenReturn(Single.error(Exception("error")))
        val viewModel = InGameViewModel(schedulerProvider, GetGifsUseCase(repository), anyString())

        viewModel.liveData.value.let {
            assertThat(it, `is`(Resource.Loading))
        }
        schedulerProvider.testScheduler.advanceTimeBy(1, TimeUnit.MILLISECONDS)

        viewModel.liveData.value.let {
            assertThat(it, `is`(notNullValue()))
            if (it is Resource.Error) {
                assertThat(it.message, `is`(notNullValue()))
                assertThat(it.message, `is`("error"))
            } else {
                Assert.fail("Wrong type $it")
            }
        }
    }
}