package com.example.housepoints

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.housepoints.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var house = ""

        binding.slytherin.setOnClickListener{house = "s"}
        binding.gryffindor.setOnClickListener{house = "g"}
        binding.ravenclaw.setOnClickListener{house = "r"}
        binding.hufflepuff.setOnClickListener{house = "h"}

        binding.add5.setOnClickListener { calcPoints(house, true, 5) }
        binding.add10.setOnClickListener { calcPoints(house, true, 10) }
        binding.sub5.setOnClickListener { calcPoints(house, false, 5) }
        binding.sub10.setOnClickListener { calcPoints(house, false, 10) }
    }

    private fun calcPoints(house: String, add: Boolean, points: Int) {
        val pointsTxt = when (house){
            "g" -> binding.gPoints
            "s" -> binding.sPoints
            "r" -> binding.rPoints
            else -> binding.hPoints
        }

        var total: Int = when (pointsTxt.text.toString()){
            "" -> 0
            else -> pointsTxt.text.toString().toInt()
        }
        if (add){
            total += points
        }
        else{
            total -= points
        }

        pointsTxt.text = total.toString()
    }
}