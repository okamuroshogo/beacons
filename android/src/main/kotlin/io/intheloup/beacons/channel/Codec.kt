//  Copyright (c) 2018 Loup Inc.
//  Licensed under Apache License v2.0

package io.intheloup.beacons.channel

import com.squareup.moshi.Moshi
import io.intheloup.beacons.data.Permission
import io.intheloup.beacons.data.Result

object Codec {

    private val moshi: Moshi = Moshi.Builder()
            .add(Permission.Adapter())
//            .add(Priority.Adapter())
//            .add(LocationUpdatesRequest.Strategy.Adapter())
            .build()

    fun encodeResult(result: Result): String =
            moshi.adapter(Result::class.java).toJson(result)

//    fun decodeInt(arguments: Any?): Int =
//            arguments!! as Int
//

    fun decodePermission(arguments: Any?): Permission =
            Permission.Adapter().fromJson(arguments!! as String)

    fun decodeDataRequest(arguments: Any?): DataRequest =
            moshi.adapter(DataRequest::class.java).fromJson(arguments!! as String)!!

}