package com.aten5.restcountries.countries

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aten5.domain.entities.CountriesEntity
import com.aten5.restcountries.R
import com.aten5.restcountries.databinding.ListItemCountriesBinding

class CountriesAdapter : ListAdapter<CountriesEntity, CountriesAdapter.ViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class ViewHolder(private val binding: ListItemCountriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CountriesEntity) {
            binding.countries = item
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: ListItemCountriesBinding = DataBindingUtil
                    .inflate(layoutInflater, R.layout.list_item_countries, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CountriesEntity>() {
            override fun areItemsTheSame(
                oldItem: CountriesEntity,
                newItem: CountriesEntity
            ): Boolean {
                return oldItem.countryName == newItem.countryName
            }

            override fun areContentsTheSame(
                oldItem: CountriesEntity,
                newItem: CountriesEntity
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}
