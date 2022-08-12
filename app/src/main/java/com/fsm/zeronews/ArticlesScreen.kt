package com.fsm.zeronews

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.fsm.zeronews.ui.theme.ZeroNewsTheme

@Composable
fun ArticlesScreen() {
    val articles = listOf(
        "Article 1",
        "Article 2",
        "Article 3",
        "Article 4",
        "Article 5",
        "Article 6"
    )

    ArticleList(articles)
}

@Composable
fun ArticleList(articles: List<String>) {
    LazyColumn {
        items(articles) { article ->
            ArticleItem(article)
        }
    }
}

@Composable
fun ArticleItem(article: String) {
    Card(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            AsyncImage(
                model = "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
                placeholder = painterResource(id = R.drawable.article_image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Publish Date")
            Text(text = article)
            Text(text = "Author")
            Text(text = "Description")
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
        ArticleItem(article = "Article X")
    }
}
