package com.rakuten.tech.mobile.remoteconfig

import io.ktor.client.HttpClient
import io.ktor.client.engine.ios.Ios
import kotlinx.coroutines.Dispatchers
import platform.Foundation.NSURLRequestUseProtocolCachePolicy

internal actual val ApplicationDispatcher = Dispatchers.Current

/**
 * Creates the platform specific HttpClient for iOS.
 */
fun createHttpClient() = HttpClient(Ios) {
    engine {
        configureRequest {
            setCachePolicy(NSURLRequestUseProtocolCachePolicy)
        }
    }
}
