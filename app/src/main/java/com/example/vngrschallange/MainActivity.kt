package com.example.vngrschallange

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vngrschallange.retrofit.NetworkManager
import com.example.vngrschallange.retrofit.RepositoryModel
import com.example.vngrschallange.retrofit.SearchServiceImpl
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var info: ArrayList<RepositoryModel> = ArrayList()
    lateinit var viewModel: MainViewModel
    lateinit var adapter: RcyViewAdapater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initRcy()
        initLifeCycleObservers()
        fetchData()
    }

    private fun initViewModel() {
        viewModel = MainViewModel(SearchServiceImpl(NetworkManager().api))
    }

    private fun initLifeCycleObservers() {
        viewModel.repoList.observe(this, Observer {
            info.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun fetchData() {
        viewModel.fetchRepoList()
    }

    private fun initRcy() {
        adapter = RcyViewAdapater(info)
        rcy.layoutManager = LinearLayoutManager(this)
        rcy.adapter = adapter
    }
}
