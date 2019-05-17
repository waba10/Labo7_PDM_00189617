package com.example.labovacil.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labovacil.Database.GithubRepo
import com.example.labovacil.Database.RoomDB
import com.example.labovacil.Repository.GithubRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(app: Application): AndroidViewModel(app) {

    private val repository: GithubRepository

    init {
        val repoDao= RoomDB.getInstance(app).repoDao()
        repository = GithubRepository(repoDao)
    }

    fun insert(repo: GithubRepo)= viewModelScope.launch(Dispatchers.IO) {
        repository.insert(repo)
    }

    fun getAll():LiveData<List<GithubRepo>> = repository.getAll()

    fun nukeAll()= repository.nuke()
}