package com.fsm.zeronews.presentation.ui.articles

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fsm.zeronews.R
import com.fsm.zeronews.presentation.models.Article
import com.fsm.zeronews.presentation.ui.theme.ZeroNewsTheme

@Composable
fun ArticlesScreen() {
    val articles = listOf(
        Article("Article 1",
            "Some nice article from the source",
            "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
            "John Doe",
            "01-01-2022"),
        Article("Article 2",
            "Some nice article from the source2",
            "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
            "John Doe",
            "01-01-2022"),
        Article("Article 3",
            "Some nice article from the source3",
            "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
            "John Doe",
            "01-01-2022"),
        Article("Article 4",
            "Some nice article from the source4",
            "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
            "John Doe",
            "01-01-2022"),
        Article("Article 5",
            "Some nice article from the source5",
            "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
            "John Doe",
            "01-01-2022"),
        Article("Article 6",
            "Some nice article from the source6",
            "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
            "John Doe",
            "01-01-2022"),
    )

    ArticleList(articles)
}

@Composable
fun ArticleList(articles: List<Article>) {
    LazyColumn {
        items(articles) { article ->
            ArticleItem(article)
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
                placeholder = painterResource(id = R.drawable.article_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Column(modifier = Modifier
                .padding(12.dp)) {
                Text(text = article.title)
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(text = article.author)
                    Spacer(modifier = Modifier)
                    Text(text = article.publishedDate)
                }
                Text(text = article.description)
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
