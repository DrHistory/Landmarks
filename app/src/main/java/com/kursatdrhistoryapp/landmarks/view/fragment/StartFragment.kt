package com.kursatdrhistoryapp.landmarks.view.fragment


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.Navigation
import com.kursatdrhistoryapp.landmarks.R
import com.kursatdrhistoryapp.landmarks.databinding.FragmentStartBinding


class StartFragment : Fragment() {



    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        makeInvisible()
        animations()
        binding.startBtn.setOnClickListener {
            val action = StartFragmentDirections.actionSplashFragmentToFeedFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }


    private fun animations() {
        val fromLeft = AnimationUtils.loadAnimation(context, R.anim.fromleft)
        val opacity = AnimationUtils.loadAnimation(context, R.anim.opacity)
        val fromBottom = AnimationUtils.loadAnimation(context, R.anim.frombottom)

        binding.titleTextView.visibility = View.VISIBLE
        binding.titleTextView.startAnimation(fromLeft)

        val handler = Handler()
        handler.postDelayed({
            binding.subtitleTextView.visibility = View.VISIBLE
            binding.subtitleTextView.startAnimation(opacity)
        }, 1500)

        val handler2 = Handler()
        handler2.postDelayed({
            binding.quoteTextView.visibility = View.VISIBLE
            binding.quoteTextView.startAnimation(opacity)
            binding.startBtn.visibility = View.VISIBLE
            binding.startBtn.startAnimation(fromBottom)
        }, 2500)


    }

    private fun makeInvisible() {
        binding.titleTextView.visibility = View.INVISIBLE
        binding.subtitleTextView.visibility = View.INVISIBLE
        binding.quoteTextView.visibility = View.INVISIBLE
        binding.startBtn.visibility = View.INVISIBLE
    }
}