package com.kakao.sdk.lib.extension

import android.content.Context
import androidx.annotation.StringRes

fun Context.resString(@StringRes resId: Int) = try {
    getString(resId)
} catch (e: Exception) {
    e.printStackTrace()
    ""
}