package com.android.sample.game.repository

import com.android.sample.game.model.WrapperResponse
import io.reactivex.Single

interface InGameRepository {

    fun getGifs(query: String): Single<WrapperResponse>
}

