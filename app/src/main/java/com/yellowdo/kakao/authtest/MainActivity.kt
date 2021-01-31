package com.yellowdo.kakao.authtest

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kakao.sdk.lib.extension.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getHashKey()

        logE("isKakaoTalkLoginAvailable : ${isKakaoTalkLoginAvailable()}")

        // 카카오톡으로 로그인
        loginWithKakaoTalk {
            onSuccess = {
                toast("$it")
                me { toast("$it") }
            }
            onFail = { toast("$it") }
        }
    }

    private fun toast(msg: String) {
        logE(msg)
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}