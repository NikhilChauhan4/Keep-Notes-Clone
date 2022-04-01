package com.example.keep_notes_clone.components.bottomnav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.keep_notes_clone.screens.ShowAllNoteScreen

@Composable
fun NavigationGraph(navController: NavHostController){
  NavHost(navController = navController, startDestination = NavBarItem.ShowAllNote.route){
    composable(NavBarItem.CreateSimpleNote.route){
      ShowAllNoteScreen()
    }
    composable(NavBarItem.CreateListNote.route){
      ShowAllNoteScreen()
    }
    composable(NavBarItem.DrawTextNote.route){
      ShowAllNoteScreen()
    }
    composable(NavBarItem.CreateAudioNote.route){
      ShowAllNoteScreen()
    }
    composable(NavBarItem.CreateImageNote.route){
      ShowAllNoteScreen()
    }
  }
}