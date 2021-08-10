package com.example.catmemegenerator.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.catmemegenerator.data.remote.retrofit.Cat
import com.example.catmemegenerator.databinding.CatMemeResultsFragmentBinding
import com.example.catmemegenerator.ui.viewmodel.CatViewModel

class CatMemeResultsFragment: Fragment() {
    private lateinit var catViewModel: CatViewModel
    var _binding: CatMemeResultsFragmentBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CatMemeResultsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        catViewModel = ViewModelProvider(requireActivity()).get(CatViewModel::class.java)

        Log.e("onViewCreated", catViewModel.cat.value.toString())

        catViewModel.cat.observe(viewLifecycleOwner, Observer{
            Log.e("Observer", catViewModel.cat.value.toString())
        })
    }
}