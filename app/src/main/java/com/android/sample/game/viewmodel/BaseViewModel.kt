package com.android.sample.game.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.sample.game.util.Resource
import com.android.sample.game.util.scheduler.BaseSchedulerProvider
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

abstract class BaseViewModel<T>(
    private val schedulerProvider: BaseSchedulerProvider,
    private val requestSingle: Single<T>
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _liveData = MutableLiveData<Resource<T>>()
    val liveData: LiveData<Resource<T>>
        get() = _liveData

    init {
        sendRequest()
    }

    fun sendRequest() {
        _liveData.value = Resource.Loading
        requestSingle.subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui()).subscribe({
                _liveData.postValue(Resource.Success(it))
            }) {
                _liveData.postValue(Resource.Error(it.localizedMessage))
                Timber.e(it)
            }.also { compositeDisposable.add(it) }
    }

    /**
     * Called when the ViewModel is dismantled.
     * At this point, we want to cancel all disposables;
     * otherwise we end up with processes that have nowhere to return to
     * using memory and resources.
     */
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}