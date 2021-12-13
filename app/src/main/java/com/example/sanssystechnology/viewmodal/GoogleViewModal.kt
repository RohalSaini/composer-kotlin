package com.example.sanssystechnology.viewmodal

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.sanssystechnology.R
import com.example.sanssystechnology.Session
import com.example.sanssystechnology.modal.Google
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import kotlinx.coroutines.launch

class SignInGoogleViewModel(application: Application) : AndroidViewModel(application), ViewModelProvider.Factory {
    private var _userState = MutableLiveData<Google>()
    val googleUser: LiveData<Google> = _userState

    private var _loadingState = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loadingState

    init {
        checkSignedInUser(application.applicationContext)
    }

    fun fetchSignInUser(email: String?, name: String?) {
        _loadingState.value = true

        viewModelScope.launch {
            _userState.value = email?.let {
                Google(
                    email = it,
                    name = name.toString(),
                )
            }
            println("++++++++++++++++++++")
            println("Fetch User ")
            println("Name  is "+_userState.value?.name)
            println("Email is "+_userState.value?.email)
            println("_____________________")
            var sesssion = Session(getApplication())
            sesssion.setLoggedin(
                logggedin = true,
                emial = _userState.value!!.email,
                name = _userState.value!!.name,
                pass = "12345",
                id = "123456"
            )
        }

        _loadingState.value = false
    }

    private fun checkSignedInUser(applicationContext: Context) {
        _loadingState.value = true

        val gsa = GoogleSignIn.getLastSignedInAccount(applicationContext)
        if (gsa != null) {
            _userState.value = Google(
                email = gsa.email,
                name = gsa.displayName,
            )
        }
        println("++++++++++++++++++++")
        println("Signing User ")
        println("Name  is "+_userState.value?.name)
        println("Email is "+_userState.value?.email)
        println("_____________________")

        _loadingState.value = false
        logOutUser(applicationContext = applicationContext)
    }

    fun logOutUser(applicationContext: Context) {
        GoogleSignIn
            .getClient(applicationContext,
                GoogleSignInOptions
                    .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build()).signOut().addOnCompleteListener {
                        println("sign Out")
            }
    }

    fun hideLoading() {
        _loadingState.value = false
    }

    fun showLoading() {
        _loadingState.value = true
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(SignInGoogleViewModel::class.java)) {
            return SignInGoogleViewModel(application = getApplication()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

/*
class SignInGoogleViewModelFactory( private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(SignInGoogleViewModel::class.java)) {
            return SignInGoogleViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
} */