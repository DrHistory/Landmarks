package com.kursatdrhistoryapp.landmarks.view.fragment

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kursatdrhistoryapp.landmarks.R
import com.kursatdrhistoryapp.landmarks.databinding.FragmentDetailBinding
import com.kursatdrhistoryapp.landmarks.viewmodel.DetailViewModel

class DetailFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var viewModel: DetailViewModel
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private var index  = 0
            override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            index = DetailFragmentArgs.fromBundle(it).index
        }
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
        viewModel.loadData()

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.selectedLandmark.observe(viewLifecycleOwner, Observer { selectedLandmark ->
            selectedLandmark?.let {
                binding.nameText.text = selectedLandmark[index].name
                binding.cityText.text = selectedLandmark[index].city
                binding.infoText.text = selectedLandmark[index].info
                binding.imageView.setImageResource(selectedLandmark[index].image)
            }
        })
    }

}