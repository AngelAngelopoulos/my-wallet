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

        suspend fun printInfo() {
            println()
            println("Generating Report...")
            delay(800)
            println("Printing Report...")
            delay(1200)
            println()

        }
    }

}