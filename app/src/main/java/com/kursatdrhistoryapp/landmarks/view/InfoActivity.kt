package com.kursatdrhistoryapp.landmarks.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AnimationUtils
import com.kursatdrhistoryapp.landmarks.R
import com.kursatdrhistoryapp.landmarks.model.Landmarks
import com.kursatdrhistoryapp.landmarks.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //functions
        makeInvisible()
        animations ()

        val intent = intent

        // casting
        val selectedLandmarks =  intent.getSerializableExtra("landmark") as Landmarks
        binding.linearLay.setBackgroundResource(selectedLandmarks.info_image)
        binding.cityText.text = selectedLandmarks.city
        binding.nameText.text = selectedLandmarks.name
        binding.infoText.text = selectedLandmarks.info

    }

    fun backClick(view: View)
    {
        val intent = Intent(this,MainActivity::class.java)
        finish()
        startActivity(intent)

    }

    fun animations ()
    {
        val fromleft = AnimationUtils.loadAnimation(this, R.anim.fromleft)
        val opacity =  AnimationUtils.loadAnimation(this, R.anim.opacity)
        binding.cityText.visibility = View.VISIBLE
        binding.nameText.visibility = View.VISIBLE
        binding.cityText.startAnimation(fromleft)
        binding.nameText.startAnimation(fromleft)

        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                binding.infoText.visibility = View.VISIBLE
                binding.backBtn.visibility = View.VISIBLE
                binding.infoText.startAnimation(opacity)
                binding.backBtn.startAnimation(opacity)
            }
        }, 1000)

    }

    fun makeInvisible()
    {
        binding.cityText.visibility = View.INVISIBLE
        binding.infoText.visibility = View.INVISIBLE
        binding.nameText.visibility = View.INVISIBLE
        binding.backBtn.visibility =  View.INVISIBLE
    }
}