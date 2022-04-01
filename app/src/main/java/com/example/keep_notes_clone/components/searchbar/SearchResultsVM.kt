package com.example.keep_notes_clone.components.searchbar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class SearchResultsVM : ViewModel(){
  private val searchText : MutableStateFlow<String> = MutableStateFlow("")
  private val showProgressBar : MutableStateFlow<Boolean> = MutableStateFlow(false)
  private val searchResults : MutableStateFlow<List<Note>> = MutableStateFlow(listOf())

  val notesSearchModelState = combine(
      searchText,
      searchResults,
      showProgressBar
  ) {
    text, matchedUsers, showProgress ->

    NotesSearchModelState(
        text,
        matchedUsers,
        showProgress
    )
  }
  init {
    retrieveNotes()
  }

  private fun retrieveNotes() {

  }
  fun onSearchTextChanged(changedSearchText: String)= viewModelScope.launch(Dispatchers.IO) {
    searchText.value = changedSearchText.trim()
    if (changedSearchText.isEmpty()) {
      searchResults.value = arrayListOf()
    }else {
      val notesFromSearch = searchResults.value.filter { note ->
        note.title.contains(changedSearchText, true) ||
            note.body.contains(changedSearchText, true)
      }
      searchResults.value = notesFromSearch
    }
  }

  fun onClearClick() {
    searchText.value = ""
    searchResults.value = arrayListOf()
  }
}

