package utils

class Menu(){

    companion object MenuHandler {

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

    }
}