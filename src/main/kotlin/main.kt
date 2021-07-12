import personal.User
import finance.*

fun main() {
    //    var account1 = Account("1", "Tarjeta Principal", "MXN")
//    var account2 = Account("1", "Tarjeta Secundaria")
//
//    //var newDate = Date().now()
//
//    var debt = Debt(441.40f, "kjblkjblbj")
//    //debt.printAmount()
//    //println(debt.isPaid())
//    debt.payPartial(42.45f)
//    //debt.payTotal()
//    //debt.printAmount()
//    //println(debt.isPaid())
//    //println(debt.isPaid())
//
//    var gasto = Expense(424.34f)
//    var gasto2 = Expense(32412f, "dfwwefw" )
//    //gasto.printAmount()
//    //gasto2.printAmount()
//
//    //debt.amount
//    //gasto.amount

/*var balance = Balance()
    balance.addDebt(debt)
    balance.addExpense(gasto)
    balance.addExpense(gasto2)
    balance.printBalance()*//*


    account1.balance.addDebt(debt)
    account1.balance.addExpense(gasto)
    account1.balance.addExpense(gasto2)

    account1.balance.printBalance()
*/

    val user = User()

    user.editAllInfo()

    user.showInfo()

    user.editAllInfo()

    user.showInfo()

    user.editAllInfo()

    user.showInfo()


}
