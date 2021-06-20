package com.android.sample.game.model

import com.squareup.moshi.Json

class WrapperResponse(
    @Json(name = "data")
    val wrapper: List<DataResponse>
)