package com.jvgc.architecture.mvvm.repository

import com.jvgc.architecture.mvvm.repository.remote.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    fun getAllCharacters() = retrofitService.getAllCharacters()
}