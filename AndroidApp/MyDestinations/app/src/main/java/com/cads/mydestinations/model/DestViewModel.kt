package com.cads.mydestinations.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cads.mydestinations.network.Dest
import com.cads.mydestinations.network.DestNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DestViewModel: ViewModel() {
    private  val _destinations = MutableLiveData<List<Dest>>()
    val destinations :LiveData<List<Dest>>
        get() =  _destinations

    init{
        getDests()
    }
     fun getDests(){
        viewModelScope.launch (Dispatchers.IO){
            try{
                _destinations.postValue(DestNetwork.retrofit.getDestinations())
                Log.i("destinations" , destinations.value.toString())
            }catch(e:Exception){
                Log.e("error", e.message.toString())
            }

        }
    }

     fun postDestination(city:String , country:String){
        viewModelScope.launch (Dispatchers.IO){
            try{
                val dest = Dest(city = city, country = country)
                DestNetwork.retrofit.postDestination(dest)
            }catch(e:Exception){
                Log.e("error", e.message.toString())
            }

        }
    }

}