package com.android.sample.game

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.sample.game.model.WrapperResponse
import com.android.sample.game.network.GameService
import com.android.sample.game.repository.InGameRepositoryImpl
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class InGameRepositoryTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var service: GameService

    @Test
    fun givenServerResponse200_whenFetch_shouldGetGifs() {
        val repository = InGameRepositoryImpl(service)
        val wrapperResponse = WrapperResponse(emptyList())
        `when`(service.getGifs(anyString()))
            .thenReturn(Single.just(wrapperResponse))
        val testObserver = repository.getGifs(anyString()).test()
        testObserver.assertValue(wrapperResponse)
        testObserver.dispose()
    }
}