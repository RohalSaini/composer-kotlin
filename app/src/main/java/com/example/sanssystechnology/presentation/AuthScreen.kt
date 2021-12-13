package com.example.sanssystechnology.presentation

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sanssystechnology.R
import com.example.sanssystechnology.google.GoogleApiContract
import com.example.sanssystechnology.viewmodal.SignInGoogleViewModel
import com.google.android.gms.common.api.ApiException



@ExperimentalMaterialApi
@Composable
fun AuthScreen(navController: NavController) {

    val signInRequestCode = 1
    val context = LocalContext.current

    val mSignInViewModel: SignInGoogleViewModel = viewModel(
        factory = SignInGoogleViewModel(context.applicationContext as Application)
    )

    val state = mSignInViewModel.googleUser

    val user = state.value

    val isError = rememberSaveable { mutableStateOf(false) }

    val authResultLauncher =
        rememberLauncherForActivityResult(contract = GoogleApiContract()) { task ->
            try {
                val gsa = task?.getResult(ApiException::class.java)

                if (gsa != null) {
                    //println("+++++++++++++++++++++++++++++++")
                    //println(gsa.account.name+ " "+gsa.displayName)
                    mSignInViewModel.fetchSignInUser(gsa.email, gsa.displayName)
                    mSignInViewModel.logOutUser(context.applicationContext)
                    navController.navigate("home")
                } else {


                }
            } catch (e: ApiException) {
                Log.d("Error in AuthScreen%s", e.toString())
            }
        }

    AuthView(
        onClick = { authResultLauncher.launch(signInRequestCode) },
        isError = isError.value,
        mSignInViewModel
    )

    user?.let {
        mSignInViewModel.hideLoading()
        //navController.navigate("home")
        println("Sign In")
    }
}
@Composable
private fun AuthView(
    onClick: () -> Unit,
    isError: Boolean = false,
    mSignInViewModel: SignInGoogleViewModel
) {
    val state = mSignInViewModel.loading
    val isLoading = state.value

    Scaffold {
        if (isLoading == true && !isError) {
            FullScreenLoaderComponent()
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.weight(1F))
                Image(
                    painterResource(id = R.drawable.ic_baseline_sports_basketball_24),
                    contentDescription = "description",
                )
                Spacer(modifier = Modifier.weight(1F))
                SignInGoogleButton(onClick = {
                    mSignInViewModel.showLoading()
                    onClick()
                })
                Spacer(modifier = Modifier.weight(1F))
                Text(
                    text = "Sigin In",
                    textAlign = TextAlign.Center,
                )

                when {
                    isError -> {
                        isError.let {
                            Text(
                                text = "error",
                                style = MaterialTheme.typography.h6,
                                color = MaterialTheme.colors.error
                            )
                            mSignInViewModel.hideLoading()
                        }
                    }
                }
            }
        }
    }
}