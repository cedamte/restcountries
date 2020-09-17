package com.aten5.restcountries.countries

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.aten5.restcountries.R
import com.aten5.restcountries.app.CountriesApplication
import com.aten5.restcountries.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: CountriesViewModelFactory
    private val viewModel: CountriesViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)
            .get(CountriesViewModel::class.java)
    }

    private val viewAdapter = CountriesAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        (application as CountriesApplication).appComponent.inject(this)

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.recyclerview.apply {
            layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            adapter = viewAdapter
            setHasFixedSize(true)
        }
        binding.loading.visibility = View.VISIBLE
        binding.viewModel = viewModel

        viewModel.countriesObservables.observe(
            this, {
                viewAdapter.submitList(it)
            }
        )
        viewModel.loadingObservable.observe(this,
            { isLoading ->
                when (isLoading) {
                    true -> binding.loading.visibility = View.VISIBLE
                    false -> binding.loading.visibility = View.GONE
                }
            })

        viewModel.errorObservable.observe(this,
            { error ->
                Toast.makeText(this, error, Toast.LENGTH_LONG)
                    .show()
            })

        viewModel.getCountriesData()

    }
}