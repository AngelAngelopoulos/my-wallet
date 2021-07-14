package financial

import utils.Menu
import utils.SearchAsync
import java.io.File

class Account(private var id: Int, private var name: String) : Payable {
    private var currency = "MXN"
    private var initialAmount = 0f
    private var totalAmount = 0f
    private var expenses = mutableListOf<Expense>()
    private var incomes = mutableListOf<Income>()

    init {
        println("Please add an Initial amount:")
        initialAmount = fillCharge()
        totalAmount = initialAmount
        println("Your account \"$name\" has been successfully created!!\nNow you can deposit some money here...")
    }

    fun addExpense() {
        val newExp = Expense()
        //println("to account $name")
        //println("${newExp.getAmount()}${currency} to ${this.name} in category ${newExp.getCategory()}.")
        this.expenses.add(newExp)
        applyCharge(-1f * newExp.getAmount())
    }

    fun addIncome() {
        val newInc = Income()
        //println("to account $name")
        //println("${newInc.getAmount()}${currency} to ${this.name} in category ${newInc.getCategory()}.")
        this.incomes.add(newInc)
        applyCharge(newInc.getAmount())
    }

    private fun applyCharge(charge: Float) {
        this.totalAmount += charge
        println("New balance in account $name is: $totalAmount $currency.")
    }

    fun getId(): Int {
        return id
    }

    fun getName(): String {
        return name
    }

    suspend fun showInfo() {
        SearchAsync.searchInfo()
        println(
            """
            ----------------For account $name:----------------
            
            Initial balance: $initialAmount $currency
            Actual balance: $totalAmount $currency
            """.trimIndent()
        )
        println()

        if (incomes.isEmpty()) println("No incomes yet. There is nothing to show.")
        else incomes.forEach { it.showInfo() }

        if (expenses.isEmpty()) println("No expenses yet. There is nothing to show.")
        else expenses.forEach { it.showInfo() }
    }

    suspend fun generateNewReport() {

        println(
            """
                    To generate a new report is necessary to choose the incomes and expenses to include..."""
        )
        println("What would you like include in Report")
        val options = mapOf(
            "a" to "Incomes", "b" to "Expenses", "c" to "All", "0" to "Cancel"
        )
        options.forEach { (k, v) -> println("$k) $v") }
        val option = Menu.chooseOption(options)



        when (option) {
            "a" -> printShortVersions("Incomes")
            "b" -> printShortVersions("Expenses")
            "c" -> printShortVersions("All Charges")
            else -> return
        }

        SearchAsync.printInfo()

    }

    private fun printShortVersions(option: String) {
        println("Write the filename:")

        var filename = readLine()

        while (filename.isNullOrEmpty()) {
            println("Wrog value. Write the filename:")

            filename = readLine()
        }

        val path = "src/main/resources/"
        val myfile = File(path + filename)

        myfile.printWriter().use { out ->

            var cont = 1
            out.println("---------------------${option}----------------------------")
            out.println("----------------------------------------------------------")
            out.println("\tIndex\t|\tDate\t|\tAmount\t")
            out.println("----------------------------------------------------------")
            if (option == "Incomes") {

                incomes.forEach { out.println("${cont++}\t|\t${it.getDate()}\t|\t${it.getAmount()}\t") }
            } else if (option == "Expenses") {
                expenses.forEach { out.println("${cont++}\t|\t${it.getDate()}\t|\t${it.getAmount()}\t") }
            } else {
                out.println("---------------------Incomes----------------------------")
                out.println("----------------------------------------------------------")

                incomes.forEach { out.println("${cont++}\t|\t${it.getDate()}\t|\t${it.getAmount()}\t") }
                cont = 1
                out.println("----------------------------------------------------------")
                out.println("---------------------Expenses----------------------------")
                out.println("----------------------------------------------------------")
                expenses.forEach { out.println("${cont++}\t|\t${it.getDate()}\t|\t-${it.getAmount()}\t") }
            }
            out.println("----------------------------------------------------------")
        }


        println("Writed to file")


    }
}