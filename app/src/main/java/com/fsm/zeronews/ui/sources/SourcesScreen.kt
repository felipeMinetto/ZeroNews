package com.fsm.zeronews.ui.sources

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
import com.fsm.zeronews.ui.models.Source
import com.fsm.zeronews.ui.theme.Typography
import com.fsm.zeronews.ui.theme.ZeroNewsTheme

@Composable
fun SourcesScreen(navController: NavController) {
    val sources = listOf(
        Source("s01", "Source 1", "description of the source", "https://source1.com"),
        Source("s02", "Source 2", "description of the source", "https://source2.com"),
        Source("s03", "Source 3", "description of the source", "https://source3.com"),
        Source("s04", "Source 4", "description of the source", "https://source4.com"),
        Source("s05", "Source 5", "description of the source", "https://source5.com"),
        Source("s06", "Source 6", "description of the source", "https://source6.com"),
        Source("s07", "Source 7", "description of the source", "https://source7.com"),
    )
    SourceList(sources) { navController.navigate(Screen.Articles.route) }
}

@Composable
fun SourceList(sources: List<Source>, navigateToArticles: (Source) -> Unit) {
    LazyColumn {
        items(sources) { source ->
            SourceItem(source = source) { src -> navigateToArticles(src) }
        }
    }
}

@Composable
fun SourceItem(source: Source, navigateToArticles: (Source) -> Unit) {
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .clickable {
            Log.d("asd", "clicked article")
            navigateToArticles(source)
        }) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = source.title, style = Typography.subtitle1)
            Text(text = source.URL, style = Typography.body2)
            Text(text = source.description, style = Typography.caption)
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
        val source = Source("s01", "Source 1", "description of the source", "https://source1.com")
        SourceItem(source = source) {}
    }
}
