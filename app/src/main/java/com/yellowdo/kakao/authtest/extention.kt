package com.yellowdo.kakao.authtest

import android.content.Context
import android.content.pm.PackageManager
import android.util.Base64
import android.util.Log
import java.security.MessageDigest


fun Context.getHashKey() {
    try {
        (packageManager.getPackageInfo(packageName, PackageManager.GET_SIGNATURES))?.let {
            for (signature in it.signatures) {
                val md: MessageDigest = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

}