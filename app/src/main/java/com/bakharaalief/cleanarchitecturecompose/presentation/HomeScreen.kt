package com.bakharaalief.cleanarchitecturecompose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bakharaalief.cleanarchitecturecompose.R
import com.bakharaalief.cleanarchitecturecompose.domain.model.Post

@Composable
fun MainScreen(postVM: PostVM, navController: NavController){

    val state = postVM.state.value

    when {
        state.isLoading -> LoadingState()
        state.error.isNotBlank() -> ErrorState(message = state.error)
        else -> SuccessState(state.post, navController)
    }
}

@Composable
fun LoadingState(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun SuccessState(listPost : List<Post>, navController: NavController){
    LazyColumn(modifier = Modifier.padding(horizontal = 15.dp)) {
        item {
            GreetAndProfile()
        }

        items(listPost) { post ->
            PostItem(post, navController)
        }
    }
}

@Composable
fun GreetAndProfile(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        //hello section
        Column(
            modifier = Modifier.height(50.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = "Hi John", fontWeight = FontWeight.Bold)
            Text(text = "Good Morning", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }

        //profile section
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(shape = CircleShape)
                .border(width = 2.dp, color = Color.Black, shape = CircleShape),
            painter = painterResource(id = R.drawable.peep2),
            contentDescription = "Profile"
        )
    }
}

@Composable
fun PostItem(post: Post, navController: NavController){
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            navController.navigate(Screen.DetailScreenDestination().destination)
        }
        .padding(bottom = 10.dp)){
        Image(
            modifier = Modifier
                .width(180.dp)
                .height(160.dp)
                .clip(RoundedCornerShape(10.dp)),
            painter = painterResource(id = R.drawable.image),
            contentDescription = "Profile",
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .padding(10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = post.title ?: "Empty",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            )
        }
    }
}


@Composable
fun ErrorState(message: String){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text( text = message )
    }
}