package com.jvgc.architecture.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.jvgc.architecture.mvvm.databinding.ActivityMainBinding
import com.jvgc.architecture.mvvm.repository.MainRepository
import com.jvgc.architecture.mvvm.repository.remote.RetrofitService
import com.jvgc.architecture.mvvm.viewmodel.MainViewModel
import com.jvgc.architecture.mvvm.viewmodel.factory.ViewModelFactory

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()
    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelFactory(MainRepository(retrofitService)))
            .get(MainViewModel::class.java)

        binding.recyclerview.adapter = adapter

        viewModel.characterList.observe(this, {
            binding.progressBar.visibility = View.GONE
            binding.errorTextView.visibility = View.GONE
            binding.recyclerview.visibility = View.VISIBLE
            adapter.setCharacterList(it)
        })

        viewModel.errorMessage.observe(this, {
            binding.progressBar.visibility = View.GONE
            binding.recyclerview.visibility = View.GONE
            binding.errorTextView.text = it
            binding.errorTextView.visibility = View.VISIBLE
        })

        binding.progressBar.visibility = View.VISIBLE
        viewModel.getAllCharacters()
    }
}