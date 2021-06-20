package com.android.sample.game.network

import com.android.sample.game.model.WrapperResponse
import io.reactivex.Single
import retrofit2.http.GET

interface GameService {

        @GET("v1/gifs/search")
        fun getGifs(): Single<WrapperResponse>
}