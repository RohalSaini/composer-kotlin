package com.example.sanssystechnology.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sanssystechnology.repository.Person
import com.example.sanssystechnology.repository.PersonRepository
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun AboutScreen() {
    val scope = rememberCoroutineScope() // coro
    var getData = PersonRepository().getAllData()
    Column {

        /**set ToolBar*/
        /**set ToolBar*/
        /**set ToolBar*/

        /**set ToolBar*/
        TopAppBar(
            title = {
                Text(text = "About Screen")
            },
            navigationIcon = {
                IconButton(onClick = {
                    scope.launch {
                        //drawerState.open()
                    }
                }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = "Menu"
                    )
                }
            },
            actions = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite"
                )
            }
        )
        /** set Image And Text*/
        /** set Image And Text*/
        /** set Image And Text*/
        /** set Image And Text*/
        Surface(
            color = Color.White,
            modifier = Modifier.weight(1f)
        ) {
            Row() {
                Surface(modifier = Modifier
                        .background(
                        color = Color.DarkGray
                        )
                ) {
                    Login( OnCLicked =  {
                        println("It is clicked!!")
                    })
                }

            }
            /*
            Row( modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    text = "Since 2011, SANSSYS has provided futuristic and reliable Software and Networking Solutions to clients spread across the spectrum.\n" +
                            "\n" +
                            "Our solutions are not restricted to products from a single vendor or platform. Based on the client’s requirements, we decide which products are best suited to their needs and design accordingly. We have strategic partnerships and domain expertise with most of the well known names in the network and security industry\n" +
                            "\n" +
                            "SANSSYS Technologies is an Internationally recognized Software Development and Network  Solutions  Company. SANSSYS’s core Management team is built around the expertise of top class performance with proven track in software design, development, testing and implementation for topnotch companies"
                )
            } */
        }
    }
}
