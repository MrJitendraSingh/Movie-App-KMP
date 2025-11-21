package com.jitendra.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform