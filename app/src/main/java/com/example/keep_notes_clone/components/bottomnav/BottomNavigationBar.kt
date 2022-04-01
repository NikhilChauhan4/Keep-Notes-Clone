package com.example.keep_notes_clone.components.bottomnav

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.keep_notes_clone.R

@Composable
fun BottomNavigationBar(navController: NavController) {
  val items = listOf(
      NavBarItem.CreateSimpleNote,
      NavBarItem.ShowAllNote,
      NavBarItem.CreateListNote,
      NavBarItem.DrawTextNote,
      NavBarItem.CreateAudioNote,
      NavBarItem.CreateImageNote
  )
  BottomNavigation(
      backgroundColor = colorResource(id = R.color.teal_200),
      contentColor = Color.Black
  ) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    items.forEach { item ->
      BottomNavigationItem(
          selected = currentRoute == item.route, onClick = {
        navController.navigate(item.route) {
          navController.graph.startDestinationRoute?.let { route ->
            popUpTo(route) {
              saveState = true
            }
            launchSingleTop = true
            restoreState = true
          }
        }
      }, label = {
        Text(text = "title")
      }, selectedContentColor = Color.Black, unselectedContentColor = Color.Black.copy(0.4f),
          icon = {
            Icon(painter = painterResource(id = item.icon), contentDescription = null)
          }
      )
    }
  }
}