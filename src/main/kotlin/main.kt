import personal.User
import utils.*
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking{

    val mainMenuOptions = mapOf(
        "a" to "Add an Account",
        "b" to "Add an Income (+)",
        "c" to "Add an Expense (-)",
        "d" to "Edit User's Information",
        "e" to "Show User's Information",
        "f" to "Show Account",
        "g" to "Print Report",
        "h" to "Logout",
        "0" to "Cancel"
    )

    val user = User()
    user.signUp()


    if (user.logIn()) {
        while(user.loggedIn) {
            val getResponse = {
                println("""
                    What would you like to do next?...""")
                mainMenuOptions.forEach { (k, v) -> println("$k) $v") }
                Menu.chooseOption(mainMenuOptions)
            }

            when (getResponse()) {
                "a" -> user.addAccount()
                "b" -> user.addIncome()
                "c" -> user.addExpense()
                "d" -> user.editAllInfo()
                "e" -> user.showUserInfo()
                "f" -> user.showAccMovements()
                "g" -> user.printReport()
                "h" -> user.logOut()

            }


        }

    }
}

