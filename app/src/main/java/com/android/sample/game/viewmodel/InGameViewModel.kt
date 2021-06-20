package com.android.sample.game.viewmodel

import com.android.sample.game.model.DataResponse
import com.android.sample.game.usecase.GetGifsUseCase
import com.android.sample.game.util.scheduler.BaseSchedulerProvider

class InGameViewModel(schedulerProvider: BaseSchedulerProvider,
                      getGifsUseCase: GetGifsUseCase)
    : BaseViewModel<List<DataResponse>>(schedulerProvider, getGifsUseCase())