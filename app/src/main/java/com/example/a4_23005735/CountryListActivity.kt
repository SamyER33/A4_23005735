package com.example.a4_23005735

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listadopaises.databinding.ActivityCountryListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountryListBinding
    private lateinit var countryAdapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountryListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        countryAdapter = CountryAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@CountryListActivity)
            adapter = countryAdapter
        }

        fetchCountries()
    }

    private fun fetchCountries() {
        val api = RetrofitInstance.api
        api.getAllCountries().enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if (response.isSuccessful) {
                    response.body()?.let { countries ->
                        countryAdapter.submitList(countries)
                    }
                }
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                // Maneja el error
            }
        })
    }
}
