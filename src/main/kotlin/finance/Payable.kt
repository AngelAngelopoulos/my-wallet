package finance

import java.lang.Exception

interface Payable {


    fun fillCharge(): Float {

        var res = readLine()

        while (!isValidCharge(res)) {
            println("Please enter a valid value.\n Should be higher than 0")
            res = readLine()
        }
        // Si sale del while, no es nulo, pero IDE no lo detecta así, se utiliza...
        // Elvis ?:p
        return res?.toFloat() ?: 0f
    }


    fun isValidCharge(amount: String?): Boolean {

        val fAmount: Float

        if (amount.isNullOrEmpty()) return false

        // Try sustituye al siguiente if:
        //if (amount.filter{ it in '0'..'9' || it == '-' || it == '.'}.length == amount.length){
        try {
            // Son todos numeros, positivos, negativos o floats.
            fAmount = amount.toFloat()
            return fAmount > 0
        }
        //}
        // No es número
        catch (e: Exception) {
            // Atrapa exception, pero no la muestra
            //    println("Exception: $e")
            //else{
           println("I just checked the most recent registered numbers updates, and I don't think \"$amount\" is a valid amount. ")
           return false
        }
    }


    fun fillCategory(options: Map<String,String>): String {
        println("You should choose one of this options or ")

        val getResponse = {
            println("Please, choose one from the next shown categories? (0 cancel)")
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




    fun fillNote(): String {
        println("Add a note (optiona). The length should be fewer than 30 characters")

        var res = readLine()

            while (res.isNullOrEmpty() || res.length > 30 ) {
                if (res.isNullOrEmpty()) return "--"
                else {
                    println("The note is too long. Length should be fewer than 30 characters")
                    res = readLine()
                }
            }

        if (res == ">") return "--"

        return res
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