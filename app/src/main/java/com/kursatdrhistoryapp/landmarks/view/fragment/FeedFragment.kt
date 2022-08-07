package com.kursatdrhistoryapp.landmarks.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kursatdrhistoryapp.landmarks.Adapter.RecyclerViewAdapter
import com.kursatdrhistoryapp.landmarks.databinding.FragmentFeedBinding
import com.kursatdrhistoryapp.landmarks.viewmodel.FeedViewModel


class FeedFragment : Fragment() {

    private lateinit var viewModel: FeedViewModel
    private lateinit var adapter: RecyclerViewAdapter
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[FeedViewModel::class.java]
        viewModel.loadData()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        observeLiveData()

    }
    private fun observeLiveData() {
        viewModel.landmarkList.observe(viewLifecycleOwner, Observer { landmarks ->
            landmarks?.let {
                adapter = RecyclerViewAdapter(landmarks)
                binding.recyclerView.adapter = adapter
            }
        })
    }
}