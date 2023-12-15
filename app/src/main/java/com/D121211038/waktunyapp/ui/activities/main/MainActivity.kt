package com.D121211038.waktunyapp.ui.activities.main

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.D121211038.waktunyapp.R
import com.D121211038.waktunyapp.data.models.BestSellerBook
import com.D121211038.waktunyapp.data.models.TimesWire
import com.D121211038.waktunyapp.data.models.TopStory
import com.D121211038.waktunyapp.ui.activities.details.ArticleDetailActivity
import com.D121211038.waktunyapp.ui.activities.details.BestSellerBookDetailActivity
import com.D121211038.waktunyapp.ui.theme.WaktuNYAppTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaktuNYAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Scaffold(
                        containerColor = Color.White,
                        bottomBar = {
//                            Row(
//                                horizontalArrangement = Arrangement.SpaceEvenly,
//                                verticalAlignment = Alignment.CenterVertically,
//                                modifier = Modifier
//                                    .width(500.dp)
//                                    .height(50.dp)
//                                    .padding(50.dp, 0.dp)
//                                    .clip(shape = RoundedCornerShape(30.dp))
//                                    .background(Color.Blue)
//                            ) {
//                                Column(
//                                    horizontalAlignment = Alignment.CenterHorizontally,
//                                    modifier = Modifier
//                                        .width(40.dp)
//                                ) {
//                                    Image(
//                                        painter = painterResource(R.drawable.ic_home_active),
//                                        contentDescription = "icon",
//                                        modifier = Modifier.size(25.dp)
//                                    )
//                                    Text(
//                                        text = "Home",
//                                        color = colorResource(R.color.primary),
//                                        fontSize = 2.5.em,
//                                        lineHeight = 1.em
//                                    )
//                                }
//                                Column(
//                                    horizontalAlignment = Alignment.CenterHorizontally,
//                                    modifier = Modifier
//                                        .width(40.dp)
//                                ) {
//                                    Image(
//                                        painter = painterResource(R.drawable.ic_search),
//                                        contentDescription = "icon",
//                                        modifier = Modifier.size(25.dp)
//                                    )
//                                }
//                                Column(
//                                    horizontalAlignment = Alignment.CenterHorizontally,
//                                    modifier = Modifier
//                                        .width(40.dp)
//                                ) {
//                                    Image(
//                                        painter = painterResource(R.drawable.ic_article),
//                                        contentDescription = "icon",
//                                        modifier = Modifier.size(25.dp)
//                                    )
//                                }
//                            }
                        },
                        modifier = Modifier
                            .background(Color.Red)
                    ) {
                        Column(
                            modifier = Modifier.padding(it)
                        ) {
                            val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
                            MainScreen(mainViewModel.mainUiState)
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun MainScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        when(mainUiState) {
            is MainUiState.Success -> MainContent(
                mainUiState.timesWire.slice(0..2),
                mainUiState.topStories.slice(1..3),
                mainUiState.books.slice(0..4))
            is MainUiState.Error -> ErrorText()
            is MainUiState.Loading -> LoadingBar()
        }
    }

    @Composable
    private fun ErrorText() {
        Text(text = "ERROR")
    }

    @Composable
    fun LoadingBar() {
        Text(text = "SEDANG LOADING")
    }

    @Composable
    fun TimesWireCard(timesWireItem: TimesWire, modifier: Modifier = Modifier) {
        // External Link
        val context = LocalContext.current
        val linkToNews = remember { Intent(Intent.ACTION_VIEW, Uri.parse(timesWireItem.url)) }
        Log.d("TimesWireCard", timesWireItem.toString() ?: "none" )
        Card(
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(Color.Transparent),
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(6.dp, 10.dp)
                .clickable { context.startActivity(linkToNews) }
        ) {
            Row {
                Image(
                    painter = rememberAsyncImagePainter(timesWireItem.multimedia?.get(0)?.url),
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .background(Color.Transparent)
                )
                
                Spacer(modifier = Modifier.width(14.dp))
                
                Column(
                    modifier = Modifier.padding(0.dp, 0.dp, 14.dp, 0.dp)
                ) {
                    Text(
                        text = timesWireItem.title ?: "Ini title",
                        fontWeight = FontWeight.Bold,
                        lineHeight = 1.em,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = timesWireItem.byline ?: "by Unknown",
                        fontSize = 2.em,
                        lineHeight = 1.em,
                    )
                }
            }
        }
        Divider(color = Color.Gray.copy(alpha = 0.3f), modifier = Modifier.padding(6.dp, 0.dp))
    }

    @Composable
    fun TimesWireList(timesWire: List<TimesWire>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(timesWire) {timesWireItem ->
                TimesWireCard(timesWireItem = timesWireItem)
            }
        }
    }

    @Composable
    fun TopStoriesCard(topStoriesItem: TopStory, modifier: Modifier = Modifier) {
        val isoDate = topStoriesItem.publishedDate

        val formatter = DateTimeFormatter.ISO_DATE_TIME
        val parsedDate = LocalDate.parse(isoDate, formatter)

        val customFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy")
        val formattedDate = parsedDate.format(customFormatter)

//        Log.d("TopStoriesCard", topStoriesItem.toString() ?: "none" )
        Card(
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(Color.Transparent),
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp, 10.dp)
                .height(48.dp)
                .clickable {
                    val intent = Intent(this, ArticleDetailActivity::class.java)
                    intent.putExtra("ARTICLE", topStoriesItem)
                    startActivity(intent)
                }
        ) {
            Row {
                Column(
                    modifier = Modifier.padding(0.dp, 0.dp, 14.dp, 0.dp)
                ) {
                    Text(
                        text = topStoriesItem.title ?: "Ini title",
                        fontWeight = FontWeight.Bold,
                        fontSize = 3.em,
                        lineHeight = 1.em,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = formattedDate,
                        fontSize = 2.em
                    )
                }
            }
        }
        Divider(color = Color.Gray.copy(alpha = 0.3f), modifier = Modifier.padding(6.dp, 0.dp))
    }

    @Composable
    fun TopStoriesList(topStories: List<TopStory>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(topStories) {topStoriesItem ->
                TopStoriesCard(topStoriesItem = topStoriesItem)
            }
        }
    }

    @Composable
    fun BestSellerBooksCard(bestSellerBooksItem: BestSellerBook, modifier: Modifier = Modifier) {
        Log.d("BooksCard", bestSellerBooksItem.toString() ?: "none" )
        Card(
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(Color.Transparent),
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp, 10.dp)
                .height(200.dp)
                .width(130.dp)
                .clickable {
                    val intent = Intent(this, BestSellerBookDetailActivity::class.java)
                    intent.putExtra("BOOK", bestSellerBooksItem)
                    startActivity(intent)
                }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberAsyncImagePainter(bestSellerBooksItem.bookImage),
                    contentDescription = null,
                    modifier = Modifier
                        .width(70.dp)
                        .height(100.dp)
                        .background(Color.Transparent)
                )

                Spacer(modifier = Modifier
                    .height(8.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "${bestSellerBooksItem.weeksOnList} WEEKS ON THE LIST",
                        fontWeight = FontWeight.Light,
                        lineHeight = 1.em,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 2.em
                    )
                    Text(
                        text = bestSellerBooksItem.title ?: "Untitled",
                        fontWeight = FontWeight.Medium,
                        lineHeight = 1.em,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 3.5.em
                    )
                    Text(
                        text = "by ${bestSellerBooksItem.author ?: " Unknown "}",
                        lineHeight = 1.em,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 2.5.em
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = bestSellerBooksItem.description ?: "no description",
                        lineHeight = 1.em,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 2.5.em,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
        }
        Divider(color = Color.Gray.copy(alpha = 0.3f))
    }

    @Composable
    fun BestSellerBooksList(books: List<BestSellerBook>, modifier: Modifier = Modifier) {
        LazyRow(modifier = modifier) {
            items(books) {bestSellerBooksItem ->
                BestSellerBooksCard(bestSellerBooksItem = bestSellerBooksItem)
            }
        }
    }

    @Composable
    fun MainContent(
        timesWire: List<TimesWire>,
        topStories: List<TopStory>,
        books: List<BestSellerBook>,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 15.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.logo_header_app),
                    contentDescription = "Logo App",
                    modifier = Modifier.height(30.dp)
                )
            }
            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(0.dp, 10.dp)
                ) {
                    Text(
                        text = "Times Wire",
                        fontWeight = FontWeight.Black,
                        fontSize = 4.em,
                    )
                    Text(
                        text = "Real-time feeds from NYT article publishes",
                        color = colorResource(R.color.primary),
                        fontSize = 2.5.em,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                }
            }
            TimesWireList(timesWire, Modifier.height(340.dp))

            Spacer(modifier = Modifier.height(30.dp))

            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(0.dp, 10.dp)
                ) {
                    Text(
                        text = "Top Stories",
                        fontWeight = FontWeight.Black,
                        fontSize = 4.em
                    )
                    Text(
                        text = "View more",
                        color = colorResource(R.color.primary),
                        fontSize = 2.5.em,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                }
            }
            TopStoriesList(topStories, Modifier.height(220.dp))

            Spacer(modifier = Modifier.height(30.dp))

            Column {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Best Seller Books",
                        fontWeight = FontWeight.Black,
                        fontSize = 4.em
                    )
                    Text(
                        text = "View more",
                        color = colorResource(R.color.primary),
                        fontSize = 2.5.em,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                }
            }
            BestSellerBooksList(books, Modifier.height(250.dp))
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun MainScreenPreview() {
        WaktuNYAppTheme {

        }
    }
}