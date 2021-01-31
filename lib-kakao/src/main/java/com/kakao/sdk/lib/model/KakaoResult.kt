package com.kakao.sdk.lib.model

class KakaoResult<T> {
    var onSuccess: (T) -> Unit = {}
    var onFail: (Throwable) -> Unit = {}
}

inline fun <reified T> KakaoResult<T>.resultWrapper(data: T?, t: Throwable?) {
    when {
        t != null -> onFail.invoke(t)
        data == null -> onFail.invoke(NullPointerException("${T::class.java.simpleName} is null"))
        else -> onSuccess.invoke(data)
    }
}