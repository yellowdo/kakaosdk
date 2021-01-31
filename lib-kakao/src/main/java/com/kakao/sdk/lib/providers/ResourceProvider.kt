@file:JvmName("Resource")

package com.kakao.sdk.lib.providers

import android.content.Context

object ResourceProvider {
    private var context: Context? = null

    fun initializeApp(context: Context?) {
        ResourceProvider.context = context
    }

    @JvmStatic
    fun getString(resId: Int): String {
        return try {
            context?.getString(resId) ?: run { "" }
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    @JvmStatic
    fun getString(resId: Int, value: String?): String {
        return try {
            context?.getString(resId, value) ?: run { "" }
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }
}

fun resString(resId: Int): String = ResourceProvider.getString(resId)

fun resString(resId: Int, value: String?): String = ResourceProvider.getString(resId, value)
