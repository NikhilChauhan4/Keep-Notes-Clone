package com.example.keep_notes_clone.components.searchbar

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.keep_notes_clone.components.KeepNotesAppBar

@Composable
fun SearchBarUI(
  searchText: String,
  placeholderText: String = "",
  onSearchTextChanged: (String) -> Unit = {},
  onClearClick: () -> Unit = {},
  onNavigateBack: () -> Unit = {},
  matchesFound: Boolean,
  results: @Composable () -> Unit = {}
) {
  Box {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
      KeepNotesAppBar(
          searchText,
          placeholderText,
          onSearchTextChanged,
          onClearClick,
          onNavigateBack
      )

      if (matchesFound) {
        Text("Results", modifier = Modifier.padding(8.dp), fontWeight = FontWeight.Bold)
        results()
      } else {
        if (searchText.isNotEmpty()) {
          Log.d("inside search results", "ShowSearchResultsUI: " + "no results found")
        }
      }
    }
  }
}