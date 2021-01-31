@file:JvmName("Login")

package com.kakao.sdk.lib.extension

import android.content.Context
import com.kakao.sdk.auth.AuthCodeClient
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.auth.model.Prompt
import com.kakao.sdk.lib.model.KakaoResult
import com.kakao.sdk.lib.model.resultWrapper

@JvmField
val login = LoginClient.instance

fun login(block: LoginClient.() -> Unit) = LoginClient.instance.apply(block)

fun Context.isKakaoTalkLoginAvailable() = login.isKakaoTalkLoginAvailable(this)

@JvmOverloads
fun Context.loginWithKakaoTalk(
    requestCode: Int = AuthCodeClient.DEFAULT_REQUEST_CODE,
    channelPublicIds: List<String>? = null,
    serviceTerms: List<String>? = null,
    block: KakaoResult<OAuthToken>.() -> Unit = {}
) {
    login.loginWithKakaoTalk(
        this, requestCode, channelPublicIds, serviceTerms
    ) { token, error ->
        KakaoResult<OAuthToken>()
            .apply(block)
            .resultWrapper(token, error)
    }
}

@JvmOverloads
fun Context.loginWithKakaoAccount(
    prompts: List<Prompt>? = null,
    channelPublicIds: List<String>? = null,
    serviceTerms: List<String>? = null,
    block: KakaoResult<OAuthToken>.() -> Unit = {}
) {
    login.loginWithKakaoAccount(
        this, prompts, channelPublicIds, serviceTerms
    ) { token, error ->
        KakaoResult<OAuthToken>()
            .apply(block)
            .resultWrapper(token, error)
    }
}

@JvmOverloads
fun Context.loginWithNewScopes(
    scopes: List<String>,
    block: KakaoResult<OAuthToken>.() -> Unit = {}
) {
    login.loginWithNewScopes(this, scopes) { token, error ->
        KakaoResult<OAuthToken>()
            .apply(block)
            .resultWrapper(token, error)
    }
}

fun Context.loginWithKakao(
    result: KakaoResult<OAuthToken>.() -> Unit = {}
) {
    when (isKakaoTalkLoginAvailable()) {
        true -> loginWithKakaoTalk(block = result)
        else -> loginWithKakaoAccount(block = result)
    }
}



