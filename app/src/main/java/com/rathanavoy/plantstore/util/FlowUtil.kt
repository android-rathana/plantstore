package com.rathanavoy.plantstore.util

import kotlinx.coroutines.flow.Flow

fun <T> Flow<T>.handleSubscription(
    onStart: () -> Unit,
    onFinished: () -> Unit,
    onResult: (T) -> Unit,
    onError: (exception: Exception) -> Unit
) {

}