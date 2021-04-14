package com.example.template.ui.select

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.template.data.DataRepository
import com.example.template.data.model.NasaPhoto
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SelectPhotoViewModel @Inject constructor(
    private val repository: DataRepository
) : ViewModel() {
    private val disposable: CompositeDisposable = CompositeDisposable()

    private val _nasaPhotos = MutableLiveData<List<NasaPhoto>>()
    val nasaPhotos: LiveData<List<NasaPhoto>>
        get() = _nasaPhotos

    fun getNasaPhotos(selectedDate: String) {
        disposable.add(repository.getPhotos(selectedDate)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                _nasaPhotos.value = result
            })
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}