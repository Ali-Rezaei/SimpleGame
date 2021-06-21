package com.android.sample.game

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.android.sample.game.model.WrapperResponse
import com.android.sample.game.repository.InGameRepository
import com.android.sample.game.usecase.GetGifsUseCase
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
class GetGifsUseCaseTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: InGameRepository

    @Test
    fun givenServerResponse200_whenFetch_shouldGetGifs() {
        val useCase = GetGifsUseCase(repository)
        val wrapperResponse = WrapperResponse(emptyList())
        `when`(repository.getGifs(anyString()))
            .thenReturn(Single.just(wrapperResponse))
        val testObserver = useCase(anyString()).test()
        testObserver.assertValue(wrapperResponse)
        testObserver.dispose()
    }
}