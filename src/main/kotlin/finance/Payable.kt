package finance

import java.lang.Exception

interface Payable {

    fun fillCharge(): Float {

        var res = readLine()

        while (!isValidCharge(res)) {
            // No es edad, sino que saltó opción


            println("Please enter a valid value.\n Should be higher than 0")
            res = readLine()
        }
        // Si sale del while, no es nulo, pero IDE no lo detecta así, se utiliza...
        // Elvis ?:p
        return res?.toFloat() ?: 0f
    }


    fun isValidCharge(amount: String?): Boolean {

        val famount: Float
        //..
        if (amount.isNullOrEmpty()) return false

        // Son todos numeros, positivos, negativos o floats.
        // Try sustituye al siguiente if:
        //if (amount.filter{ it in '0'..'9' || it == '-' || it == '.'}.length == amount.length){
        try {
            // Es un numero
            famount = amount.toFloat()

            if (famount <= 0) return false

            return true
        }
        //}
        // No es número
        catch (e: Exception) {
            // Atrapa exception, pero no la muestra
            //    println("Exception: $e")
            //else{
            if (amount != ">") println(
                "I just checked the most recent registered numbers updates, and I don't think " +
                        "\"$amount\" is a valid amount. "
            )
            return false
        }
    }

    fun infoToShow(): String {

        val options = mapOf(
            "a" to "Transport", "b" to "Food", "c" to "Entretainment", "d" to "Home",
            "e" to "Clothes", "f" to "Health", "g" to "Auto"
        )

        val getResponse = {
            println(
                """
            What category want you choose? (0 cancel)"""
            )
            options.forEach { (k, v) -> println("$k) $v") }
            chooseOption(options)
        }

        println("You choose ${getResponse}: ${options[getResponse.toString()]}")
        return options[getResponse.toString()].toString()
    }

    fun chooseOption(options: Map<String, String>): String {

        var res = readLine()?.lowercase()

        while (!options.containsKey(res)) {
            println("Please enter a valid value.")
            options.forEach { (k, v) -> println("$k) $v") }
            res = readLine()?.lowercase()
        }
        // Elvis ?:p
        return res ?: "0"
    }

    fun fillCategory(): String {

        println("You should choose one of this options or ")


        // Si sale del while, no es nulo, pero IDE no lo detecta así, se utiliza...
        // Elvis ?:p
        return infoToShow()
    }

    fun fillNote(): String {
        println("Add a note (optiona). The length should be lower than 30 characters")

        var res = readLine()


            while (res.isNullOrEmpty() || res.length > 30 ) {
                if (res.isNullOrEmpty()) {

                    return "--"
                } else {
                    // No es edad, sino que saltó opción
                    println("The note is too long. The length should be lower than 30 characters")
                    res = readLine()

                }
            }

        if (res == ">") return "--"

        return res
    }


    fun isValidName(name: String?): Boolean {
        // Contiene solo letras y espacios & al menos un caracter es una letra.
        return if (name != null)
            (name.filter { it in 'A'..'Z' || it in 'a'..'z' || it == ' ' }.length == name.length) && name.any { it in 'A'..'Z' || it in 'a'..'z' }
        else false
    }
/*
    fun printAmount() {
        println("----------------------------------------------------------------------------")
        println("Expense")
        println("Date: ${this.date}")
        println("Amount: ${this.amount}")
        //println("Has been payed: ")
        //if (this.paid) print("Yes") else print("No")
        if (this.note.isNotEmpty()) {
            println("Note: ${this.note}")
        }
        println("----------------------------------------------------------------------------")
    }

 */
}