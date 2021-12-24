package com.example.sanssystechnology.presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sanssystechnology.R
import com.example.sanssystechnology.Session
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    drawerState: DrawerState
)
{
    val context = LocalContext.current
    var courses= ArrayList<Course>(2)
    var course1 = Course(
        name = "Web Development",
        description = "Give your website and amazing UI with our customise Web Design and Development packages in our Company in Hoshiarpur Punjab. If you are going to be online, then you need a proper website- one built by professionals who are passionate about what they do, and offer you comprehensive web design packages prices in India."
    )
    courses.add(course1)
    var course2 = Course(
        name = "Search Engine Optimiztion",
        description = "Give your website and amazing UI with our customise Web Design and Development packages in our Company in Hoshiarpur Punjab. If you are going to be online, then you need a proper website- one built by professionals who are passionate about what they do, and offer you comprehensive web design packages prices in India."
    )
    courses.add(course2)
    val scope = rememberCoroutineScope() // coroutine scope
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        /**set ToolBar*/
        TopAppBar (
            title = {
                Text(text = "Home Screen")
            },
            navigationIcon = {
                IconButton(onClick =  {
                    scope.launch {
                        println("Home button is clicked!! Drawer is "+drawerState.isOpen)
                        drawerState.open()
                        //openDrawer
                    }
                } ) {
                    Icon(
                        modifier = Modifier.padding(5.dp).clickable {
                            println("log outing it")
                            var session = Session(context)
                            session.setLoggedin(
                                logggedin = false,
                                " ",
                                " ",
                                " ",
                                " "
                            )
                        },
                        imageVector = Icons.Filled.Menu,
                        contentDescription ="Menu" )
                }
            },
            actions = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription ="Home" )
            }
        )
        /** set Image And Text*/
        Spacer(modifier = Modifier.padding(10.dp))
        CardView(course = courses[0])
        Spacer(modifier = Modifier.padding(10.dp))
        CardView(course = courses[1])
        /*
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.White,
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.about_logo), contentDescription = "web development")
                Text(text = "Web Development" , color = Color.Black)
                Text(color = Color.Black,text = )
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "See Packages")
                }
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.White,
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(painter = painterResource(id = R.drawable.about_logo), contentDescription = "web development")
                Text(text = "Search Engine Optimiztion" , color = Color.White)
                Text(color = Color.White,text = "Give your website and amazing UI with our customise Web Design and Development packages in our Company in Hoshiarpur Punjab. If you are going to be online, then you need a proper website- one built by professionals who are passionate about what they do, and offer you comprehensive web design packages prices in India.")
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "See Packages")
                }
            }
        }
        //CardView()
       // ExpandableCard()
        */

    }
}


@Composable
fun CardView( course: Course) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(color = Color(0xFFFFE6E6))) {
        Row {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.about_logo),
                contentDescription ="image",
                contentScale = ContentScale.Crop,)
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                text = "${course.name}",
                fontSize = MaterialTheme.typography.h5.fontSize,
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontWeight = FontWeight.Bold
                )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                text = "${course.description}",
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontWeight = FontWeight.Light
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(onClick = { /*TODO*/ }) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    text = "See More",
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
            }
        }
    }
}

data class Course( val name:String,val description:String)