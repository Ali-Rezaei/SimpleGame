package com.android.sample.game.model

import com.squareup.moshi.Json

class Original(
    @Json(name = "url")
    val gifUrl: String
)