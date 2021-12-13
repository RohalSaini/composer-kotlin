package com.example.sanssystechnology.presentation

import android.os.Bundle
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
import android.R
import androidx.navigation.NavType
import androidx.navigation.Navigator
import androidx.navigation.navArgument


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
            BodyContentComponent(
                currentScreen =state.value ,
                openDrawer = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }, drawerState = scaffoldState.drawerState)
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
    /**set design*/
    Column (modifier = Modifier.fillMaxSize()){
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
                            savedStateHandle?.getBundle("data")?.putString("nav","home")
                            //savedStateHandle?.putSerializable("nav","home")
                            //savedStateHandle.set("nav","home")
                            val bundle = Bundle()
                            bundle.putString("link", "http://yourlink.com/policy")
                            navController.navigate("home")
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

/**set BodyContentComponent*/
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun BodyContentComponent(
    currentScreen:DrawerAppScreen,
    openDrawer:()->Unit,
    drawerState: DrawerState

)
{
    when(currentScreen){
        DrawerAppScreen.Home -> HomeScreen(drawerState = drawerState,openDrawer =  openDrawer )
        DrawerAppScreen.About -> AboutScreen(drawerState = drawerState,openDrawer =  openDrawer )
        DrawerAppScreen.Contact -> ContactScreen(drawerState = drawerState,openDrawer =  openDrawer)
    }

}

enum class DrawerAppScreen{Home,About,Contact}

