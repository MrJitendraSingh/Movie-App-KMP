package com.jitendra.coreNetwork.di

import com.jitendra.coreNetwork.client.HttpClientFactory
import com.jitendra.coreNetwork.service.MovieApiService
import org.koin.core.module.Module
import org.koin.dsl.module


fun getCoreNetworkModule(): Module {
    return module {
        single {
            MovieApiService(HttpClientFactory.getInstance())
        }
    }
}