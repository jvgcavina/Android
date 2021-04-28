package com.jvgc.architecture.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jvgc.architecture.mvvm.repository.MainRepository
import com.jvgc.architecture.mvvm.repository.model.Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {

    val characterList = MutableLiveData<List<Character>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllCharacters() {
        val response = repository.getAllCharacters()
        response.enqueue(object : Callback<List<Character>> {

            override fun onResponse(call: Call<List<Character>>,
                                    response: Response<List<Character>>) {
                characterList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}