@file:JvmName("Navi")

package com.kakao.sdk.lib.extension

import android.content.Context
import com.kakao.sdk.navi.NaviClient
import com.kakao.sdk.navi.model.Location
import com.kakao.sdk.navi.model.NaviOption

@JvmField
val navi = NaviClient.instance

fun navi(block: NaviClient.() -> Unit) = NaviClient.instance.apply(block)

fun Context.isKakaoNaviInstalled() = navi.isKakaoNaviInstalled(this)

@JvmOverloads
fun Location.navigateWebUrl(
    option: NaviOption? = null,
    viaList: List<Location>? = null
) = navi.navigateWebUrl(this, option, viaList)

@JvmOverloads
fun Location.shareDestinationIntent(
    option: NaviOption? = null,
    viaList: List<Location>? = null
) = navi.shareDestinationIntent(this, option, viaList)

@JvmOverloads
fun Location.navigateIntent(
    option: NaviOption? = null,
    viaList: List<Location>? = null
) = navi.navigateIntent(this, option, viaList)
