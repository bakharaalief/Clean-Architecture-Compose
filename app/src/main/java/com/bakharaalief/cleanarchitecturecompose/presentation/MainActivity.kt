package com.bakharaalief.cleanarchitecturecompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.bakharaalief.cleanarchitecturecompose.R
import com.bakharaalief.cleanarchitecturecompose.domain.model.Post
import com.bakharaalief.cleanarchitecturecompose.presentation.ui.theme.BelajarDaggerComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //view model
        val viewModel = ViewModelProvider(this)[PostVM::class.java]

        setContent {
            BelajarDaggerComposeTheme {
                MainScreen(viewModel)
            }
        }
    }
}

@Composable
fun MyAppBar(){
    TopAppBar(
        title = {
            Text(text = "Posts")
        }
    )
}

@Composable
fun MainScreen(postVM: PostVM){

    //A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = {
                MyAppBar()
            }
        ) {
            val state = postVM.state.value

            when {
                state.isLoading -> LoadingState()
                state.error.isNotBlank() -> ErrorState(message = state.error)
                else -> SuccessState(listPost = state.post)
            }
        }
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
fun SuccessState(listPost : List<Post>){
    LazyColumn{
        items(listPost) { post ->
            PostItem(post)
        }
    }
}

@Composable
fun PostItem(post: Post){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        backgroundColor = colorResource(id = R.color.purple_500),
        elevation = 2.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {

            //text title
            Text(
                text = post.title ?: "Empty",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            )
            
            Spacer(modifier = Modifier.height(5.dp))

            //text body
            Text(
                text = post.body ?: "Empty"
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
