package com.example.myapplication

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.myapplication.Model.Game
import com.example.myapplication.ViewModel.GameViewModel
import kotlinx.android.synthetic.main.fragment_add_reminder.*
import java.text.SimpleDateFormat
import java.util.*

class AddReminderFragment : Fragment() {

    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_reminder, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add_reminder_btn.setOnClickListener{
            onAddReminder()
        }

    }


    @RequiresApi(Build.VERSION_CODES.O)
    private fun onAddReminder(){
        val gameTitle = etTitle.text.toString()
        val gamePlatform = etPlatform.text.toString()
        val releaseDay = etDay.text.toString()
        val releaseMonth = etMonth.text.toString()
        val releaseYear = etYear.text.toString()

        val releaseDate: Date = SimpleDateFormat("dd-MM-yyyy").parse(releaseDay+"-"+releaseMonth+"-"+releaseYear)

        println("release date: $releaseDate")




        if (gameTitle.isNotBlank()){
            viewModel.insertReminder(Game(gameTitle, gamePlatform, releaseDate))
            findNavController().popBackStack()
        } else{
            Toast.makeText(
                activity,
                R.string.not_valid_game, Toast.LENGTH_SHORT
            ).show()
        }
    }
}