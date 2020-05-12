package com.benilov.gameday2.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class GameViewModel(
        savedStateHandle: SavedStateHandle
) : ViewModel() {
    val gameId : String = savedStateHandle["gameId"] ?:
            throw IllegalArgumentException("missing user id")
    val game : LiveData<Game> = TODO()
}