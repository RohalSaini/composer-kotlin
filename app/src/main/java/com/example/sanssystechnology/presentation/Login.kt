package com.example.sanssystechnology.presentation

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sanssystechnology.R
import com.example.sanssystechnology.ui.theme.Shapes


@ExperimentalMaterialApi
@Composable
fun Login(
    text:String = "Sign Up With Goggle",
    loadingText:String = "Creating Account",
    OnCLicked: () -> Unit
) {
    var clicked by remember {
        mutableStateOf(false)
    }
    Surface(
        onClick = { clicked = !clicked},
        shape = Shapes.medium,
        border = BorderStroke(
            width = 1.dp,
            color = Color.LightGray),
        color = MaterialTheme.colors.surface
    ) {
        Row(
            modifier =
                Modifier.padding(
                    start = 34.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                ).animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_sports_basketball_24),
                contentDescription = "google",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if(clicked) loadingText else text)
            if(clicked) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = MaterialTheme.colors.primary
                )
                OnCLicked()
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview(showBackground = true)
private  fun GoggleButtonPreview() {
    //Login()
}