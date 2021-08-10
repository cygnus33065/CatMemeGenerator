package com.example.catmemegenerator.ui.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.catmemegenerator.R
import com.example.catmemegenerator.databinding.CatMemeFilterFragmentBinding
import com.example.catmemegenerator.ui.viewmodel.CatViewModel
import com.google.android.material.radiobutton.MaterialRadioButton


class CatMemeFilterFragment: Fragment() {

    private var _binding: CatMemeFilterFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var catViewModel: CatViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CatMemeFilterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        catViewModel = ViewModelProvider(requireActivity()).get(CatViewModel::class.java)

        val filters = resources.getStringArray(R.array.filters_array)

        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, filters)
        binding.tvFilter.setAdapter(adapter)


        binding.etEnterText.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                //noop
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //noop
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                catViewModel.text = s.toString()

                if (s.isNullOrEmpty()){
                    catViewModel.enabled = false
                    binding.etEnterSize.isEnabled = catViewModel.enabled
                    binding.etEnterColor.isEnabled = catViewModel.enabled
                } else {
                    catViewModel.enabled = true
                    binding.etEnterSize.isEnabled = catViewModel.enabled
                    binding.etEnterColor.isEnabled = catViewModel.enabled
                }
            }

        })

        binding.etEnterColor.addTextChangedListener {
            catViewModel.color  = it.toString()
        }

        binding.etEnterSize.addTextChangedListener {
            catViewModel.size = it.toString()
        }

        binding.rgGifImage.setOnCheckedChangeListener { group, checkedId ->
            catViewModel.selected =  binding.rgGifImage.findViewById<MaterialRadioButton>(checkedId).text.toString()

        }

        binding.tvFilter.addTextChangedListener {
            catViewModel.filter = it.toString()
        }

        binding.butCat.setOnClickListener {
        catViewModel.fetchCat()
            findNavController().navigate(R.id.action_catMemeFilterFragment_to_catMemeResultsFragment)



        }

        binding.butReset.setOnClickListener {
            catViewModel.text = ""
            catViewModel.size = ""
            catViewModel.color = ""
            catViewModel.filter = null
            catViewModel.selected = "Image"
            binding.etEnterText.setText(catViewModel.text)
            binding.etEnterSize.setText(catViewModel.size)
            binding.etEnterColor.setText(catViewModel.color)
            binding.rbGif.isChecked = false
            binding.rbImage.isChecked = true
            binding.tvFilter.setText(catViewModel.filter)

        }

    }

}

//val selected =  binding.rgGifImage.findViewById<MaterialRadioButton>(selectId).text.toString()
//val text = binding.etEnterText.text.toString()
//val color = binding.etEnterColor.text.toString()
//val size = binding.etEnterSize.text.toString()
//val filter = binding.tvFilter.text.toString()