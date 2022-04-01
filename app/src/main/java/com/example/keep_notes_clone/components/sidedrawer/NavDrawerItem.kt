package com.example.keep_notes_clone.components.sidedrawer

import androidx.annotation.DrawableRes
import com.example.keep_notes_clone.R

sealed class NavDrawerItem(
  var route: String,
  @DrawableRes var icon: Int,
  var title: String
) {
  object Notes : NavDrawerItem("notes_screen", R.drawable.ic_outline_lightbulb_24,"Notes")
  object Reminders : NavDrawerItem("reminders_screen", R.drawable.ic_outline_notifications_24,"Reminders")
  object Inspiration : NavDrawerItem("inspiration_screen", R.drawable.ic_outline_label_24,"Inspiration")
  object Personal : NavDrawerItem("personal_screen", R.drawable.ic_outline_label_24,"Personal")
  object Work : NavDrawerItem("work_screen", R.drawable.ic_outline_label_24,"Work")
  object CreateNewLabel : NavDrawerItem("create_new_screen", R.drawable.ic_outline_add_24,"Create New Label")
  object Archive : NavDrawerItem("archive_screen", R.drawable.ic_outline_archive_24,"Archive")
  object Trash : NavDrawerItem("trash_screen", R.drawable.ic_outline_delete_24,"Trash")
  object Settings : NavDrawerItem("settings_screen", R.drawable.ic_outline_settings_24,"Settings")
  object HelpAndFeedback : NavDrawerItem("help_and_feedback_screen", R.drawable.ic_outline_help_outline_24,"Help & Feedback")
}
