package com.example.keep_notes_clone.components.bottomnav

import androidx.annotation.DrawableRes
import com.example.keep_notes_clone.R

sealed class NavBarItem(var route: String,@DrawableRes var icon: Int,var title: String){
  object CreateSimpleNote: NavBarItem("create_note", R.drawable.ic_outline_add_24,"Create Note")
  object ShowAllNote: NavBarItem("create_note", R.drawable.ic_outline_add_24,"Create Note")
  object CreateListNote: NavBarItem("create_list_note", R.drawable.ic_outline_check_box_24,"Create List Note")
  object DrawTextNote: NavBarItem("draw_text_note", R.drawable.ic_outline_draw_24,"Draw Text Note")
  object CreateAudioNote: NavBarItem("create_audio_note", R.drawable.ic_outline_mic_none_24,"Create Audio Note")
  object CreateImageNote: NavBarItem("create_image_note", R.drawable.ic_outline_insert_photo_24,"Create Image Note")
}
