package com.example.skripsiapp.ui.dashboard

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skripsiapp.data.remote.response.ApiResponseIps
import com.example.skripsiapp.data.remote.response.DataResponse
import com.example.skripsiapp.domain.UserRepository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import com.example.skripsiapp.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository : UserRepository
): ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isSuccess = MutableLiveData<Boolean>()
    val isSuccess: LiveData<Boolean> = _isSuccess

    private val _data = MutableLiveData<DataResponse>()
    val data: LiveData<DataResponse> = _data

    private val _pageNumber = MutableLiveData<Int>(0)
    val pageNumber: LiveData<Int> = _pageNumber


    init {
        _isLoading.postValue(false)
    }

    fun setPage(index : Int) {
        _pageNumber.value = index
    }

    fun getUserData(nama : String , peminatan : Boolean, universitas : Int) {
        if (true) {
            when (universitas) {
                0 -> {
                    viewModelScope.launch(Dispatchers.IO) {
                        repository.getUserIpsUpnvj(nama).onEach { condition ->
                            when (condition) {
                                is Result.Loading -> _isLoading.value = true
                                is Result.Success -> {
                                    _isLoading.value = false
                                    _isSuccess.value = true
                                    _data.value = condition.response?.data
                                }
                                is Result.Error -> {
                                    _isLoading.value = false
                                    _isSuccess.value = false
                                }
                            }
                        }.launchIn(viewModelScope)
                    }
                }
                1 -> {
                    viewModelScope.launch(Dispatchers.IO) {
                        repository.getUserIpsUnj(nama).onEach { condition ->
                            when (condition) {
                                is Result.Loading -> _isLoading.value = true
                                is Result.Success -> {
                                    _isLoading.value = false
                                    _isSuccess.value = true
                                    _data.value = condition.response?.data
                                }
                                is Result.Error -> {
                                    _isLoading.value = false
                                    _isSuccess.value = false
                                }
                            }
                        }.launchIn(viewModelScope)
                    }
                }
                2 -> {
                    viewModelScope.launch(Dispatchers.IO) {
                        repository.getUserIpsUinj(nama).onEach { condition ->
                            when (condition) {
                                is Result.Loading -> _isLoading.value = true
                                is Result.Success -> {
                                    _isLoading.value = false
                                    _isSuccess.value = true
                                    _data.value = condition.response?.data
                                }
                                is Result.Error -> {
                                    _isLoading.value = false
                                    _isSuccess.value = false
                                }
                            }
                        }.launchIn(viewModelScope)
                    }
                }
            }
        } else {
            when (universitas) {
                0 -> {
                    viewModelScope.launch(Dispatchers.IO) {
                        repository.getUserIpaUpnvj(nama).onEach { condition ->
                            when (condition) {
                                is Result.Loading -> _isLoading.value = true
                                is Result.Success -> {
                                    _isLoading.value = false
                                    _isSuccess.value = true
                                    _data.value = condition.response?.data
                                }
                                is Result.Error -> {
                                    _isLoading.value = false
                                    _isSuccess.value = false
                                }
                            }
                        }.launchIn(viewModelScope)
                    }
                }
                1 -> {
                    viewModelScope.launch(Dispatchers.IO) {
                        repository.getUserIpaUnj(nama).onEach { condition ->
                            when (condition) {
                                is Result.Loading -> _isLoading.value = true
                                is Result.Success -> {
                                    _isLoading.value = false
                                    _isSuccess.value = true
                                    _data.value = condition.response?.data
                                }
                                is Result.Error -> {
                                    _isLoading.value = false
                                    _isSuccess.value = false
                                }
                            }
                        }.launchIn(viewModelScope)
                    }
                }
                2 -> {
                    viewModelScope.launch(Dispatchers.IO) {
                        repository.getUserIpaUinj(nama).onEach { condition ->
                            when (condition) {
                                is Result.Loading -> _isLoading.value = true
                                is Result.Success -> {
                                    _isLoading.value = false
                                    _isSuccess.value = true
                                    _data.value = condition.response?.data
                                }
                                is Result.Error -> {
                                    _isLoading.value = false
                                    _isSuccess.value = false
                                }
                            }
                        }.launchIn(viewModelScope)
                    }
                }
            }
        }
    }
}