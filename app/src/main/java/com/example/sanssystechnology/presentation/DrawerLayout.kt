package com.example.sanssystechnology.presentation

import android.os.Bundle
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import kotlinx.coroutines.launch
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.platform.LocalContext
import com.example.sanssystechnology.Session


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun DrawerAppComponent(navController: NavController, index:Int, savedStateHandle: Bundle?){
    var data:SavedStateHandle = SavedStateHandle()
    val scope = rememberCoroutineScope() // coroutine scope
    val scaffoldState = rememberScaffoldState()
    var state:MutableState<DrawerAppScreen> =  remember { mutableStateOf(DrawerAppScreen.Home) }
    when (index) {
        0 -> {
            state = remember { mutableStateOf(DrawerAppScreen.Home) }
        }
        1 -> {
            state = remember { mutableStateOf(DrawerAppScreen.About) }
        }
        2 -> {
            state = remember { mutableStateOf(DrawerAppScreen.Contact) }
        }
    }
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            DrawerContentComponent(
                savedStateHandle =savedStateHandle,
                currentScreen = state,
                closeDrawer = {
                    scope.launch {
                        if(scaffoldState.drawerState.isOpen) {
                            scaffoldState.drawerState.close()
                        } else {
                            scaffoldState.drawerState.open()
                        }
                    }
                },
                navController = navController,
                drawerState = scaffoldState.drawerState
            )
        },
        content = {
            HomeScreen(
                drawerState =scaffoldState.drawerState
            )
        },
        drawerScrimColor = Color.Yellow.copy(alpha = 0.2f),
        drawerShape = CutCornerShape(topEnd = 68.dp)
    )
}
/**set CloseDrawer Content*/
@Composable
fun DrawerContentComponent(
    savedStateHandle: Bundle?,
    currentScreen: MutableState<DrawerAppScreen>,
    closeDrawer:()->Unit,
    navController: NavController,
    drawerState:DrawerState
)
{
    val openDialog = remember { mutableStateOf(false)  }
    /**set design*/
    Column (modifier = Modifier.fillMaxSize()){
        val scope = rememberCoroutineScope() // coroutine scope
        for (index in DrawerAppScreen.values().indices){
            /**set Screen ,Icon and Color*/
            val screen = getScreenBasedOnIndex(index) // get screen name
            val iconss = getIcon(index) // get icon for screen
            val colors = getColor(index) // get color for screen
            Column(
                modifier = Modifier.clickable {
                    closeDrawer()
                    when (index) {
                        0 -> {
                            println(screen.name)
                            scope.launch {
                                drawerState.close()
                            }
                        }
                        1 -> {
                            println(screen.name)
                            savedStateHandle?.getBundle("data")?.putString("nav","about")
                            //navController.navigate("about")
                            navController.navigate("about")
                        }
                        2 -> {
                            println(screen.name)
                            savedStateHandle?.getBundle("data")?.putString("nav","contact")
                            navController.navigate("contact")
                        }
                    }
                },
                content = {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = if (currentScreen.value == screen){
                            MaterialTheme.colors.secondary
                        }else{
                            MaterialTheme.colors.surface
                        }

                    ) {
                        /**set Icon and Text*/
                        Row{
                            Image(modifier = Modifier.padding(7.dp),
                                imageVector = iconss ,
                                contentDescription = "Menu",
                                colorFilter = ColorFilter.lighting(
                                    colors,add= colors))
                            Text(text = "${screen.name} Screen",
                                modifier = Modifier.padding(7.dp),
                                style = TextStyle(
                                    fontSize = 17.sp,
                                    fontStyle = FontStyle.Normal,
                                    color = colors
                                )
                            )
                        }

                    }
                }
            )
        }
        Column(
            modifier = Modifier.clickable {
                                          openDialog.value = true
            },
            content = {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.secondary,
                ) {
                    /**set Icon and Text*/
                    Row{
                        Image(modifier = Modifier.padding(7.dp),
                            imageVector = Icons.Default.Close,
                            contentDescription = "close"
                        )
                        Text(text = "LogOut Screen",
                            modifier = Modifier.padding(7.dp),
                            style = TextStyle(
                                fontSize = 17.sp,
                                fontStyle = FontStyle.Normal,
                                color = colors.error
                            )
                        )
                    }

                }
            }
        )
    }
    if (openDialog.value) {
        AlertDialogSample(navController = navController,openDialog)
    }
}
/**set Screen*/
fun getScreenBasedOnIndex(index:Int)= when(index){
    0-> DrawerAppScreen.Home
    1-> DrawerAppScreen.About
    2-> DrawerAppScreen.Contact
    else->DrawerAppScreen.Home
}
/**set Icon*/
fun getIcon(index:Int)= when(index){
    0-> Icons.Default.Home
    1-> Icons.Default.Favorite
    2-> Icons.Default.Notifications
    else->Icons.Default.Home
}
/**set Color*/
fun getColor(index:Int)= when(index){
    0-> Color.Black
    1-> Color.Red
    2->Color.Blue
    else->Color.Black
}


enum class DrawerAppScreen{Home,About,Contact}

@Composable
fun AlertDialogSample(navController: NavController, openDialog: MutableState<Boolean>) {
    val context = LocalContext.current
    AlertDialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onCloseRequest.
        },
        title = {
            Text(text = "Dialog Title")
        },
        text = {
            Text("Here is a text ")
        },
        confirmButton = {
            Button(

                onClick = {
                    var session= Session(context)
                    session.setLoggedin(
                        logggedin = false,
                        name = "",
                        id = "",
                        emial = "",
                        pass = ""
                    )
                    navController.navigate("login")
                }) {
                Text("This is the Confirm Button")
            }
        },
        dismissButton = {
            Button(

                onClick = {
                    openDialog.value = false
                }) {
                Text("This is the dismiss Button")
            }
        }
    )
    BackHandler(enabled = true){
        println("I am from Home")
    }
}
