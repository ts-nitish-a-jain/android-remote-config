package com.rakuten.tech.mobile.remoteconfig

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import kotlinx.coroutines.Dispatchers
import okhttp3.Cache
import java.io.File

internal actual val ApplicationDispatcher = Dispatchers.Default

private const val CACHE_SIZE = 1024 * 1024 * 2L

/**
 * Creates the platform specific HttpClient for Android.
 */
fun createHttpClient(cacheDir: File) = HttpClient(OkHttp) {
    engine {
        config {
            cache(Cache(cacheDir, CACHE_SIZE))
        }
    }
}
