package com.example.vngrschallange

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vngrschallange.retrofit.RepositoryModel
import com.example.vngrschallange.retrofit.SearchServiceImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class MainViewModel(var searchService: SearchServiceImpl) : ViewModel() {


    val repoList: MutableLiveData<ArrayList<RepositoryModel>> = MutableLiveData()
    private val compositeDisposable = CompositeDisposable()

    fun fetchRepoList() {
        searchService.search("ke", 1).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                repoList.postValue(it)
            }, {
                print(it)

            }).addTo(compositeDisposable)
    }

}