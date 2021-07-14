package personal

import kotlinx.coroutines.delay

abstract class Info : Fillable {
    abstract var infoType: String



    open suspend fun showInfo() {



        println(
            """Next info will be shown:
            --------------------------$infoType--------------------------.""".trimIndent()
        )
        println()
    }

    open fun editInfo() {
        println(
            """Next info will be edited:
            --------------------------$infoType--------------------------""".trimIndent()
        )
        println()
    }

}