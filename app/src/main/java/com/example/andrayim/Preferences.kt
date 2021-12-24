package com.example.andrayim

import android.content.Context

interface Preferences {
    fun saveLogin(login: String)

    fun savePassword(password: String)

    fun getLogin(login: String) : String

    fun getPassword(password: String): String
}

class PreferencesImpl(context: Context): Preferences {
    private val preferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)

    override fun saveLogin(login: String) {
        preferences.edit().apply{
            putString(LOGIN_KEY, login)
        }.apply()
    }

    override fun savePassword(password: String) {
        preferences.edit().apply{
            putString(PASSWORD_KEY, password)
        }.apply()
    }

    override fun getLogin(login: String): String {
        return preferences.getString(LOGIN_KEY, "")?: ""
    }

    override fun getPassword(password: String): String {
        return preferences.getString(PASSWORD_KEY, "")?: ""
    }

    companion object {
        const val LOGIN_KEY = "LOGIN_KEY"
        const val PASSWORD_KEY = "PASSWORD_KEY"
    }
}