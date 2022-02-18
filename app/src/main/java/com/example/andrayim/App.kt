package com.example.andrayim

import android.app.Application
import androidx.room.Room
import com.example.andrayim.database.AppDatabase

class App: Application() {
     lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        mInstance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    companion object {
        const val BASE_MOCK = "https://6dc9789f-7bdb-41f7-b5f1-d8b25dff9693.mock.pstmn.io"
        private var mInstance: App? = null
        val instance get() = mInstance!!
    }
}

val Any.Injector: App
    get() = App.instance