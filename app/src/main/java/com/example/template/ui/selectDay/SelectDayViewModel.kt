package com.example.template.ui.selectDay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.template.data.DataRepository
import com.example.template.data.model.NasaDate
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SelectDayViewModel @Inject constructor(
    repository: DataRepository
) : ViewModel() {
    private val disposable: CompositeDisposable = CompositeDisposable()

    private val _dataInfo = MutableLiveData<List<NasaDate>>()
    val dataInfo: LiveData<List<NasaDate>>
        get() = _dataInfo

    init {
        disposable.add(repository.getInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                _dataInfo.value = result
            })
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}