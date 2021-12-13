package com.example.sanssystechnology.presentation


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sanssystechnology.R
import kotlinx.coroutines.launch


@Composable
fun ContactScreen(
    drawerState: DrawerState,
    openDrawer:()->Unit
) {
    val scope = rememberCoroutineScope() // coro
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(rememberScrollState()),
    ) {
        /**set ToolBar*/
        /**set ToolBar*/
        TopAppBar(
            title = {
                Text(text = "Contact Screen")
            },
            navigationIcon = {
                IconButton(onClick = {
                    scope.launch {
                        drawerState.open()
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
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Contact"
                )
            }
        )
        /** set Image And Text*/
        /** set Image And Text*/
        Spacer(modifier = Modifier.padding(10.dp))
        AboutUs()
        /*
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
            ,
        ) {
            Text(
                text = "Get in touch and we’ll get back to you as soon as we can.  We look forward to hearing from you!",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace
                )
                )
        }
        Spacer(modifier = Modifier
            .padding(5.dp)
            .background(Color.White),)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
            ,
        ) {
            Text(
                text = "SANSSYS Technologies\n",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
            ,
        ) {
            Text(
                text = "E-mail-Id : sanssys@gmail.com, info@sanssys.net",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
            ,
        ) {
            Text(
                text = "HEAD OFFICE",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
            ,
        ) {
            Text(
                text = "Gandharab & Son’s Complex, 2nd floor, Session Court Road\n" +
                        "Hoshiarpur (punjab) 146001\n" +
                        "Ph. No : 01882-502156 , 9876476467",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
            ,
        ) {
            TextFieldComposer()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
            ,
        ) {
            CoilImage()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
            ,
        ) {
            GradientButton(
                text = "Button",
                textColor = Color.White ,
                gradient = Brush.horizontalGradient(
                    colors = listOf(
                        Color.Green,
                        Color.Yellow
                    )
                ) ) {

            }
        }
    }
}


/*
Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                content = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Card (
                            modifier = Modifier.padding(1.dp),
                            elevation = 16.dp
                        ){
                            Image(modifier =
                            Modifier
                                .background(Color.Transparent)
                                .fillMaxWidth(1f),
                                painter = painterResource(id = R.drawable.about_logo),
                                contentScale = ContentScale.Crop,
                                contentDescription = "Contact"
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Transparent)
                        ,
                    ) {
                        Card (
                            modifier =
                                Modifier.padding(10.dp)
                        ){
                            Icon(
                                modifier = Modifier.background(Color.Transparent),
                                imageVector = Icons.Filled.Phone,
                                contentDescription ="phone" )
                        }
                        Spacer(modifier = Modifier.padding(5.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .padding(10.dp)
                        ) {
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(color = Color.Blue)) {
                                        append("Call Us At :")
                                    }
                                    withStyle(style = SpanStyle(
                                        color = Color.Black,
                                        textDecoration = TextDecoration.Underline,
                                        fontFamily = FontFamily.Monospace
                                    )) {
                                        append("01882-502156,9876476467")
                                    }
                                })
                        }

                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                }
            ) // end of column
 */

@Composable
fun DefaultComposer() {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .background(Color.Cyan)) {
        Row( modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)) {
            Card (
                modifier =
                Modifier.padding(10.dp),
            ){
                Icon(
                    modifier = Modifier.background(Color.Transparent),
                    imageVector = Icons.Filled.Phone,
                    contentDescription ="phone" )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Surface (
                modifier =
                Modifier
                    .padding(10.dp)
                    .background(Color.Transparent),
            ){
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(color = Color.Blue)) {
                            append("Call Us At :")
                        }
                        withStyle(style = SpanStyle(
                            color = Color.Black,
                            textDecoration = TextDecoration.Underline,
                            fontFamily = FontFamily.Monospace
                        )) {
                            append("01882-502156,9876476467")
                        }
                    })
            }
        }
        // emial
        Row( modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)) {
            Card (
                modifier =
                Modifier.padding(10.dp),
            ){
                Icon(
                    modifier = Modifier.background(Color.Transparent),
                    imageVector = Icons.Filled.Email,
                    contentDescription ="phone" )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Surface (
                modifier =
                Modifier
                    .padding(10.dp)
                    .background(Color.Transparent),
            ){
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(color = Color.Blue)) {
                            append("Email Us At :")
                        }
                        withStyle(style = SpanStyle(
                            color = Color.Black,
                            textDecoration = TextDecoration.Underline,
                            fontFamily = FontFamily.Monospace
                        )) {
                            append("sanssys@gmail.com")
                        }
                    })
            }
        }
        Row( modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)) {
            Surface (
                modifier =
                Modifier
                    .padding(2.dp)
                    .padding(PaddingValues(start = 140.dp))
                    .background(Color.Transparent),
            ){
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(
                            color = Color.Black,
                            textDecoration = TextDecoration.Underline,
                            fontFamily = FontFamily.Monospace
                        )) {
                            append("sanssys@gmail.com")
                        }
                    })
            }
        }
        Row( modifier = Modifier
            .fillMaxWidth()
            .background(Color.Green)) {
            Card (
                modifier =
                Modifier.padding(10.dp),
            ){
                Icon(
                    modifier = Modifier.background(Color.Transparent),
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription ="phone" )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Surface (
                modifier =
                Modifier
                    .padding(10.dp)
                    .background(Color.Transparent),
            ){
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(color = Color.Blue)) {
                            append("Gandharab & Son’s Complex, 2nd floor, Session Court Road\n" +
                                    "Hoshiarpur (punjab) 146001")
                        }
                    })
            }
        }

        }
}

@Composable
fun TextFieldComposer() {
    Column(modifier =
                Modifier
                    .fillMaxSize(),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Center

                ) {
        var text by  remember{ mutableStateOf("Type Username here")}
        OutlinedTextField(value = text, onValueChange ={
            _text ->
            text = _text
        },
            label = {
                Text(text = "Name")
            },
            maxLines = 1,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = "email")
                }
            },
            trailingIcon = {
                IconButton(onClick = { println("Check button clicked!!") }) {
                    Icon(imageVector = Icons.Default.Check, contentDescription = "check")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions (
                onSearch = {
                    println("Search btn keybaord is clicked")
                }
            )
        ) */
    }
}

@Composable
fun CoilImage() {
    var password by remember {
        mutableStateOf("")
    }
    var rememberPassword by remember {
        mutableStateOf(false)
    }
    val icon = if(rememberPassword)
        painterResource(id = R.drawable.ic_baseline_visibility_24 )
    else
        painterResource(id = R.drawable.ic_baseline_visibility_off_24 )
   OutlinedTextField(value = password, onValueChange ={
       new ->
       password = new
   },
   placeholder = { Text(text = "Enter Password")},
   keyboardOptions = KeyboardOptions(
       keyboardType = KeyboardType.Password
   ),
       label = {
           Text(text = "Password")
       },
       trailingIcon = {
           IconButton(onClick = {
               rememberPassword = !rememberPassword
           }) {
               Icon(painter = icon  , contentDescription = "checked")
           }
       }
       ,
       visualTransformation =
           if(rememberPassword)
               VisualTransformation.None
            else
                PasswordVisualTransformation()
   )
}

@Composable
fun GradientButton(
    text:String,
    textColor:Color,
    gradient: Brush,
    onCLick: () -> Unit
) {
    Button(
        onClick = { onCLick },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent
        )
    ) {
        Box( modifier =
        Modifier
            .background(gradient)
            .padding(horizontal = 16.dp, vertical = 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = text, color = textColor)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutUs() {
    Column( modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Cyan)) {
        Row {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.about_logo),
                contentDescription ="image",
                contentScale = ContentScale.Crop,)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Column( modifier = Modifier
                .weight(3f)
                .padding(start = 10.dp, top = 10.dp)
                .background(color = Color.Transparent)) {
                Box(
                    contentAlignment = Alignment.CenterEnd,
                ){
                    Icon(imageVector = Icons.Default.Phone, contentDescription ="phone" )
                }
            }
            Column( modifier = Modifier
                .weight(14f)
                .background(color = Color.Transparent)) {
                Row (modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = "Phone Number",
                        fontSize = MaterialTheme.typography.subtitle1.fontSize,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row (modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = "123456789",
                        fontSize = MaterialTheme.typography.caption.fontSize,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                }
                Row (modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = "123456789",
                        fontSize = MaterialTheme.typography.caption.fontSize,
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Column( modifier = Modifier
                .weight(3f)
                .padding(start = 10.dp, top = 10.dp)
                .background(color = Color.Transparent)) {
                Box(
                    contentAlignment = Alignment.CenterEnd,
                ){
                    Icon(imageVector = Icons.Default.Email, contentDescription ="email" )
                }
            }
            Column( modifier = Modifier
                .weight(14f)
                .background(color = Color.Transparent)) {
                Row (modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = "Email Address",
                        fontSize = MaterialTheme.typography.subtitle1.fontSize,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row (modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = "123@123.com",
                        fontSize = MaterialTheme.typography.caption.fontSize,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.Underline
                    )
                }
                Row (modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = "123@123.com",
                        fontSize = MaterialTheme.typography.caption.fontSize,
                        color = Color.Blue,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Column( modifier = Modifier
                .weight(3f)
                .padding(start = 10.dp, top = 10.dp)
                .background(color = Color.Transparent)) {
                Box(
                    contentAlignment = Alignment.CenterEnd,
                ){
                    Icon(imageVector = Icons.Default.LocationOn, contentDescription ="location" )
                }
            }
            Column( modifier = Modifier
                .weight(14f)
                .background(color = Color.Transparent)) {
                Row (modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = "Address",
                        fontSize = MaterialTheme.typography.subtitle1.fontSize,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row (modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = "Gandharab & Son’s Complex, 2nd floor, Session Court Road",
                        fontSize = MaterialTheme.typography.overline.fontSize,
                        color = Color.Blue,
                        fontWeight = FontWeight.Normal
                    )
                }
                Row (modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = "Hoshiarpur (punjab) 146001",
                        fontSize = MaterialTheme.typography.caption.fontSize,
                        color = Color.Blue,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}