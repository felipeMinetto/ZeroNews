package com.fsm.zeronews

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

@Preview(showBackground = true)
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
    AsyncImage(
        model = "https://english.chosun.com/site/data/img_dir/2022/08/12/2022081200636_0.jpg",
        contentDescription = ""
    )
    Text(text = article)

}