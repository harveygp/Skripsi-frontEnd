package com.example.skripsiapp.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {

    private val PREF_NAME = "sharedpref"
    private val preferences: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var prefUid: String?
        get() = preferences.getString(Constant.PREF_UID, "")
        set(value) = preferences.edit().putString(Constant.PREF_UID, value).apply()

    var prefNama: String?
        get() = preferences.getString(Constant.PREF_NAMA, "")
        set(value) = preferences.edit().putString(Constant.PREF_NAMA, value).apply()

    var prefPeminatan: String?
        get() = preferences.getString(Constant.PREF_PEMINATAN, "")
        set(value) = preferences.edit().putString(Constant.PREF_PEMINATAN, value).apply()

}