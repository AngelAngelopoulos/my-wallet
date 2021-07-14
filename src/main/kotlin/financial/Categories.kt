package financial

class Categories(val name: String) {

    companion object categoryL {

        val incomeOptions = mapOf(
            "a" to "Deposit", "b" to "Salary", "c" to "Investment", "d" to "Bonus",
            "e" to "Holiday Pay", "f" to "Rent", "g" to "Sales", "h" to "loans"
        )
            get() = field

        val expendOptions = mapOf(
            "a" to "Transport", "b" to "Food", "c" to "Entertainment", "d" to "Home",
            "e" to "Clothes", "f" to "Health", "g" to "Auto", "h" to "Restaurant"
        )
            get() = field
    }

}







