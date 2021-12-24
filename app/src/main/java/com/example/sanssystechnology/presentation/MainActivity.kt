package com.example.sanssystechnology.presentation

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sanssystechnology.Session
import com.example.sanssystechnology.ui.theme.SanssysTechnologyTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {

    @ExperimentalFoundationApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SanssysTechnologyTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.fillMaxSize()
                    ) {
                    Navigation("Android", savedInstanceState = savedInstanceState)
                }
            }
        }
    }

    override fun onBackPressed() {
        //AlertDialogSample
        //android.app.AlertDialog.Builder(this)

        val builder = android.app.AlertDialog.Builder(this)
        builder.setCancelable(false)
        builder.setMessage("Do you want to Exit?")
        builder.setPositiveButton("Yes") { dialog, which -> //if user pressed "yes", then he is allowed to exit from application
            super.onBackPressed()
        }
        builder.setNegativeButton("No") { dialog, which -> //if user select "No", just cancel this dialog and continue with app
            dialog.cancel()
        }.create().show()
    }
}

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun Navigation(
    name: String,
    savedInstanceState: Bundle?) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen" ) {
        composable("splash_screen") {
            val context = LocalContext.current
            var session= Session(context)
            if(!session.loggedin()) {
                DrawerAppComponent(
                    navController, index = 0,
                    savedInstanceState
                )
            } else {
                SplashScreen(navController = navController)
            }
        }
        composable("home") {
           DrawerAppComponent(navController, index = 0 ,savedInstanceState)
        }
        composable("about") {
           AboutScreen()
        }
        composable("contact") {
            ContactScreen()
        }
        composable("login") {
            AuthScreen(navController = navController)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.DONUT)
@Composable
fun  SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true ) {
        scale.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3000L)
        navController.navigate("login")
        //var session = Session(context.applicationContext as Application)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Blue),
    ) {
        Text(
            text = "Sanssys Technology",
            color = Color.White,
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
        )
    }
}

