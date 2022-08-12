package com.fsm.zeronews

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun SourcesScreen() {
    val sources = listOf(
        "Source 1",
        "Source 2",
        "Source 3",
        "Source 4",
        "Source 5",
        "Source 6"
    )
    SourceList(sources)
}

@Composable
fun SourceList(sources: List<String>) {
    LazyColumn {
        items(sources) { source ->
            SourceItem(source = source)
        }
    }
}

@Composable
fun SourceItem(source: String) {
    Column {
        Text(text = source)
        Text(text = "Url")
        Text(text = "Description")
    }
}
