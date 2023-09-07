package com.example.protostore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.user.UserProto

private const val DATA_STORE_FILE_NAME = "user_proto.pb"

internal val Context.userProtoStore: DataStore<UserProto> by dataStore(
    fileName = DATA_STORE_FILE_NAME,
    serializer = UserProtoSerializer
)
