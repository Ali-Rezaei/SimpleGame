package com.android.sample.game.usecase

import com.android.sample.game.model.WrapperResponse
import com.android.sample.game.repository.InGameRepository
import io.reactivex.Single
import javax.inject.Inject

class GetGifsUseCase @Inject constructor(private val repository: InGameRepository) {

    operator fun invoke(query: String): Single<WrapperResponse> = repository.getGifs(query)
}
