package com.example.myapplication.DAO

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.Model.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM gameTable")
    fun getAllGames(): LiveData<List<Game>>

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Update
    suspend fun updateGame(game: Game)

}