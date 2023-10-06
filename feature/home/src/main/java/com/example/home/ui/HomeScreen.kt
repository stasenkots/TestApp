package com.example.home.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.*
import androidx.compose.ui.unit.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.home.data.Post
import com.example.testapp.ui.theme.LightBlue
import kotlinx.coroutines.flow.Flow


@Composable
fun HomeScreen() {
    val homeViewModel: HomeViewModel = viewModel(factory = HomeViewModel.Factory())
    val postsFlow = remember { homeViewModel.posts }

    HomeScreen { postsFlow }
}

@Composable
fun HomeScreen(postsFlow: () -> Flow<PagingData<Post>>) {
    val posts = postsFlow().collectAsLazyPagingItems()

    LazyColumn {
        if (posts.loadState.refresh == LoadState.Loading) {
            item {
                Text(
                    text = "Waiting for posts to load",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
        items(
            count = posts.itemCount
        ) { index ->
            posts[index]?.let { PostView(it) }
        }

        if (posts.loadState.append == LoadState.Loading) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    }

}

@Composable
private fun PostView(post: Post) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White, shape = RoundedCornerShape(CornerSize(10.dp)))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = LightBlue, shape = RoundedCornerShape(CornerSize(1.dp)))
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = post.username,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }

        Text(
            modifier = Modifier.padding(8.dp),
            text = post.title,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        Divider()
        Text(
            modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp),
            text = post.description,
            fontSize = 14.sp,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis

        )
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(CornerSize(10.dp))
                )
        ) {

        }
        AsyncImage(
            model = post.image,
            contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .padding(
                    vertical = 10.dp,
                    horizontal = 15.dp
                )

        )
    }

}

@Preview
@Composable
fun PostViewPreview() {
    HomeScreen()
}
