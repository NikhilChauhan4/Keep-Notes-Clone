package com.example.keep_notes_clone.screens

import androidx.compose.material.DrawerValue.Closed
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.keep_notes_clone.components.HomeTopAppBar
import com.example.keep_notes_clone.components.bottomnav.BottomNavigationBar
import com.example.keep_notes_clone.components.bottomnav.NavigationGraph
import com.example.keep_notes_clone.components.sidedrawer.NavDrawer

@Composable
fun HomeScreen() {
  val navController = rememberNavController()
  val scaffoldState = rememberScaffoldState(
      rememberDrawerState(initialValue = Closed)
  )
  Scaffold(
      scaffoldState = scaffoldState,
      bottomBar = {
        BottomNavigationBar(navController = navController)
      },
      drawerContent = {
        NavDrawer(scaffoldState = scaffoldState, navController = navController)
      },
      topBar = { HomeTopAppBar(scaffoldState = scaffoldState) }
  ) {
    NavigationGraph(navController = navController)
  }
}