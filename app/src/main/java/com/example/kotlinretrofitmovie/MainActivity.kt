package com.example.kotlinretrofitmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var models: ArrayList<Model>
    private lateinit var adaptery: Adaptery


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        models = ArrayList()

        val retrofit = Retrofit.Builder().baseUrl("https://api.collectapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val service = retrofit.create(MovieApi::class.java)

        val call =
            service.getData("apikey 1BZycnisKZCcDv9hF10pdl:65vV4sqccL7I29VqW1p64O", "superman")

        call.enqueue(object : Callback<ModelResult> {
            override fun onResponse(
                call: Call<ModelResult>,
                response: Response<ModelResult>
            ) {
                if (response.isSuccessful) {

                    models = response.body()!!.result
                    //Recyclerview
                    recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
                    adaptery=Adaptery(models)
                    recyclerView.adapter=adaptery

                }
            }

            override fun onFailure(call: Call<ModelResult>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}