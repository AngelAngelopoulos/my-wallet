package personal

import java.lang.Exception
import java.util.*

interface Fillable{

//    fun fillData(required: String): String{
//        var res = readLine()
//        while (res.isNullOrEmpty()){
//            println("Please enter a valid value.\n$required:")
//            res = readLine()
//        }
//        return res
//    }

    fun editDataList(required: Map<String, String>): List<String>{

        var res: String?

        val ansList = required.map { (k, v) ->
            // Saltar con tecla ">"
            println("\nYou can skip this option by entering \">\" ")
            println("$k (Actual value is \"$v\"):")

            res = when (k) {
                "Name" -> fillName(v)
                "Age" -> fillAge(v)
                else -> readLine()
            }

            while (res.isNullOrEmpty()){
                println("Please enter a valid value.\n$k (Actual value is \"$v\"):")
                res = readLine()
            }

            when(res){
                // Deja el valor actual
                ">" -> v
                // Si sale del while de arriba, no es nulo, pero IDE no lo detecta así, se utiliza...
                // Elvis ?:p
                else -> res?: "--"
            }
        }
        return ansList
    }

   fun chooseOption(options: Map<String, String>): String{

        var res= readLine()?.lowercase()

        while (!options.containsKey(res)) {
            println("Please enter a valid value.")
            options.forEach { (k, v) -> println("$k) $v") }
            res = readLine()?.lowercase()
        }
        // Elvis ?:p
        return res?: "0"
    }

    fun fillName(value: String): String{

        var res = readLine()

        while (!isValidName(res)){
            // No es nombre, sino que saltó opción
            if(res== ">")
                if (value == "--") println("You can't skip this field: \"Name\", because it has not been assigned yet.")
                else return res
            else if (res.isNullOrEmpty()) println("Your name can't be empty")
            // Caracteres no válidos
            else println("Your name can't have any special characters. ")

            println("Please enter a valid value.\nName (Actual value is \"$value\"):")
            res = readLine()
        }
        // Si sale del while, no es nulo, pero IDE no lo detecta así, se utiliza...
        // Elvis ?:p
        return res?: "--"
    }

    fun fillAge(value: String): String{

        var res = readLine()

        while (!isValidAge(res)){
            // No es edad, sino que saltó opción
            if(res == ">") return res
            else println("Please enter a valid value.\nAge (Actual value is \"$value\"):")

            res = readLine()
        }
        // Si sale del while, no es nulo, pero IDE no lo detecta así, se utiliza...
        // Elvis ?:p
        return res?.substringBefore('.') ?: "--"
    }

    fun isValidName(name: String?): Boolean {
        // Contiene solo letras y espacios & al menos un caracter es una letra.
        return if (name != null)
            (name.filter { it in 'A'..'Z' || it in 'a'..'z' || it == ' ' }.length == name.length) && name.any { it in 'A'..'Z' || it in 'a'..'z' }
        else false
    }

    fun isValidAge(age: String?): Boolean{

        val iAge: Int

        if (age.isNullOrEmpty()) return false

        // Son todos numeros, positivos, negativos o floats.
        // Try sustituye al siguiente if:
        //if (age.filter{ it in '0'..'9' || it == '-' || it == '.'}.length == age.length){
        try{
            // Es un numero?
            iAge = age.toFloat().toInt()
            when(iAge) {
                in 0..5 -> { println("Babies shouldn't use smartphones..."); return false}
                in 6..14 -> { println("Could we have a few words with your parents?"); return false}
                in 15..50 -> println("Got it!")
                in 51..75 -> println("It's never too late!")
                in 76..110 -> println("Wow, we're impressed!")
                else -> { println("Life is that what happens while you're busy trying to fake your age."); return false}
            }
            return true
        }
        //} Final de if
        // Catch, no es número
        catch(e: Exception) {
            // Atrapa exception, pero no la muestra
            // println("Exception: $e")
            if(age!=">") println("I just checked the most recent registered numbers updates, and I don't think \"$age\" is a valid one. ")
            return false
        }
    }
}