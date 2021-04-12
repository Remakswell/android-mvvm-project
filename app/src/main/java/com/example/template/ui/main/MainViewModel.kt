package com.example.template.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.template.data.DataRepository
import javax.inject.Inject

class MainViewModel @Inject constructor(
    repository: DataRepository
) : ViewModel() {

    private val _dataInfo = MutableLiveData("")
    val dataInfo: LiveData<String>
        get() = _dataInfo

    init {
        _dataInfo.value = repository.getInfo()
    }
}