package com.example.jetpackcomposeinstagram.ui

import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeinstagram.login.domain.LoginUseCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    val loginUseCase = LoginUseCase()


    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email


    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _isLoginEnable = MutableLiveData<Boolean>()
    val isLOginEnable: LiveData<Boolean> = _isLoginEnable


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading





    fun onLoginChanged(email: String, paswword: String) {
        _email.value = email
        _password.value = paswword
        _isLoginEnable.value = enableLogin(email, paswword)

    }


    fun enableLogin(email: String, password: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

    }

    fun onloginSelected() {
        viewModelScope.launch {
            _isLoading.value= true
            val result = loginUseCase(email.value!!, password.value!!)
            if (result) {
                //Navegar hacia otra pantalla
                Log.i("ferna","result OK")
            }
            _isLoading.value= false
        }
    }
}