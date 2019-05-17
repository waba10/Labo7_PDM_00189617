package com.example.labovacil.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="repos")
data class GithubRepo (

    val name:String
){
    @PrimaryKey(autoGenerate=true)
    var id:Long =0
}