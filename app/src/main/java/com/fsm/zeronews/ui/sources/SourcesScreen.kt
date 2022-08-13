package com.fsm.zeronews.ui.sources

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fsm.zeronews.ui.ErrorView
import com.fsm.zeronews.ui.Screen
import com.fsm.zeronews.ui.models.Source
import com.fsm.zeronews.ui.shared.CircularIndeterminateProgress
import com.fsm.zeronews.ui.theme.Typography
import com.fsm.zeronews.ui.theme.ZeroNewsTheme

@Composable
fun SourcesScreen(navController: NavController, viewModel: SourcesViewModel) {
    val sources by remember { viewModel.sources }
    val isLoading by remember { viewModel.isLoading }
    val error by remember {
        viewModel.error
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Sources", color = Color.White) })
    }) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularIndeterminateProgress(isVisible = isLoading)
            if (error) {
                ErrorView()
            } else {
                SourceList(sources) { navController.navigate(Screen.Articles.route) }
            }
        }
    }
}

@Composable
fun SourceList(sources: List<Source>, navigateToArticles: (Source) -> Unit) {
    LazyColumn {
        items(
            items = sources,
            key = { source -> source.id }
        ) { source ->
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
            Text(text = source.title, style = Typography.h5)
            Text(text = source.URL, style = Typography.caption)
            Text(text = source.description, style = Typography.body2)
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
