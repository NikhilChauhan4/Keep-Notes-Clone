package com.example.keep_notes_clone.components.sidedrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.keep_notes_clone.R
import kotlinx.coroutines.launch

@Composable
fun NavDrawer(
  scaffoldState: ScaffoldState,
  navController: NavController
) {
  val items = listOf(
      NavDrawerItem.Notes,
      NavDrawerItem.Reminders,
      NavDrawerItem.Inspiration,
      NavDrawerItem.Personal,
      NavDrawerItem.Work,
      NavDrawerItem.CreateNewLabel,
      NavDrawerItem.Archive,
      NavDrawerItem.Trash,
      NavDrawerItem.Settings,
      NavDrawerItem.HelpAndFeedback
  )
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val currentRoute = navBackStackEntry?.destination?.route
  val coroutineScope = rememberCoroutineScope()
  Column {
    DrawerHeader()
    items.forEachIndexed { index, item ->
      when (index) {
        2 -> {
          Divider(
              color = Color.Black, modifier =
          Modifier.padding(top = 8.dp, bottom = 8.dp)
          )
          RowLabels(item, false) {
            navController.navigate(item.route)
          }
        }
        6 -> {
          Divider(color = Color.Black, modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
        }
      }
      NavDrawerItem(item = item, selected = currentRoute == item.route, onItemClick = {
        navController.navigate(item.route) {
          navController.graph.startDestinationRoute?.let { route ->
            popUpTo(route) {
              saveState = true
            }
          }
          launchSingleTop = true
          restoreState = true
        }
        coroutineScope.launch {
          scaffoldState.drawerState.close()
        }
      })
    }
  }
}

@Composable
fun RowLabels(
  item: NavDrawerItem,
  selected: Boolean,
  onItemClick: (NavDrawerItem) -> Unit
) {
  Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
          .fillMaxWidth()
          .clickable {
            onItemClick(item)
          }
          .padding(start = 16.dp, bottom = 8.dp),
      horizontalArrangement = Arrangement.SpaceBetween
  ) {
    Text(
        text = "Labels", modifier =
    Modifier.padding(top = 8.dp, bottom = 8.dp)
    )
    Text(
        text = "Edit", modifier = Modifier.padding(
        top = 8.dp, bottom = 8.dp,
        end = 24.dp
    )
    )
  }
}

@Composable
fun DrawerHeader() {
  Text(
      text = "Google Keep",
      modifier = Modifier.padding(16.dp),
      style = TextStyle(Color.Black, fontSize = 24.sp)
  )
}

@Composable
fun NavDrawerItem(
  item: NavDrawerItem,
  selected: Boolean,
  onItemClick: (NavDrawerItem) -> Unit
) {
  val background = if (selected) R.color.teal_200 else android.R.color.transparent
  Row(
      verticalAlignment = Alignment.CenterVertically,
      modifier = Modifier
          .fillMaxWidth()
          .clickable {
            onItemClick(item)
          }
          .background(color = colorResource(id = background))
          .padding(start = 16.dp, bottom = 8.dp)
  ) {
    Image(
        painter = painterResource(id = item.icon), contentDescription = null,
        colorFilter = ColorFilter.tint(Color.Black),
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .height(45.dp)
            .width(45.dp)
    )
    Spacer(modifier = Modifier.width(16.dp))
    Text(
        text = item.title,
        fontSize = 18.sp,
        color = Color.Black
    )
  }
}