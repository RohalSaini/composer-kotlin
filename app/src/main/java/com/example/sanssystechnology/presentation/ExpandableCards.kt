package com.example.sanssystechnology.presentation

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.sanssystechnology.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun ExpandableCard() {
    var expandable by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if(expandable) 180f else 0f
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 800,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.medium,
        onClick = {
            expandable = !expandable
        }
    ){
        Column(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row (verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    modifier = Modifier.weight(6f),
                    text = "My Title",
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                    )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationState)
                    ,
                    onClick = {
                        expandable = !expandable
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "dropDown"
                        )
                }

            }
            if(expandable) {
                Text(
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Normal,
                    overflow = TextOverflow.Ellipsis,
                    text ="1ferf fer gfmref erf e fer g erf erg er g erf e fe d fg rt g dfv d g dh dh d g dh df h d fgd fg dfg df fg dfh fd " )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview(showBackground = true)
fun DefaultView() {
    Column {
        ExpandableCard()
        Text(
            modifier = Modifier.padding(20.dp),
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Normal,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
            text ="1ferf fer gfmref erf e fer g erf erg er g erf e fe d fg rt g dfv d g dh dh d g dh df h d fgd fg dfg df fg dfh fd " )
    }

}