package com.example.stockmanagement.ui.main

import android.app.Application
import androidx.room.Room
import com.example.stockmanagement.db.DataBase
import com.example.stockmanagement.db.DataBase2
import com.example.stockmanagement.db.DataBase3
import com.example.stockmanagement.db.DataBase4
import com.example.stockmanagement.db.DataBase5
import com.example.stockmanagement.db.DataBase6
import com.example.stockmanagement.db.DataBase7


class MainApplication : Application() {

    companion object {
        lateinit var database: DataBase
            private set
        lateinit var databaseL: DataBase2
            private set
        lateinit var databaseP: DataBase3
            private set
        lateinit var databasePl: DataBase4
            private set
        lateinit var databaseWp: DataBase5
            private set
        lateinit var databaseW: DataBase6
            private set
        lateinit var databaseS:DataBase7
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            DataBase::class.java,
            "stock_database"
        ).fallbackToDestructiveMigration().build()

        databaseL = Room.databaseBuilder(
            applicationContext,
            DataBase2::class.java,
            "stock_database_l"
        ).fallbackToDestructiveMigration().build()

        databaseP = Room.databaseBuilder(
            applicationContext,
            DataBase3::class.java,
            "stock_database_p"
        ).fallbackToDestructiveMigration().build()

        databasePl = Room.databaseBuilder(
            applicationContext,
            DataBase4::class.java,
            "stock_database_pl"
        ).fallbackToDestructiveMigration().build()

        databaseWp = Room.databaseBuilder(
            applicationContext,
            DataBase5::class.java,
            "stock_database_wp"
        ).fallbackToDestructiveMigration().build()

        databaseW = Room.databaseBuilder(
            applicationContext,
            DataBase6::class.java,
            "stock_database_w"
        ).fallbackToDestructiveMigration().build()

        databaseS = Room.databaseBuilder(
            applicationContext,
            DataBase7::class.java,
            "stock_database_7"
        ).fallbackToDestructiveMigration().build()
    }
}






