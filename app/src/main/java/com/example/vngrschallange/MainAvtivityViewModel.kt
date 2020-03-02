package com.example.vngrschallange

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vngrschallange.retrofit.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainAvtivityViewModel(var SearchService: SearchServiceImpl) : ViewModel() {


    private var repoList : MutableLiveData<ArrayList<RepositoryModel>> = MutableLiveData()


    fun getRepoList() : MutableLiveData<ArrayList<RepositoryModel>>{
        SearchService.search("ke",1).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                repoList.value = it
            }, {
                print(it)

            })

    return repoList
    }



}