package personal

interface Fillable{

    fun fillData(required: String): String{
        var res = readLine()
        while (res.isNullOrEmpty()){
            println("Please enter a valid value.\n$required:")
            res = readLine()
        }
        return res
    }

    @Suppress("UNCHECKED_CAST")
    fun editDataList(required: Map<String, String>): List<String>{

        var res: String?

        val ansList = required.map { (k, v) ->
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
                ">" -> v
                else -> res
            }

        }
        return ansList as List<String>
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

    fun fillName(value: String): String{

        var res = readLine()

        while (res.isNullOrEmpty() || !isValidName(res)){
            if(res== ">")
                if (value == "--") println("You can't skip this field: \"Name\", because it has not been assigned yet.")
                else return res
            else println("Your name can't be empty and can't have special characters either. ")
            println("Please enter a valid value.\nName (Actual value is \"$value\"):")
            res = readLine()
        }
        return res
    }

    fun fillAge(value: String): String{

        var res = readLine()

        while (res.isNullOrEmpty() || !isValidAge(res)){
            if(res == ">") return res
            else {
                println("Please enter a valid value.\nAge (Actual value is \"$value\"):")
                res = readLine()
            }
        }
        return res
    }

    fun isValidName(name: String): Boolean {
        // Contiene solo letras y espacios.
        return (name.filter { it in 'A'..'Z' || it in 'a'..'z' || it == ' '}.length  == name.length)
                && name.filter { it in 'A'..'Z' || it in 'a'..'z' }.isNotEmpty()
    }

    fun isValidAge(age: String): Boolean{

        val iAge: Int
        // Son todos numeros
        if (age.filter{ it in '0'..'9'}.length == age.length){

            iAge = age.toInt()

            when(iAge) {
                    in 0..5 -> { println("Babies shouldn't use smartphones..."); return false}
                    in 6..14 -> { println("Could we have a few words with your parents?"); return false}
                    in 15..50 -> println("Got it!")
                    in 51..75 -> println("It's never too late!")
                    in 76..105 -> println("Wow, we're impressed!")
                else -> return false
            }
            return true
        }
        else return false
    }
}