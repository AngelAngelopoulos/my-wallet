package utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Date {
    private var value = ""
        set(value) {
            field = value
        }
        get() = field

    fun now() : String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        this.value = current.format(formatter)
        println("Current Date and Time is: $value")

        return this.value
    }
}