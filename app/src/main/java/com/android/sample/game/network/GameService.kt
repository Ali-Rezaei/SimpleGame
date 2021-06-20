package com.android.sample.game.network

import com.android.sample.game.model.WrapperResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GameService {

        @GET("v1/gifs/search")
        fun getGifs(@Query("q") query: String): Single<WrapperResponse>
}