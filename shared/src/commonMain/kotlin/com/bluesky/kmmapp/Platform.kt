package com.bluesky.kmmapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform