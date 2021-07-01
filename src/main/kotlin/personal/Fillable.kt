package personal

import java.util.*

interface Fillable{

    fun fillData(required: String): String{
        var res = readLine()
        while (res.isNullOrEmpty()){
            println("Please enter a valid value.\n$required:")
            res = readLine()
        }
        return res
    }

    fun chooseOption(options: Map<String, String>): String{
        var res= readLine()?.lowercase()

        while (!options.containsKey(res)) {
            println("Please enter a valid value.")
            options.forEach { (k, v) -> println("$k) $v") }
            res = readLine()?.lowercase()
        }
        return res!!
    }

}