package com.aten5.restcountries.countries

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.aten5.restcountries.R
import com.aten5.restcountries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.recyclerview.apply {

        }
        binding.loading.visibility = View.VISIBLE
    }
}