package utils

import kotlinx.coroutines.delay

class SearchAsync {

    companion object Search {
        suspend fun searchInfo() {
            println()
            println("Connecting with server...")
            delay(1000)
            println("Downloading info..")
            delay(800)
            println("Showing Info...")
            delay(600)
            println()

        }
    }
}