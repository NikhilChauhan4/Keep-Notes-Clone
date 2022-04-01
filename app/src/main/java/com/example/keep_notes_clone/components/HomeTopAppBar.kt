package com.example.keep_notes_clone.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun HomeTopAppBar(scaffoldState: ScaffoldState) {
  val coroutineScope = rememberCoroutineScope()
  TopAppBar(title = {
    Text("Keep Notes Clone", style = TextStyle(color = Color.White, fontSize = 20.sp))
  },
      navigationIcon = {
        IconButton(onClick = {
          coroutineScope.launch {
            scaffoldState.drawerState.open()
          }
        }) {
          Icon(imageVector = Icons.Default.Menu, contentDescription = null)
        }
      }
  )
}