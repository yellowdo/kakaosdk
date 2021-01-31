@file:JvmName("User")

package com.kakao.sdk.lib.extension

import com.kakao.sdk.lib.model.KakaoResult
import com.kakao.sdk.lib.model.resultWrapper
import com.kakao.sdk.user.UserApiClient
import com.kakao.sdk.user.model.AccessTokenInfo
import com.kakao.sdk.user.model.User
import com.kakao.sdk.user.model.UserServiceTerms
import com.kakao.sdk.user.model.UserShippingAddresses
import java.util.*

@JvmField
val user = UserApiClient.instance

fun user(block: UserApiClient.() -> Unit) = UserApiClient.instance.apply(block)

@JvmOverloads
fun me(
    secureReSource: Boolean = true,
    block: KakaoResult<User>.() -> Unit = {}
) {
    user.me(secureReSource) { u, error ->
        KakaoResult<User>()
            .apply(block)
            .resultWrapper(u, error)
    }
}

@JvmOverloads
fun accessTokenInfo(
    block: KakaoResult<AccessTokenInfo>.() -> Unit = {}
) {
    user.accessTokenInfo { u, error ->
        KakaoResult<AccessTokenInfo>()
            .apply(block)
            .resultWrapper(u, error)
    }
}

@JvmOverloads
fun updateProfile(
    properties: Map<String, String>,
    block: KakaoResult<Unit>.() -> Unit = {}
) {
    user.updateProfile(properties) { error ->
        KakaoResult<Unit>()
            .apply(block)
            .resultWrapper(Unit, error)
    }
}

@JvmOverloads
fun logout(
    block: KakaoResult<Unit>.() -> Unit = {}
) {
    user.logout { error ->
        KakaoResult<Unit>()
            .apply(block)
            .resultWrapper(Unit, error)
    }
}

@JvmOverloads
fun unlink(
    block: KakaoResult<Unit>.() -> Unit = {}
) {
    user.unlink { error ->
        KakaoResult<Unit>()
            .apply(block)
            .resultWrapper(Unit, error)
    }
}

@JvmOverloads
fun shippingAddresses(
    fromUpdateAt: Date? = null,
    pageSize: Int? = null,
    block: KakaoResult<UserShippingAddresses>.() -> Unit = {}
) {
    user.shippingAddresses(fromUpdateAt, pageSize) { model, error ->
        KakaoResult<UserShippingAddresses>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun shippingAddresses(
    addressId: Long,
    block: KakaoResult<UserShippingAddresses>.() -> Unit = {}
) {
    user.shippingAddresses(addressId) { model, error ->
        KakaoResult<UserShippingAddresses>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun serviceTerms(
    block: KakaoResult<UserServiceTerms>.() -> Unit = {}
) {
    user.serviceTerms { model, error ->
        KakaoResult<UserServiceTerms>()
            .apply(block)
            .resultWrapper(model, error)
    }
}