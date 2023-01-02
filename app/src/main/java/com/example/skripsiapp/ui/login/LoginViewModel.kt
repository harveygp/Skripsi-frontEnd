package com.example.skripsiapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.skripsiapp.data.remote.response.LoginResponse
import com.example.skripsiapp.domain.UserRepository.LoginRepository
import com.example.skripsiapp.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository : LoginRepository
): ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isSuccess = MutableLiveData<Boolean>()
    val isSuccess: LiveData<Boolean> = _isSuccess

    private val _data = MutableLiveData<LoginResponse>()
    val data: LiveData<LoginResponse> = _data

    init {
        _isLoading.postValue(false)
    }

    fun getStudentData(nama : String, peminatan : String){
        if(peminatan == "IPS"){
            viewModelScope.launch(Dispatchers.IO) {
                repository.getUserLoginIps(nama).onEach { condition ->
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
        }else{
            viewModelScope.launch(Dispatchers.IO) {
                repository.getUserLoginIpa(nama).onEach { condition ->
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