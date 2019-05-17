package com.example.labovacil.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.labovacil.Database.GithubDAO
import com.example.labovacil.Database.GithubRepo

class GithubRepository(private val repoDao: GithubDAO){

    @WorkerThread
    suspend fun insert(repo: GithubRepo){
        repoDao.insert(repo)
    }

    fun getAll():LiveData<List<GithubRepo>> = repoDao.getAllRepos()

    fun nuke()= repoDao.nukeTable()
}