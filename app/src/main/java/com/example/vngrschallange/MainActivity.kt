package com.example.vngrschallange

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vngrschallange.retrofit.NetworkManager
import com.example.vngrschallange.retrofit.RepositoryModel

import com.example.vngrschallange.retrofit.SearchResponse
import com.example.vngrschallange.retrofit.SearchServiceImpl
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

     var info : ArrayList<RepositoryModel> = ArrayList()
    lateinit var viewModel : MainAvtivityViewModel
    lateinit var adapter : RcyViewAdapater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRcy()
        getResponse()



    }

    private fun getResponse() {
        viewModel = MainAvtivityViewModel(SearchServiceImpl(NetworkManager().api))
        viewModel.getRepoList().observe(this, Observer {
            info.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }


    private fun initRcy() {
    adapter = RcyViewAdapater(info)
    rcy.layoutManager = LinearLayoutManager(this)
    rcy.adapter = adapter
    }
}
