package com.taijoo.myproject.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taijoo.myproject.data.model.Memo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _item = MutableStateFlow(emptyList<Memo>())
    val item : StateFlow<List<Memo>> get() = _item.asStateFlow()


    init {
        viewModelScope.launch {
            val list = ArrayList<Memo>()

            for(i in 0 until 100){
                list.add(Memo(i,i,i.toString(),"20222"))
            }

            Log.e("여기","pc22222")

            Log.e("여기","pc22222")
            _item.value = list
        }
    }

    fun e(){
        Log.e("여기","pc22222")
        Log.e("여기","pc22222")

    }

}