package com.android.sample.game.model

import com.squareup.moshi.Json

data class DataResponse(
    @Json(name = "url")
    val gifUrl: String)