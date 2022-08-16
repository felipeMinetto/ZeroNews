package com.fsm.zeronews.presentation.ui.articles

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.fsm.zeronews.presentation.models.Article
import com.fsm.zeronews.presentation.ui.theme.Typography
import com.fsm.zeronews.presentation.ui.theme.ZeroNewsTheme
import kotlinx.coroutines.flow.Flow

@Composable
fun ArticlesScreen(viewModel: ArticlesViewModel, source: String) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Articles", color = Color.White) })
    }) {
        ArticleList(articles = viewModel.fetchArticles(source))
    }
}

@Composable
fun ArticleList(articles: Flow<PagingData<Article>>) {
    val lazyArticles = articles.collectAsLazyPagingItems()
    LazyVerticalGrid(columns = GridCells.Adaptive(250.dp)) {
        items(lazyArticles.itemCount) { index ->
            lazyArticles[index]?.let {
                ArticleItem(it)
            }
        }
    }
}

@Composable
fun ArticleItem(article: Article) {
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    ) {
        Column {
            AsyncImage(
                model = article.imageURL,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f),
                contentScale = ContentScale.FillWidth
            )
            Column(modifier = Modifier
                .padding(12.dp)) {
                Text(text = article.title, style = Typography.h6)
                Text(text = "${article.publishedDate} by ${article.author}",
                    style = Typography.caption,
                    color = Color.Gray)
                Text(text = article.description, style = Typography.body1)
            }
        }
    }

}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ArticlePreview() {
    ZeroNewsTheme {
        val article = Article("Article 1",
            "Some nice article from the source",
            "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
            "John Doe",
            "01-01-2022")
        ArticleItem(article = article)
    }
}
