package com.example.catmemegenerator.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.catmemegenerator.Resource
import com.example.catmemegenerator.data.remote.CatRepo
import com.example.catmemegenerator.data.remote.retrofit.Cat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatViewModel: ViewModel() {

    private var _cat = MutableLiveData<Resource<Cat>>()
    val cat: LiveData<Resource<Cat>> get() = _cat

    fun getCat(filter:String?){
        _cat.value = Resource.Loading
        viewModelScope.launch(Dispatchers.IO){
            val catResource = CatRepo.getCat(filter)
            _cat.postValue(catResource)
        }
    }

    fun getCatSays(text: String, color:String?, filter:String?, size:Int?){
        _cat.value = Resource.Loading
        viewModelScope.launch(Dispatchers.IO){
            val catResource = CatRepo.getCatSays(text, color, filter, size)
            _cat.postValue(catResource)
        }
    }

    fun getCatGif(filter: String?){
        _cat.value = Resource.Loading
        viewModelScope.launch(Dispatchers.IO){
            val catResource = CatRepo.getCatGif(filter)
            _cat.postValue(catResource)
        }
    }

    fun getCatSaysGif(text:String, color:String?, filter:String?, size:Int?){
        _cat.value = Resource.Loading
        viewModelScope.launch(Dispatchers.IO){
            val catResource = CatRepo.getCatSaysGif(text, color, filter, size)
            _cat.postValue(catResource)
        }
    }

}

