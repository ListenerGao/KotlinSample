package com.listenergao.base.utils

import android.content.Context
import com.listenergao.base.BaseApplication

object CacheUtils {

    private val context = BaseApplication.currentApplication()
    private val SP = context.getSharedPreferences("ListenerGao", Context.MODE_PRIVATE)

    fun save(key: String?, value: String?) {
        SP.edit().putString(key, value).apply()
    }

    fun get(key: String): String? {
        return SP.getString(key, null)
    }
}