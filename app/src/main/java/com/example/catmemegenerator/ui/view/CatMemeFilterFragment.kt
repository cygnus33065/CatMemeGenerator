package com.example.catmemegenerator.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.catmemegenerator.R
import com.example.catmemegenerator.databinding.CatMemeFilterFragmentBinding

class CatMemeFilterFragment: Fragment() {

    private var binding: CatMemeFilterFragmentBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CatMemeFilterFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val filters = resources.getStringArray(R.array.filters_array)

        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, filters)
        binding?.tvFilter?.setAdapter(adapter)
    }


}