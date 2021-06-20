package com.android.sample.game.repository

import com.android.sample.game.model.DataResponse
import io.reactivex.Single

interface InGameRepository {

    fun getGifs(): Single<List<DataResponse>>
}

