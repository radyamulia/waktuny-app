package com.D121211038.waktunyapp.ui.activities.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.D121211038.waktunyapp.R
import com.D121211038.waktunyapp.data.models.TopStory
import com.D121211038.waktunyapp.ui.activities.main.MainViewModel
import com.D121211038.waktunyapp.ui.layout.bottomnavigation.BottomNavigation
import com.D121211038.waktunyapp.ui.theme.WaktuNYAppTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ArticleDetailActivity: ComponentActivity() {
    private var selectedArticle: TopStory? = null
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        selectedArticle = intent.getParcelableExtra("ARTICLE")
        super.onCreate(savedInstanceState)
        setContent {
            WaktuNYAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {}
                    ) {
                        DetailScreen(modifier = Modifier.padding(it))
                    }
                }
            }
        }
    }

    @Composable
    fun DetailScreen(modifier: Modifier) {
        val navController = rememberNavController()
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(0.dp, 20.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.btn_back),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
//                        .clickable { navController.popBackStack()  }
                )
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(
                        text = "Article",
                        fontWeight = FontWeight.Bold,
                        fontSize = 6.em,
                        lineHeight = 0.5.em,
                        modifier = Modifier.padding(0.dp)
                    )
                    Text(
                        text = "from NYTimes.com",
                        fontWeight = FontWeight.Light,
                        fontSize = 3.em,
                        lineHeight = 1.em,
                        color = Color.Gray
                    )
                }
            }
            ArticleDetail()
        }
    }

    @Composable
    fun ArticleDetail() {
        // Date Parser
        val formatter = DateTimeFormatter.ISO_DATE_TIME
        val parsedDate = LocalDate.parse(selectedArticle?.publishedDate, formatter)
        val customFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy")

        // External Link
        val context = LocalContext.current
        val linkToArticle = remember { Intent(Intent.ACTION_VIEW, Uri.parse(selectedArticle?.url)) }

//        Log.d("Detail", selectedArticle.toString())
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(50.dp, 0.dp)
                        .fillMaxWidth()
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(selectedArticle?.multimedia?.get(1)?.url)
                            .crossfade(true)
                            .build(),
                        contentDescription = selectedArticle?.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
                Column(

                ) {
                    Text(
                        text = "by ${selectedArticle?.byline ?: "Unknown"}",
                        fontSize = 3.em,
                        color = Color.Gray,
                        lineHeight = 1.em ,
                        modifier = Modifier.padding(50.dp, 0.dp)
                    )
                    Spacer(modifier = Modifier.height(25.dp))
                    LazyRow(
                        userScrollEnabled = false
                    ) {
                        items(items = selectedArticle?.perFacet ?: emptyList<String>()) { item ->
                            Text(
                                color = Color.White,
                                text = "$item",
                                fontSize = 2.em,
                                modifier = Modifier
                                    .background(colorResource(R.color.primary))
                                    .padding(4.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                        }
                    }
                    Text(
                        fontWeight = FontWeight.Bold,
                        text = selectedArticle?.title ?: "Title Get Error",
                        fontSize = 5.em
                    )
                    Text(
                        text = parsedDate.format(customFormatter) ?: "",
                        fontSize = 2.5.em
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = selectedArticle?.jsonMemberAbstract ?: "Description Get Error",
                        textAlign = TextAlign.Justify
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Button(
                        onClick = { context.startActivity(linkToArticle) },
                        colors = ButtonDefaults.buttonColors(colorResource(R.color.primary))
                    ) {
                        Text(
                            text = "Go to the link",
                            color = Color.White,
                            modifier = Modifier
                        )
                        Spacer(modifier = Modifier.width(14.dp))
                        Image(
                            painter = painterResource(R.drawable.ic_link),
                            contentDescription = null,
                            modifier = Modifier.size(12.dp)
                        )
                    }
                }
            }
        }
    }
}