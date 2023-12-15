package com.D121211038.waktunyapp.ui.activities.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import coil.request.ImageRequest
import com.D121211038.waktunyapp.R
import com.D121211038.waktunyapp.data.models.BestSellerBook
import com.D121211038.waktunyapp.data.models.BuyLinksItem
import com.D121211038.waktunyapp.ui.activities.main.MainViewModel
import com.D121211038.waktunyapp.ui.layout.bottomnavigation.BottomNavigation
import com.D121211038.waktunyapp.ui.theme.WaktuNYAppTheme

class BestSellerBookDetailActivity: ComponentActivity() {
    private var selectedBook: BestSellerBook? = null
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        selectedBook = intent.getParcelableExtra("BOOK")
        super.onCreate(savedInstanceState)
        setContent {
            WaktuNYAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
//                        bottomBar = {}
                    ) {
                        DetailScreen(Modifier.padding(it))
                    }
                }
            }
        }
    }

    @Composable
    fun DetailScreen(modifier: Modifier) {
        val navController = rememberNavController()
        Column(
            modifier = Modifier.padding(20.dp)
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
                        text = "Best Seller Book",
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
            Spacer(modifier = Modifier.height(30.dp))
            BookDetail()
        }
    }

    @Composable
    fun BookDetail() {
        // External Link
        val context = LocalContext.current
        val linkToAmazon = remember { Intent(Intent.ACTION_VIEW, Uri.parse(selectedBook?.amazonProductUrl)) }

        LazyColumn() {
            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp, 0.dp)
                ) {
                    Row(
                        modifier = Modifier
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(context = LocalContext.current)
                                .data(selectedBook?.bookImage)
                                .crossfade(true)
                                .build(),
                            contentDescription = selectedBook?.title,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .width(100.dp)
                                .height(160.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = selectedBook?.title ?: "Untitled",
                                fontSize = 5.em,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "by ${selectedBook?.author ?: "Unknown"}",
                                fontSize = 3.em,
                            )
                            Spacer(modifier = Modifier.height(20.dp))
                            Row {
                                Text(
                                    text = "Rank: #${selectedBook?.rank}",
                                    fontSize = 2.5.em,
                                    color = Color.Gray
                                )     
                                Spacer(modifier = Modifier.width(4.dp))
                                Text(
                                    text = "Last week rank: #${selectedBook?.rankLastWeek}",
                                    fontSize = 2.5.em,
                                    color = Color.Gray
                                )
                            }
                            Text(
                                text = "Weeks on list: ${selectedBook?.weeksOnList} weeks",
                                fontSize = 2.5.em,
                                color = Color.Gray
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Column {
                    Text(
                        text = "Book Description",
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = selectedBook?.description ?: "no description",
                        textAlign = TextAlign.Justify
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Button(
                        onClick = { context.startActivity(linkToAmazon) },
                        colors = ButtonDefaults.buttonColors(Color.Transparent),
                        modifier = Modifier
                            .border(2.dp, colorResource(R.color.primary), RoundedCornerShape(50))
                            .height(40.dp)
                    ) {
                        Text(
                            text = "Amazon product link",
                            color = colorResource(R.color.primary),
                            fontSize = 3.em,
                            modifier = Modifier
                        )
                        Spacer(modifier = Modifier.width(14.dp))
                        Image(
                            painter = painterResource(R.drawable.ic_link_primary),
                            contentDescription = null,
                            modifier = Modifier.size(12.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(80.dp))
                    Text(text = "other buy links:", color = Color.Gray, fontSize = 3.em)
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyRow() {
                        items(selectedBook?.buyLinks?.drop(1) ?: emptyList<BuyLinksItem>()) {link ->
                            val linkToUrl = remember { Intent(Intent.ACTION_VIEW, Uri.parse(link?.url)) }
                            Button(
                                onClick = { context.startActivity(linkToUrl) },
                                colors = ButtonDefaults.buttonColors(colorResource(R.color.primary)),
                                modifier = Modifier.height(35.dp)
                            ) {
                                Text(
                                    text = link?.name ?: "link",
                                    fontSize = 2.5.em,
                                )
                            }
                            Spacer(modifier = Modifier.width(4.dp))
                        }
                    }
                }
            }
        }
    }
}