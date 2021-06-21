package com.android.sample.game.repository

import com.android.sample.game.model.WrapperResponse
import com.android.sample.game.network.GameService
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InGameRepositoryImpl @Inject constructor(
    private val service: GameService,
) : InGameRepository {

    override fun getGifs(query: String): Single<WrapperResponse> = service.getGifs(query)
}