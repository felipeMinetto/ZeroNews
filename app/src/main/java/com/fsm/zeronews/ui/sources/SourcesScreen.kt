package com.fsm.zeronews

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fsm.zeronews.ui.Screen
import com.fsm.zeronews.ui.theme.Typography
import com.fsm.zeronews.ui.theme.ZeroNewsTheme

@Composable
fun SourcesScreen(navController: NavController) {
    val sources = listOf(
        "Source 1",
        "Source 2",
        "Source 3",
        "Source 4",
        "Source 5",
        "Source 6"
    )
    SourceList(sources) { navController.navigate(Screen.Articles.route) }
}

@Composable
fun SourceList(sources: List<String>, navigateToArticles: (String) -> Unit) {
    LazyColumn {
        items(sources) { source ->
            SourceItem(source = source) { src -> navigateToArticles(src) }
        }
    }
}

@Composable
fun SourceItem(source: String, navigateToArticles: (String) -> Unit) {
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .clickable {
            Log.d("asd", "clicked article")
            navigateToArticles("123")
        }) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = source, style = Typography.subtitle1)
            Text(text = "Url", style = Typography.body2)
            Text(text = "Description", style = Typography.caption)
        }
    }
}

@Preview(showBackground = true)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun SourcePreview() {
    ZeroNewsTheme {
        SourceItem(source = "Source 1") {}
    }
}
