package com.example.catmemegenerator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.example.catmemegenerator.databinding.CatMemeFilterFragmentBinding
import com.example.catmemegenerator.databinding.ListItemBinding

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
//        (textField.editText as? AutoCompleteTextView)?.setAdapter(adapter)
        binding?.tvFilter?.setAdapter(adapter)
    }


}