package com.kursatdrhistoryapp.landmarks.view

import android.animation.Animator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.kursatdrhistoryapp.landmarks.R
import com.kursatdrhistoryapp.landmarks.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        makeInvisible()

        animations()

    }


    fun startClick (view : View)
    {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


    fun animations()
    {
        val fromleft = AnimationUtils.loadAnimation(this,R.anim.fromleft)
        val opacity = AnimationUtils.loadAnimation(this,R.anim.opacity)
        val frombottom = AnimationUtils.loadAnimation(this,R.anim.frombottom)
        binding.titleTextView.visibility = View.VISIBLE
        binding.titleTextView.startAnimation(fromleft)

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {

                binding.subtitleTextView.visibility = View.VISIBLE
                binding.subtitleTextView.startAnimation(opacity)

            }
        }, 1500)

        val handler2 = Handler()
        handler2.postDelayed(object : Runnable {
            override fun run() {

                binding.quoteTextView.visibility = View.VISIBLE
                binding.quoteTextView.startAnimation(opacity)
                binding.startBtn.visibility = View.VISIBLE
                binding.startBtn.startAnimation(frombottom)
            }
        }, 2500)


    }

    fun makeInvisible()
    {
        binding.titleTextView.visibility = View.INVISIBLE
        binding.subtitleTextView.visibility = View.INVISIBLE
        binding.quoteTextView.visibility = View.INVISIBLE
        binding.startBtn.visibility = View.INVISIBLE
    }
}