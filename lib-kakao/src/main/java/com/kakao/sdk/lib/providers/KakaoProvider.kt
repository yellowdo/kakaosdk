package com.kakao.sdk.lib.providers

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.util.Log
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.lib.R
import com.kakao.sdk.lib.extension.resString

class KakaoProvider : ContentProvider() {
    private val TAG = "KakaoProvider"

    override fun onCreate(): Boolean {
        Log.e(TAG, "onCreate")
        // Kakao SDK 초기화
        context?.applicationContext?.run {
            ResourceProvider.initializeApp(this)
            KakaoSdk.init(this, resString(R.string.appkey))
        }
        return false
    }

    override fun query(
        uri: Uri,
        projection: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        sortOrder: String?
    ): Cursor? {
        return null
    }

    override fun getType(uri: Uri): String? = null

    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int = 0

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<String>?
    ): Int = 0


}