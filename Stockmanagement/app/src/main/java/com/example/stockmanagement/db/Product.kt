package com.example.stockmanagement.db

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "product")

data class Product (

    @PrimaryKey(autoGenerate = true)
    val id:Long=0,
    val name:String,
    val reference:String,


)
@Entity(tableName = "history")
data class History(
    @PrimaryKey(autoGenerate = true)
    val id: Long=0,
    val quatity:Int,
    val reference: String,
    val date: String,
    val in_out:String
)


@Entity(tableName = "dashboard")
data class Dashboard(

    @PrimaryKey(autoGenerate = true)
    val id : Long=0,
    val productName :String,
    val reference: String,
    var quatity: Int

)

