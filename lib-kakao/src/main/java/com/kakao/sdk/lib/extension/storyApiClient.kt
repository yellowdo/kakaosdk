@file:JvmName("Story")

package com.kakao.sdk.lib.extension

import com.kakao.sdk.lib.model.KakaoResult
import com.kakao.sdk.lib.model.resultWrapper
import com.kakao.sdk.story.StoryApiClient
import com.kakao.sdk.story.model.LinkInfo
import com.kakao.sdk.story.model.Story
import com.kakao.sdk.story.model.StoryPostResult
import com.kakao.sdk.story.model.StoryProfile
import java.io.File

@JvmField
val story = StoryApiClient.instance

fun story(block: StoryApiClient.() -> Unit) = StoryApiClient.instance.apply(block)

@JvmOverloads
fun isStoryUser(
    block: KakaoResult<Boolean>.() -> Unit = {}
) {
    story.isStoryUser { model, error ->
        KakaoResult<Boolean>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun profile(
    secureResource: Boolean = true,
    block: KakaoResult<StoryProfile>.() -> Unit = {}
) {
    story.profile(secureResource) { model, error ->
        KakaoResult<StoryProfile>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun story(
    id: String,
    block: KakaoResult<Story>.() -> Unit = {}
) {
    story.story(id) { model, error ->
        KakaoResult<Story>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun stories(
    lastId: String,
    block: KakaoResult<List<Story>>.() -> Unit = {}
) {
    story.stories(lastId) { model, error ->
        KakaoResult<List<Story>>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun postNote(
    content: String,
    permission: Story.Permission = Story.Permission.PUBLIC,
    enableShare: Boolean = true,
    androidExecParams: Map<String, String>? = null,
    iosExecParams: Map<String, String>? = null,
    androidMarketParams: Map<String, String>? = null,
    iosMarketParams: Map<String, String>? = null,
    block: KakaoResult<StoryPostResult>.() -> Unit = {}
) {
    story.postNote(
        content,
        permission,
        enableShare,
        androidExecParams,
        iosExecParams,
        androidMarketParams,
        iosMarketParams
    ) { model, error ->
        KakaoResult<StoryPostResult>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun postPhoto(
    images: List<String>,
    content: String,
    permission: Story.Permission = Story.Permission.PUBLIC,
    enableShare: Boolean = true,
    androidExecParams: Map<String, String>? = null,
    iosExecParams: Map<String, String>? = null,
    androidMarketParams: Map<String, String>? = null,
    iosMarketParams: Map<String, String>? = null,
    block: KakaoResult<StoryPostResult>.() -> Unit = {}
) {
    story.postPhoto(
        images,
        content,
        permission,
        enableShare,
        androidExecParams,
        iosExecParams,
        androidMarketParams,
        iosMarketParams
    ) { model, error ->
        KakaoResult<StoryPostResult>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun postLink(
    linkInfo: LinkInfo,
    content: String,
    permission: Story.Permission = Story.Permission.PUBLIC,
    enableShare: Boolean = true,
    androidExecParams: Map<String, String>? = null,
    iosExecParams: Map<String, String>? = null,
    androidMarketParams: Map<String, String>? = null,
    iosMarketParams: Map<String, String>? = null,
    block: KakaoResult<StoryPostResult>.() -> Unit = {}
) {
    story.postLink(
        linkInfo,
        content,
        permission,
        enableShare,
        androidExecParams,
        iosExecParams,
        androidMarketParams,
        iosMarketParams
    ) { model, error ->
        KakaoResult<StoryPostResult>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun delete(
    id: String,
    block: KakaoResult<Unit>.() -> Unit = {}
) {
    story.delete(id) { error ->
        KakaoResult<Unit>()
            .apply(block)
            .resultWrapper(Unit, error)
    }
}

@JvmOverloads
fun linkInfo(
    url: String,
    block: KakaoResult<LinkInfo>.() -> Unit = {}
) {
    story.linkInfo(url) { model, error ->
        KakaoResult<LinkInfo>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun upload(
    images: List<File>,
    block: KakaoResult<List<String>>.() -> Unit = {}
) {
    story.upload(images) { model, error ->
        KakaoResult<List<String>>()
            .apply(block)
            .resultWrapper(model, error)
    }
}