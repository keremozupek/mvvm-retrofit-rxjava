package com.example.vngrschallange.retrofit

import io.reactivex.Observable

interface SearchService {

    fun search(keyword: String, pageNumber: Int = 1): Observable<ArrayList<RepositoryModel>>
}

class SearchServiceImpl(private val api: Api): SearchService {
    override fun search(keyword: String,pageNumber : Int ): Observable<ArrayList<RepositoryModel>> {
        return api.searchRepositories(keyword,page = pageNumber).map {
            return@map it.items
        }
    }
}
