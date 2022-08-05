package com.kursatdrhistoryapp.landmarks.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.kursatdrhistoryapp.landmarks.Adapter.RecyclerViewAdapter
import com.kursatdrhistoryapp.landmarks.model.Landmarks
import com.kursatdrhistoryapp.landmarks.R
import com.kursatdrhistoryapp.landmarks.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

}