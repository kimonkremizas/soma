package dk.kimon.soma

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform