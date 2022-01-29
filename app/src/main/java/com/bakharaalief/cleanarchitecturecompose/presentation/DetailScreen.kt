package com.bakharaalief.cleanarchitecturecompose.presentation

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bakharaalief.cleanarchitecturecompose.R
import java.util.*


@Composable
fun DetailScreen(){
    Scaffold(
        topBar = {
            MyAppBar()
        }
    ) {
        Content()
    }
}

@Composable
fun MyAppBar(){
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription ="Arrow Back")
            }
        },
        backgroundColor = Color.White,
        elevation = 0.dp
    )
}

@Composable
fun Content(){
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        //image cover
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp)),
            painter = painterResource(id = R.drawable.image),
            contentDescription = "Profile",
            contentScale = ContentScale.Crop
        )
        
        Spacer(modifier = Modifier.height(10.dp))

        //title
        Text(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. ever since the 1500s.",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
        )

        Spacer(modifier = Modifier.height(10.dp))

        //title
        Text(
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                    "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled " +
                    "it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. " +
                    "It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, " +
                    "and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
            fontSize = 16.sp,
        )

        Spacer(modifier = Modifier.height(10.dp))
    }
}