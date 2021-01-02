package com.example.myapplication.Adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model.Game
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemGameBinding
import kotlinx.android.synthetic.main.item_game.view.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.days

class GameAdapter (private val games: List<Game>): RecyclerView.Adapter<GameAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemGameBinding.bind(itemView)


        fun databind(game:Game){

            itemView.tvTitle.text = game.title
            itemView.tvPlatform.text = game.platform
            itemView.tvReleaseDate.text = "release: ${game.releaseDate}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            ViewHolder{
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game,parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(games[position])
    }

    override fun getItemCount(): Int {
        return games.size
    }


}