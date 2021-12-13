package com.example.sanssystechnology.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun AppBar( title:String,scaffoldState: ScaffoldState) {
    val coroutineScope = rememberCoroutineScope()
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            IconButton(onClick = {
                coroutineScope.launch {
                    var status = scaffoldState.drawerState.isOpen
                    if(status) {
                        scaffoldState.drawerState.close()
                    } else {
                        scaffoldState.drawerState.open()
                    }
                }
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
            }
        }
    )
}

@Composable
fun NavOptions(
    title: String,
    scaffoldState: ScaffoldState,
    navController: NavController,
    navigate: String
) {
    var coroutineScope = rememberCoroutineScope()
    Text(
        text = title,
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        ),
        modifier =
        Modifier
            .padding(32.dp)
            .fillMaxWidth()
            .clickable {
                if (title == "About Us") {
                    navController.navigate("about-us")

                } else if (title == "Home") {
                    //navController.navigate("home")
                } else if (title == "Contact") {
                    //navController.navigate("")
                }
                coroutineScope.launch {
                    scaffoldState.drawerState.close()
                }
            },
    )
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun NavDrawer ( scaffoldState: ScaffoldState,navController: NavController,navigate:String) {
    Column() {
        /* Image(
            painter = painterResource(R.drawable.ic_baseline_home_24) ,
            contentDescription ="Home",
            contentScale = ContentScale.Crop,
            modifier =
                Modifier.padding(32.dp)
        ) */
        Text(
            text = "Sanssys Technology!!",
            modifier = Modifier.padding(32.dp),
            style = TextStyle(
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive,
                fontSize = TextUnit(40f, TextUnitType.Sp)
            )
        )
    }
    Divider()

    NavOptions(title = "Home", scaffoldState = scaffoldState, navController = navController,navigate)
    NavOptions(title = "About Us", scaffoldState = scaffoldState, navController = navController,navigate)
    NavOptions(title = "Contact", scaffoldState = scaffoldState,navController=navController,navigate)
}

@Composable
fun DashBoardScreen( navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    var navigate = "home"
    Scaffold(
        scaffoldState = scaffoldState,
        topBar =  {
            AppBar(title = "Sanssys Technology", scaffoldState = scaffoldState)
        },
        drawerContent = {
            // navigation View
            NavDrawer(scaffoldState = scaffoldState, navController = navController,navigate)
        },
        drawerScrimColor = Color.Yellow.copy(alpha = 0.2f),
        drawerShape = CutCornerShape(topEnd = 68.dp)
    ) {

    }
}