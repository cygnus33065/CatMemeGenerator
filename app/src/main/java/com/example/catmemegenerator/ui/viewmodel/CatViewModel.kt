package com.example.catmemegenerator.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.catmemegenerator.R
import com.example.catmemegenerator.Resource
import com.example.catmemegenerator.data.remote.CatRepo
import com.example.catmemegenerator.data.remote.retrofit.Cat
import com.example.catmemegenerator.databinding.CatMemeFilterFragmentBinding
import com.google.android.material.radiobutton.MaterialRadioButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatViewModel: ViewModel() {

    private var _cat = MutableLiveData<Resource<Cat>>()
    val cat: LiveData<Resource<Cat>> get() = _cat
    var selected: String = "Image"
    var text: String = ""
    var color: String? = null
    var size: String? = null
    var filter: String? = null
    var enabled: Boolean = false


    private var _binding: CatMemeFilterFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var catViewModel: CatViewModel

    fun fetchCat(){




        if (selected == "Image" && text.isNullOrEmpty()) {
            getCat(filter)

        } else if(selected == "Image" && text.isNotEmpty()){
            getCatSays(text, color, filter, size)

        }else if (selected == "Gif" && text.isNullOrEmpty()){
            getCatGif(filter)

        }else if(selected == "Gif" && text.isNotEmpty()){
            getCatSaysGif(text,color,filter,size)
        }
    }

    private fun getCat(filter:String?){
        _cat.value = Resource.Loading
        viewModelScope.launch(Dispatchers.IO){
            val catResource = CatRepo.getCat(filter)
            _cat.postValue(catResource)
        }
    }

    private fun getCatSays(text: String, color:String?, filter:String?, size:String?){
        _cat.value = Resource.Loading
        viewModelScope.launch(Dispatchers.IO){
            val catResource = CatRepo.getCatSays(text, color, filter, size)
            _cat.postValue(catResource)
        }
    }

    private fun getCatGif(filter: String?){
        _cat.value = Resource.Loading
        viewModelScope.launch(Dispatchers.IO){
            val catResource = CatRepo.getCatGif(filter)
            _cat.postValue(catResource)
        }
    }

    private fun getCatSaysGif(text:String, color:String?, filter:String?, size:String?){
        _cat.value = Resource.Loading
        viewModelScope.launch(Dispatchers.IO){
            val catResource = CatRepo.getCatSaysGif(text, color, filter, size)
            _cat.postValue(catResource)
        }
    }

}

