package com.android.sample.game.viewmodel

import com.android.sample.game.base.BaseViewModel
import com.android.sample.game.model.WrapperResponse
import com.android.sample.game.usecase.GetGifsUseCase
import com.android.sample.game.util.scheduler.BaseSchedulerProvider
import javax.inject.Inject

class InGameViewModel @Inject constructor(
    schedulerProvider: BaseSchedulerProvider,
    getGifsUseCase: GetGifsUseCase,
    query: String
) : BaseViewModel<WrapperResponse>(schedulerProvider) {

    init {
        sendRequest(getGifsUseCase(query))
    }
}