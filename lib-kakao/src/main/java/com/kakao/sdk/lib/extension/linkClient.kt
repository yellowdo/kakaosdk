@file:JvmName("Link")

package com.kakao.sdk.lib.extension

import android.content.Context
import com.kakao.sdk.lib.model.KakaoResult
import com.kakao.sdk.lib.model.resultWrapper
import com.kakao.sdk.link.LinkClient
import com.kakao.sdk.link.model.ImageUploadResult
import com.kakao.sdk.link.model.LinkResult
import com.kakao.sdk.template.model.DefaultTemplate
import java.io.File

@JvmField
val link = LinkClient.instance

fun link(block: LinkClient.() -> Unit) = LinkClient.instance.apply(block)

fun Context.isKakaoLinkAvailable() = link.isKakaoLinkAvailable(this)

@JvmOverloads
fun Context.customTemplate(
    templateId: Long,
    templateArgs: Map<String, String>? = null,
    serverCallbackArgs: Map<String, String>? = null,
    block: KakaoResult<LinkResult>.() -> Unit = {}
) {
    link.customTemplate(this, templateId, templateArgs, serverCallbackArgs) { token, error ->
        KakaoResult<LinkResult>()
            .apply(block)
            .resultWrapper(token, error)
    }
}

@JvmOverloads
fun Context.defaultTemplate(
    defaultTemplate: DefaultTemplate,
    serverCallbackArgs: Map<String, String>? = null,
    block: KakaoResult<LinkResult>.() -> Unit = {}
) {
    link.defaultTemplate(this, defaultTemplate, serverCallbackArgs) { token, error ->
        KakaoResult<LinkResult>()
            .apply(block)
            .resultWrapper(token, error)
    }
}

@JvmOverloads
fun Context.scrapTemplate(
    url: String,
    templateId: Long? = null,
    templateArgs: Map<String, String>? = null,
    serverCallbackArgs: Map<String, String>? = null,
    block: KakaoResult<LinkResult>.() -> Unit = {}
) {
    link.scrapTemplate(this, url, templateId, templateArgs, serverCallbackArgs) { token, error ->
        KakaoResult<LinkResult>()
            .apply(block)
            .resultWrapper(token, error)
    }
}

@JvmOverloads
fun uploadImage(
    image: File,
    secureResource: Boolean = true,
    block: KakaoResult<ImageUploadResult>.() -> Unit = {}
) {
    link.uploadImage(
        image,
        secureResource
    ) { token, error ->
        KakaoResult<ImageUploadResult>()
            .apply(block)
            .resultWrapper(token, error)
    }
}

@JvmOverloads
fun scrapImage(
    imageUrl: String,
    secureResource: Boolean = true,
    block: KakaoResult<ImageUploadResult>.() -> Unit = {}
) {
    link.scrapImage(imageUrl, secureResource) { token, error ->
        KakaoResult<ImageUploadResult>()
            .apply(block)
            .resultWrapper(token, error)
    }
}