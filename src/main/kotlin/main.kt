import personal.User
import utils.*
import finance.*
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking{

    val mainMenuOptions = mapOf(
        "a" to "Add an Account",
        "b" to "Add an Income (+)",
        "c" to "Add an Expense (-)",
        "d" to "Edit User's Information",
        "e" to "Show User's Information",
        "f" to "Show Account",
        "g" to "Show Categories",
        "h" to "Logout",
        "0" to "Cancel"
    )

    val user = User()
    //user.signUp()


    //if (user.logIn()) {
    if(true){
        //while(user.loggedIn) {
        while(true){
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
                "h" -> user.logOut()

            }


        }

    }
}

////    var account1 = Account("1", "Tarjeta Principal", "MXN")
////    var account2 = Account("1", "Tarjeta Secundaria")
////
////    //var newDate = Date().now()
////
////    var debt = Debt(441.40f, "kjblkjblbj")
////    //debt.printAmount()
////    //println(debt.isPaid())
////    debt.payPartial(42.45f)
////    //debt.payTotal()
////    //debt.printAmount()
////    //println(debt.isPaid())
////    //println(debt.isPaid())
////
////    var gasto = Expense(424.34f)
////    var gasto2 = Expense(32412f, "dfwwefw" )
////    //gasto.printAmount()
////    //gasto2.printAmount()
////
////    //debt.amount
////    //gasto.amount
//
///*var balance = Balance()
//    balance.addDebt(debt)
//    balance.addExpense(gasto)
//    balance.addExpense(gasto2)
//    balance.printBalance()*//*
//
//
//    account1.balance.addDebt(debt)
//    account1.balance.addExpense(gasto)
//    account1.balance.addExpense(gasto2)
//
//    account1.balance.printBalance()
//*/
//

