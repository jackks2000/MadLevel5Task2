package com.example.myapplication.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.Model.Game
import com.example.myapplication.Repository.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewModel(application: Application): AndroidViewModel(application) {

    private val ioScope = CoroutineScope(Dispatchers.IO)
    private val gameRepository = GameRepository(application.applicationContext)

    val reminders : LiveData<List<Game>> = gameRepository.getAllGames()

    fun insertReminder(game: Game){
        ioScope.launch {
            gameRepository.insertGame(game)
        }
    }

    fun deleteReminder(game: Game){
        ioScope.launch {
            gameRepository.deleteGame(game)
        }
    }
}