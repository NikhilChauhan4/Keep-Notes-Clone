package com.example.keep_notes_clone.components.searchbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavHostController
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect

@Composable
fun SearchResultsUI(
  navHostController: NavHostController,
  searchResultsVM: SearchResultsVM
) {
  val notesSearchModelState by rememberFlowWithLifecycle(searchResultsVM.notesSearchModelState)
      .collectAsState(initial = NotesSearchModelState.Empty)
  SearchBarUI(
      searchText = notesSearchModelState.searchText,
      matchesFound = notesSearchModelState.notes.isNotEmpty(),
      onClearClick = {
        searchResultsVM.onClearClick()
      },
      onNavigateBack = {
        navHostController.popBackStack()
      }
  )
}

@Composable
fun <T> rememberFlowWithLifecycle(
  flow: Flow<T>,
  lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle,
  minActiveState: Lifecycle.State = Lifecycle.State.STARTED
): Flow<T> = remember(flow, lifecycle) {
  flow.flowWithLifecycle(
      lifecycle = lifecycle,
      minActiveState = minActiveState
  )
}

@OptIn(InternalCoroutinesApi::class)
@Composable
fun <T> rememberStateWithLifecycle(
  stateFlow: StateFlow<T>,
  lifecycle: Lifecycle = LocalLifecycleOwner.current.lifecycle,
  minActiveState: Lifecycle.State = Lifecycle.State.STARTED
): State<T> {
  val initialValue = remember(stateFlow) { stateFlow.value }
  return produceState(
      key1 = stateFlow, key2 = lifecycle, key3 = minActiveState,
      initialValue = initialValue
  ) {
    lifecycle.repeatOnLifecycle(minActiveState) {
      stateFlow.collect {
        this@produceState.value = it
      }
    }
  }
}