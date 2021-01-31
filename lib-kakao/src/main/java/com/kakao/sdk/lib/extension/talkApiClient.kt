@file:JvmName("Talk")

package com.kakao.sdk.lib.extension

import com.kakao.sdk.lib.model.KakaoResult
import com.kakao.sdk.lib.model.resultWrapper
import com.kakao.sdk.talk.TalkApiClient
import com.kakao.sdk.talk.model.*
import com.kakao.sdk.template.model.DefaultTemplate

@JvmField
val talk = TalkApiClient.instance

fun talk(block: TalkApiClient.() -> Unit) = TalkApiClient.instance.apply(block)

@JvmOverloads
fun profile(
    block: KakaoResult<TalkProfile>.() -> Unit = {}
) {
    talk.profile { model, error ->
        KakaoResult<TalkProfile>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun friends(
    offset: Int? = null,
    limit: Int? = null,
    order: Order? = null,
    block: KakaoResult<Friends<Friend>>.() -> Unit = {}
) {
    talk.friends(offset, limit, order) { model, error ->
        KakaoResult<Friends<Friend>>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun sendCustomMemo(
    templateId: Long,
    templateArgs: Map<String, String>? = null,
    block: KakaoResult<Unit>.() -> Unit = {}
) {
    talk.sendCustomMemo(templateId, templateArgs) { error ->
        KakaoResult<Unit>()
            .apply(block)
            .resultWrapper(Unit, error)
    }
}

@JvmOverloads
fun DefaultTemplate.sendDefaultMemo(
    block: KakaoResult<Unit>.() -> Unit = {}
) {
    talk.sendDefaultMemo(this) { error ->
        KakaoResult<Unit>()
            .apply(block)
            .resultWrapper(Unit, error)
    }
}

@JvmOverloads
fun sendScrapMemo(
    requestUrl: String,
    templateId: Long? = null,
    templateArgs: Map<String, String>? = null,
    block: KakaoResult<Unit>.() -> Unit = {}
) {
    talk.sendScrapMemo(
        requestUrl,
        templateId,
        templateArgs
    ) { error ->
        KakaoResult<Unit>()
            .apply(block)
            .resultWrapper(Unit, error)
    }
}

@JvmOverloads
fun sendCustomMessage(
    receiverUuids: List<String>,
    templateId: Long,
    templateArgs: Map<String, String>? = null,
    block: KakaoResult<MessageSendResult>.() -> Unit = {}
) {
    talk.sendCustomMessage(
        receiverUuids,
        templateId,
        templateArgs
    ) { model, error ->
        KakaoResult<MessageSendResult>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun sendDefaultMessage(
    receiverUuids: List<String>,
    template: DefaultTemplate,
    block: KakaoResult<MessageSendResult>.() -> Unit = {}
) {
    talk.sendDefaultMessage(
        receiverUuids,
        template
    ) { model, error ->
        KakaoResult<MessageSendResult>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun sendScrapMessage(
    receiverUuids: List<String>,
    requestUrl: String,
    templateId: Long? = null,
    templateArgs: Map<String, String>? = null,
    block: KakaoResult<MessageSendResult>.() -> Unit = {}
) {
    talk.sendScrapMessage(
        receiverUuids,
        requestUrl,
        templateId,
        templateArgs
    ) { model, error ->
        KakaoResult<MessageSendResult>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

@JvmOverloads
fun channels(
    publicIds: List<String>? = null,
    block: KakaoResult<ChannelRelations>.() -> Unit = {}
) {
    talk.channels(publicIds) { model, error ->
        KakaoResult<ChannelRelations>()
            .apply(block)
            .resultWrapper(model, error)
    }
}

fun addChannelUrl(channelPublicId: String) = talk.addChannelUrl(channelPublicId)

fun channelChatUrl(channelPublicId: String) = talk.channelChatUrl(channelPublicId)