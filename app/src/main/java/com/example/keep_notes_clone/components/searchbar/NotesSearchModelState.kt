package com.example.keep_notes_clone.components.searchbar

import com.example.domain.models.Note

data class NotesSearchModelState(
  val searchText: String = "",
  val notes: List<Note> = arrayListOf(),
  val showProgressBar: Boolean = false
){
  companion object {
    val Empty = NotesSearchModelState()
  }
}
